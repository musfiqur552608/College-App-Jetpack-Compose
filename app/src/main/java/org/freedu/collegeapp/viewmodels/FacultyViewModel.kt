package org.freedu.collegeapp.viewmodels

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.storage
import org.freedu.collegeapp.models.BannerModel
import org.freedu.collegeapp.models.FacultyModel
import org.freedu.collegeapp.utils.Constant.BANNER
import org.freedu.collegeapp.utils.Constant.FACULTY
import java.util.UUID

class FacultyViewModel:ViewModel() {
    private val facultyRef = Firebase.firestore.collection(FACULTY)
    private val storageRef = Firebase.storage.reference

    private val _isPosted = MutableLiveData<Boolean>()
    val isPosted:LiveData<Boolean> = _isPosted

    private val _isDeleted = MutableLiveData<Boolean>()
    val isDeleted:LiveData<Boolean> = _isDeleted

    private val _categoryList = MutableLiveData<List<String>>()
    val categoryList:LiveData<List<String>> = _categoryList

    private val _facultyList = MutableLiveData<List<FacultyModel>>()
    val facultyList:LiveData<List<FacultyModel>> = _facultyList

    fun saveFaculty(uri: Uri, name:String, email:String, phone:String, position:String, catName:String) {
        _isPosted.postValue(false)
        val randomUid = UUID.randomUUID().toString()
        val imageRef = storageRef.child("$FACULTY/${randomUid}.jpg")

        val uploadTask = imageRef.putFile(uri)

        uploadTask.addOnSuccessListener {
            imageRef.downloadUrl.addOnSuccessListener {
                uploadFaculty(it.toString(), randomUid, name, email, phone, position, catName)
            }
        }

    }

    private fun uploadFaculty(imageUrl: String, docId: String, name: String, email:String, phone:String, position:String, catName: String) {
        val map = mutableMapOf<String, String>()
        map["imageUrl"] = imageUrl
        map["docId"] = docId
        map["name"] = name
        map["email"] = email
        map["phone"] = phone
        map["position"] = position
        map["catName"] = catName

        facultyRef.document(catName).collection("teacher").document(docId).set(map)
            .addOnSuccessListener {
                _isPosted.postValue(true)
            }
            .addOnFailureListener{
                _isPosted.postValue(false)
            }

    }
    fun uploadCategory(category:String) {
        val map = mutableMapOf<String, String>()
        map["catName"] = category

        facultyRef.document(category).set(map)
            .addOnSuccessListener {
                _isPosted.postValue(true)
            }
            .addOnFailureListener{
                _isPosted.postValue(false)
            }

    }

    fun getFaculty(){
        facultyRef.get()
            .addOnSuccessListener {
                val list = mutableListOf<FacultyModel>()
                for(doc in it){
                    list.add(doc.toObject(FacultyModel::class.java))
                }
                _facultyList.postValue(list)
            }
    }
    fun getCategory(){
        facultyRef.get()
            .addOnSuccessListener {
                val list = mutableListOf<String>()
                for(doc in it){
                    list.add(doc.get("catName").toString())
                }
                _categoryList.postValue(list)
            }
    }

    fun deleteFaculty(facultyModel:FacultyModel){


        facultyRef.document(facultyModel.docId!!).delete()
            .addOnSuccessListener {
                _isDeleted.postValue(true)
                Firebase.storage.getReferenceFromUrl(facultyModel.imageUrl!!).delete()
            }
            .addOnFailureListener {
                _isDeleted.postValue(false)
            }

    }
    fun deleteCategory(category:String){


        facultyRef.document(category).delete()
            .addOnSuccessListener {
                _isDeleted.postValue(true)
            }
            .addOnFailureListener {
                _isDeleted.postValue(false)
            }

    }


}
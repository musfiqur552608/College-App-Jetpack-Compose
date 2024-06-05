package org.freedu.collegeapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.freedu.collegeapp.itemview.FacultyItemView
import org.freedu.collegeapp.navigation.Routes
import org.freedu.collegeapp.viewmodels.FacultyViewModel

@Composable
fun Faculty(navController: NavController) {
    val facultyViewModel:FacultyViewModel = viewModel()
    val categoryList by facultyViewModel.categoryList.observeAsState(null)
    facultyViewModel.getCategory()

    LazyColumn {
        items(categoryList ?: emptyList()) {
            FacultyItemView(it, delete = { docId ->
                facultyViewModel.deleteCategory(docId)
            }, onClick = {
                val routes = Routes.FacultyDetailScreen.route.replace("{catName}", it)
                navController.navigate(routes)
            })
        }
    }

}
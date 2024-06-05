package org.freedu.collegeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import org.freedu.collegeapp.ui.theme.SkyBlue
import org.freedu.collegeapp.viewmodels.CollegeInfoViewModel

@Composable
fun AboutUs() {
    val collegeInfoViewModel: CollegeInfoViewModel = viewModel()
    val collegeInfo by collegeInfoViewModel.collegeInfo.observeAsState(null)
    collegeInfoViewModel.getCollegeInfo()
    Column(modifier = Modifier.padding(8.dp)) {
        if(collegeInfo!=null){
            Image(painter = rememberAsyncImagePainter(model = collegeInfo!!.imageUrl), contentDescription = "College image",
                modifier = Modifier.height(220.dp).fillMaxWidth(), contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = collegeInfo!!.name!!,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = collegeInfo!!.desc!!,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = collegeInfo!!.address!!,
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = collegeInfo!!.websiteLink!!,
                color = SkyBlue,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(12.dp))

        }
    }
}
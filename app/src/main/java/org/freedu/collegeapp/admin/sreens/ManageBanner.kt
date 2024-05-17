package org.freedu.collegeapp.admin.sreens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import org.freedu.collegeapp.R
import org.freedu.collegeapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageBanner(navController: NavController) {
    val context = LocalContext.current
    var imageUri by remember{
        mutableStateOf<Uri?>(null)
    }

    val luncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
        imageUri = it
    }
    Scaffold (
        topBar = {
            TopAppBar(title = {
                Text(text = "Manage Banner", color = Color.White)
            },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Purple40),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null, tint = Color.White)
                    }
                }

            )


        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                luncher.launch("image/*")
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        }
    ){ padding->

        Column(modifier = Modifier.padding(padding)) {
            if(imageUri != null){

                ElevatedCard(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(model = imageUri) ,
                        contentDescription = "banner_image",
                        modifier = Modifier.height(220.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop)
                    Row {
                        Button(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(4.dp)) {
                            Text(text = "Add Image")
                        }
                        OutlinedButton(onClick = { imageUri = null },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(4.dp)) {
                            Text(text = "Cancel")
                        }
                    }
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun ManageBennerView(modifier: Modifier = Modifier) {
    ManageBanner(rememberNavController())
}
package org.freedu.collegeapp.admin.sreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.freedu.collegeapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageBanner(navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(title = {
                Text(text = "Manage Banner", color = Color.White)
            },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Purple40))
        }
    ){ padding->

        Column(modifier = Modifier.padding(padding)) {

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun ManageBennerView(modifier: Modifier = Modifier) {
    ManageBanner(rememberNavController())
}
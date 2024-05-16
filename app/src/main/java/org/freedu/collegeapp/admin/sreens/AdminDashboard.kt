package org.freedu.collegeapp.admin.sreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.freedu.collegeapp.models.DashboardItemModel
import org.freedu.collegeapp.navigation.Routes
import org.freedu.collegeapp.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashBoard(navController: NavController) {
    val list = listOf(
        DashboardItemModel("Manage Banner", Routes.ManageBanner.route),
        DashboardItemModel("Manage Gallery", Routes.ManageGallery.route),
        DashboardItemModel("Manage Faculty", Routes.ManageFaculty.route),
        DashboardItemModel("Manage College Info", Routes.ManageCollegeInfo.route),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Admin Dashboard")
                }
            )
        },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(items = list, itemContent = {
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate(it.route)
                        }) {
                        Text(
                            text = it.title,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                })
            }
        }

    )
}

@Preview(showSystemUi = true)
@Composable
fun AdminDashboardPreview() {
    AdminDashBoard(navController = rememberNavController())
}
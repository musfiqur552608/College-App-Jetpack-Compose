package org.freedu.collegeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.freedu.collegeapp.admin.sreens.AdminDashBoard
import org.freedu.collegeapp.admin.sreens.FacultyDetailScreen
import org.freedu.collegeapp.admin.sreens.ManageBanner
import org.freedu.collegeapp.admin.sreens.ManageCollegeInfo
import org.freedu.collegeapp.admin.sreens.ManageFaculty
import org.freedu.collegeapp.admin.sreens.ManageGallery
import org.freedu.collegeapp.admin.sreens.ManageNotice
import org.freedu.collegeapp.screens.AboutUs
import org.freedu.collegeapp.screens.BottomNav
import org.freedu.collegeapp.screens.Faculty
import org.freedu.collegeapp.screens.Gallery
import org.freedu.collegeapp.screens.Home
import org.freedu.collegeapp.utils.Constant.isAdmin

@Composable
fun NavGraph(navController:NavHostController) {

    NavHost(
        navController = navController,
        startDestination = if(isAdmin)Routes.AdminDashboard.route else Routes.BottomNav.route
    ){
        composable(route = Routes.BottomNav.route){
            BottomNav(navController)
        }
        composable(route = Routes.Home.route){
            Home()
        }
        composable(route = Routes.Gallery.route){
            Gallery()
        }
        composable(route = Routes.AboutUs.route){
            AboutUs()
        }
        composable(route = Routes.Faculty.route){
            Faculty()
        }
        composable(route = Routes.AdminDashboard.route){
            AdminDashBoard(navController)
        }
        composable(route = Routes.ManageBanner.route){
            ManageBanner(navController)
        }
        composable(route = Routes.ManageFaculty.route){
            ManageFaculty(navController)
        }
        composable(route = Routes.ManageGallery.route){
            ManageGallery(navController)
        }
        composable(route = Routes.ManageCollegeInfo.route){
            ManageCollegeInfo()
        }

        composable(route = Routes.ManageNotice.route){
            ManageNotice(navController)
        }
        composable(route = Routes.FacultyDetailScreen.route){
            val data = it.arguments!!.getString("catName")
            FacultyDetailScreen(navController, data!!)
        }
    }
}
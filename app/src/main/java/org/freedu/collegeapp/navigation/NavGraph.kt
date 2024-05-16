package org.freedu.collegeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.freedu.collegeapp.admin.sreens.AdminDashBoard
import org.freedu.collegeapp.admin.sreens.ManageBanner
import org.freedu.collegeapp.admin.sreens.ManageCollegeInfo
import org.freedu.collegeapp.admin.sreens.ManageFaculty
import org.freedu.collegeapp.admin.sreens.ManageGallery
import org.freedu.collegeapp.screens.AboutUs
import org.freedu.collegeapp.screens.BottomNav
import org.freedu.collegeapp.screens.Faculty
import org.freedu.collegeapp.screens.Gallery
import org.freedu.collegeapp.screens.Home

@Composable
fun NavGraph(navController:NavHostController) {
    val isAdmin = true
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
            ManageBanner()
        }
        composable(route = Routes.ManageFaculty.route){
            ManageFaculty()
        }
        composable(route = Routes.ManageGallery.route){
            ManageGallery()
        }
        composable(route = Routes.ManageCollegeInfo.route){
            ManageCollegeInfo()
        }
    }
}
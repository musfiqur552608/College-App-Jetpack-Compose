package org.freedu.collegeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.freedu.collegeapp.screens.AboutUs
import org.freedu.collegeapp.screens.BottomNav
import org.freedu.collegeapp.screens.Faculty
import org.freedu.collegeapp.screens.Gallery
import org.freedu.collegeapp.screens.Home

@Composable
fun NavGraph(navController:NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.BottomNav.route
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
    }
}
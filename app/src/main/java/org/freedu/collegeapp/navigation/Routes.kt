package org.freedu.collegeapp.navigation

sealed class Routes(val route: String) {
    object Home: Routes("home")
    object AboutUs: Routes("about_us")
    object Gallery: Routes("gallery")
    object Faculty: Routes("faculty")
    object BottomNav: Routes("bottom_nav")
}
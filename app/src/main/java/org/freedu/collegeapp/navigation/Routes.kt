package org.freedu.collegeapp.navigation

sealed class Routes(val route: String) {
    object Home: Routes("home")
    object AboutUs: Routes("about_us")
    object Gallery: Routes("gallery")
    object Faculty: Routes("faculty")
    object BottomNav: Routes("bottom_nav")
    object AdminDashboard: Routes("admin_dashboard")
    object ManageBanner: Routes("manage_banner")
    object ManageFaculty: Routes("manage_faculty")
    object ManageGallery: Routes("manage_gallery")
    object ManageCollegeInfo: Routes("college_info")
    object ManageNotice: Routes("manage_notice")
    object FacultyDetailScreen: Routes("faculty_details/{catName}")
}
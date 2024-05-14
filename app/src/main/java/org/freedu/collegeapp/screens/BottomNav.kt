package org.freedu.collegeapp.screens

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.freedu.collegeapp.R
import org.freedu.collegeapp.models.NavItem
import org.freedu.collegeapp.navigation.Routes

@Composable
fun BottomNav(navController: NavController) {
    val navController1 = rememberNavController()
    
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val list = listOf(
        NavItem(
            "Website",
            R.drawable.website,
        ),
        NavItem(
            "Notice",
            R.drawable.notice,
        ),
        NavItem(
            "Notes",
            R.drawable.edit,
        ),
        NavItem(
            "Contact Us",
            R.drawable.contact,
        )


    )

    ModalNavigationDrawer(drawerContent = { /*TODO*/ }) {
        
    }
}
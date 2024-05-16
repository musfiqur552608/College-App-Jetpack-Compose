package org.freedu.collegeapp.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.freedu.collegeapp.R
import org.freedu.collegeapp.models.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(navController: NavController) {
    val navController1 = rememberNavController()
    val context = LocalContext.current

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

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painterResource(id = R.drawable.sayed), contentDescription = null,
                    modifier = Modifier.height(220.dp),
                    contentScale = ContentScale.Crop
                )
                Divider()
                Text(text = "")

                list.forEachIndexed { index, items ->
                    NavigationDrawerItem(label = {
                        Text(text = items.title)
                    }, selected = index == selectedItemIndex, onClick = {
                        Toast.makeText(context, items.title, Toast.LENGTH_SHORT).show()
                        scope.launch {
                            drawerState.close()
                        }
                    }, icon = {
                        Icon(
                            painter = painterResource(id = items.icon), contentDescription = null,
                            modifier = Modifier.height(24.dp)
                        )
                    })
                }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "College App") },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open() }
                            }) {
                                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                            }
                        })
                }
            ) { padding ->
                Column(modifier = Modifier.padding(padding)) {

                }

            }
        }
    )
}
package com.example.quizzapp.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Triple("home", "Início", Icons.Default.Home),
        Triple("quizzes", "Quizzes", Icons.Default.QuestionAnswer),
        Triple("favorites", "Favoritos", Icons.Default.Star)
    )

    NavigationBar {
        val currentDestination = navController.currentBackStackEntry?.destination
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = currentDestination?.hierarchy?.any { it.route == route } == true,
                onClick = { navController.navigate(route) }
            )
        }
    }
}

package com.example.quizzapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quizzapp.navigation.AppNavigation
import com.example.quizzapp.navigation.components.BottomNavigationBar
import com.example.quizzapp.ui.theme.QuizzAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (shouldShowBottomBar(navController)) {
                            BottomNavigationBar(navController)
                        }
                    }
                ) {
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}

// Função para verificar se a barra inferior deve ser exibida
@Composable
fun shouldShowBottomBar(navController: androidx.navigation.NavHostController): Boolean {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val routesWithBottomBar = setOf("home", "quizzes", "favorites")
    return currentRoute in routesWithBottomBar
}

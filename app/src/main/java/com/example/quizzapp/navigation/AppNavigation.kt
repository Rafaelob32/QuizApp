package com.example.quizzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizzapp.screens.HomeScreen
import com.example.quizzapp.screens.QuizDetailScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        // Rota para a tela inicial
        composable("home") {
            HomeScreen(navController)
        }

        // Rota para a tela de detalhes do quiz
        composable("quizDetail/{quizId}") { backStackEntry ->
            val quizId = backStackEntry.arguments?.getString("quizId")
            QuizDetailScreen(quizId = quizId)
        }

        // Rota para a tela de resultados (ajuste conforme necessário)
        composable("result/{score}") { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
            // Implementar tela de resultados aqui
        }
    }
}

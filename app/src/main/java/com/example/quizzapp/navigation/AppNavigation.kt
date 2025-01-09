package com.example.quizzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizzapp.screens.HomeScreen
import com.example.quizzapp.screens.LoginRegister.RegisterScreen
import com.example.quizzapp.screens.LoginScreen
import com.example.quizzapp.screens.QuizCompletionScreen
import com.example.quizzapp.screens.QuizDetailScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        // Rota para a tela de login
        composable("login") {
            LoginScreen(
                onLoginClick = { email, password ->
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        // Rota para a tela de registro
        composable("register") {
            RegisterScreen(
                onRegisterClick = { name, email, password ->
                    navController.navigate("home") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                onBackToLoginClick = {
                    navController.navigate("login") {
                        popUpTo("register") { inclusive = true }
                    }
                }
            )
        }

        // Rota para a tela inicial
        composable("home") {
            HomeScreen(navController)
        }

        // Rota para a tela de detalhes do quiz
        composable("quizDetail/{quizId}") { backStackEntry ->
            val quizId = backStackEntry.arguments?.getString("quizId")
            QuizDetailScreen(quizId = quizId, navController = navController) // Adicionando navController
        }

        // Rota para a tela de conclusão do quiz com parâmetros dinâmicos
        composable("quizCompletion/{score}/{totalQuestions}") { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toInt() ?: 0
            val totalQuestions = backStackEntry.arguments?.getString("totalQuestions")?.toInt() ?: 0
            QuizCompletionScreen(score, totalQuestions)
        }
    }
}

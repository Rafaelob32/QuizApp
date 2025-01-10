package com.example.quizzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        composable(
            route = "quizDetail/{quizId}",
            arguments = listOf(navArgument("quizId") { defaultValue = "0" }) // Adicionando argumento padrão
        ) { backStackEntry ->
            val quizId = backStackEntry.arguments?.getString("quizId")
            QuizDetailScreen(quizId = quizId, navController = navController)
        }

        // Rota para a tela de conclusão do quiz
        composable(
            route = "quizCompletion/{score}/{totalQuestions}",
            arguments = listOf(
                navArgument("score") { defaultValue = "0" },
                navArgument("totalQuestions") { defaultValue = "0" }
            )
        ) { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
            val totalQuestions = backStackEntry.arguments?.getString("totalQuestions")?.toIntOrNull() ?: 0
            QuizCompletionScreen(score = score, totalQuestions = totalQuestions)
        }
    }
}

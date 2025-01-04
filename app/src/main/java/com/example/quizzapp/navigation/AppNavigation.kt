package com.example.quizzapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quizzapp.screens.HomeScreen
import com.example.quizzapp.screens.LoginRegister.RegisterScreen
import com.example.quizzapp.screens.LoginScreen
import com.example.quizzapp.screens.QuizDetailScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        // Rota para a tela de login
        composable("login") {
            LoginScreen(
                onLoginClick = { email, password ->
                    // Implementar lógica de autenticação aqui
                    // Se bem-sucedido, navegar para a tela inicial
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true } // Remove a tela de login da pilha de navegação
                    }
                },
                onRegisterClick = {
                    // Navegar para a tela de registro
                    navController.navigate("register")
                }
            )
        }

        // Rota para a tela de registro
        composable("register") {
            RegisterScreen(
                onRegisterClick = { name, email, password ->
                    // Implementar lógica de registro aqui
                    // Após o sucesso, navegar para a tela inicial
                    navController.navigate("home") {
                        popUpTo("register") { inclusive = true } // Remove a tela de registro da pilha de navegação
                    }
                },
                onBackToLoginClick = {
                    // Voltar para a tela de login
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
            QuizDetailScreen(quizId = quizId)
        }

        // Rota para a tela de resultados (ajuste conforme necessário)
        composable("result/{score}") { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
            // Implementar tela de resultados aqui
        }
    }
}

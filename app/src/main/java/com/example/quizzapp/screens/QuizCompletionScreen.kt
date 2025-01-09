package com.example.quizzapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun QuizCompletionScreen(score: Int, totalQuestions: Int) {
    Scaffold(
        containerColor = Color(0xFF85A6FF), // Background azul claro
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Aplicando o padding do Scaffold
                .padding(horizontal = 16.dp, vertical = 32.dp), // Padding adicional
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Título e pontuação
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color(0xFF1A56D8), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Sua Pontuação",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$score/$totalQuestions",
                            color = Color.White,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = if (score == totalQuestions) "Incrível!" else "Parabéns!",
                    color = Color(0xFF1A56D8),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Ótimo trabalho! Seu conhecimento geral está incrível!",
                    color = Color(0xFF1A56D8),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            // Botões
            Column {
                Button(
                    onClick = { /* Implementar lógica de compartilhamento */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A56D8)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Compartilhar Pontuação",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Button(
                    onClick = { /* Implementar lógica para voltar ao início */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A56D8)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Voltar ao Início",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

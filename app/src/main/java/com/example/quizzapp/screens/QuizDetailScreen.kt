package com.example.quizzapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizDetailScreen(quizId: String?) {
    // Dados fixos para demonstração
    val questionText = "Who is making the Web standards?"
    val options = listOf(
        "The World Wide Web Consortium",
        "Microsoft",
        "Mozilla",
        "Google"
    )
    var selectedOption by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            // Top Bar
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "HTML",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    Text(
                        text = "Quit",
                        color = Color.Red,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { /* Add quit logic here */ }
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pergunta
            Text(
                text = questionText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

            // Opções
            LazyColumn {
                items(options) { option ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(
                                if (option == selectedOption) Color(0xFF004DFF) else Color.LightGray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable { selectedOption = option }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = option,
                            color = if (option == selectedOption) Color.White else Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // Botões "Previous" e "Next"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /* Lógica para Previous */ }) {
                    Text("Previous")
                }
                Button(onClick = { /* Lógica para Next */ }) {
                    Text("Next")
                }
            }
        }
    }
}


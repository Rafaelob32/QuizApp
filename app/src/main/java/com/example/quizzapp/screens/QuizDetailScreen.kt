package com.example.quizzapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizDetailScreen(navController: NavController, quizId: String?) {
    val questions = listOf(
        Question("Qual é o nome da série protagonizada por Eleven?", listOf("Stranger Things", "Dark", "Lost"), "Stranger Things"),
        Question("Em qual país nasceu Freddie Mercury?", listOf("Tanzânia", "Índia", "Reino Unido"), "Tanzânia"),
        Question("Quem pintou a Mona Lisa?", listOf("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh"), "Leonardo da Vinci"),
        Question("Qual é o maior planeta do sistema solar?", listOf("Terra", "Júpiter", "Saturno"), "Júpiter"),
        Question("Quem escreveu 'Dom Casmurro'?", listOf("Machado de Assis", "José de Alencar", "Clarice Lispector"), "Machado de Assis"),
        Question("Qual é a capital da França?", listOf("Paris", "Londres", "Berlim"), "Paris"),
        Question("Em que ano o Brasil foi descoberto?", listOf("1500", "1492", "1800"), "1500"),
        Question("Quem foi o primeiro presidente dos Estados Unidos?", listOf("George Washington", "Abraham Lincoln", "Thomas Jefferson"), "George Washington"),
        Question("Qual é o símbolo químico do Ouro?", listOf("Au", "Ag", "O"), "Au"),
        Question("Quem escreveu 'A Moreninha'?", listOf("Joaquim Manuel de Macedo", "José de Alencar", "Machado de Assis"), "Joaquim Manuel de Macedo"),
        Question("Qual é a montanha mais alta do mundo?", listOf("Everest", "Kilimanjaro", "Aconcágua"), "Everest"),
        Question("Quem é o autor de 'Harry Potter'?", listOf("J.K. Rowling", "George R.R. Martin", "J.R.R. Tolkien"), "J.K. Rowling"),
        Question("Quantos estados tem o Brasil?", listOf("26", "27", "28"), "26"),
        Question("Qual é o maior oceano do mundo?", listOf("Atlântico", "Índico", "Pacífico"), "Pacífico"),
        Question("Qual a cor do cavalo branco de Napoleão?", listOf("Branco", "Preto", "Cinza"), "Branco"),
        Question("Qual é o nome do primeiro satélite artificial?", listOf("Sputnik 1", "Apollo 11", "Hubble"), "Sputnik 1"),
        Question("Quem inventou a lâmpada elétrica?", listOf("Thomas Edison", "Nikola Tesla", "Albert Einstein"), "Thomas Edison"),
        Question("Qual é o maior animal terrestre?", listOf("Elefante", "Girafa", "Rinoceronte"), "Elefante"),
        Question("Onde fica a cidade de Petra?", listOf("Jordânia", "Egito", "Turquia"), "Jordânia"),
        Question("Quem pintou 'O Grito'?", listOf("Edvard Munch", "Vincent van Gogh", "Pablo Picasso"), "Edvard Munch")
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf("") }
    var isAnswered by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    var timer by remember { mutableStateOf(20) }

    val currentQuestion = questions[currentQuestionIndex]

    // Lógica do cronômetro
    LaunchedEffect(currentQuestionIndex) {
        timer = 20
        while (timer > 0) {
            delay(1000L)
            timer -= 1
        }
        if (!isAnswered) {
            isAnswered = true
            selectedOption = ""
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pergunta ${currentQuestionIndex + 1}/${questions.size}", fontWeight = FontWeight.Bold) },
                actions = {
                    Text("Sair", color = Color.Red, modifier = Modifier.clickable { navController.popBackStack() })
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
                text = currentQuestion.text,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Cronômetro
            Text(
                text = "Tempo restante: $timer segundos",
                color = if (timer > 5) Color.Black else Color.Red,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            // Opções
            LazyColumn {
                items(currentQuestion.options.size) { index ->
                    val option = currentQuestion.options[index]
                    val backgroundColor = when {
                        isAnswered && option == currentQuestion.correctAnswer -> Color(0xFF4CAF50) // Verde
                        isAnswered && option == selectedOption && option != currentQuestion.correctAnswer -> Color(0xFFF44336) // Vermelho
                        else -> Color.LightGray
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(backgroundColor, RoundedCornerShape(8.dp))
                            .clickable(enabled = !isAnswered) {
                                if (!isAnswered) {
                                    selectedOption = option
                                    isAnswered = true
                                    if (option == currentQuestion.correctAnswer) {
                                        score++
                                    }
                                }
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(option, fontSize = 18.sp, color = if (isAnswered) Color.White else Color.Black)
                    }
                }
            }

            // Botões de navegação
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (currentQuestionIndex > 0) {
                            currentQuestionIndex -= 1
                            isAnswered = false
                            selectedOption = ""
                        }
                    },
                    enabled = currentQuestionIndex > 0
                ) {
                    Text("Anterior")
                }
                Button(
                    onClick = {
                        if (currentQuestionIndex < questions.size - 1) {
                            currentQuestionIndex += 1
                            isAnswered = false
                            selectedOption = ""
                        } else {
                            // Navegar para a tela de resultados
                            navController.navigate("quizCompletion/$score/${questions.size}")
                        }
                    },
                    enabled = isAnswered
                ) {
                    Text(if (currentQuestionIndex < questions.size - 1) "Próximo" else "Ver resultados")
                }
            }
        }
    }
}

// Classe de dados para as perguntas
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: String
)

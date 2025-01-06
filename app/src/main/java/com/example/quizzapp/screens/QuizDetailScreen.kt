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
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizDetailScreen(quizId: String?) {
    // Lista de perguntas
    val questions = listOf(
        Question(
            text = "Qual é o nome da série protagonizada por Eleven?",
            options = listOf(
                "Stranger Things",
                "The Umbrella Academy",
                "Dark",
                "Lost",
                "The Boys",
                "Supernatural"
            ),
            correctAnswer = "Stranger Things"
        ),
        Question(
            text = "Em qual país nasceu o cantor Freddie Mercury?",
            options = listOf(
                "Reino Unido",
                "Índia",
                "Tanzânia",
                "Estados Unidos",
                "África do Sul",
                "Austrália"
            ),
            correctAnswer = "Tanzânia"
        ),
        Question(
            text = "Quem interpretou Coringa no filme 'Batman: O Cavaleiro das Trevas'?",
            options = listOf(
                "Heath Ledger",
                "Joaquin Phoenix",
                "Jared Leto",
                "Christian Bale",
                "Jack Nicholson",
                "Robert Pattinson"
            ),
            correctAnswer = "Heath Ledger"
        ),
        Question(
            text = "Qual é o nome do vilarejo em 'Game of Thrones' que contém o Trono de Ferro?",
            options = listOf(
                "Winterfell",
                "Porto Real",
                "Braavos",
                "Meereen",
                "Dorne",
                "Pedra do Dragão"
            ),
            correctAnswer = "Porto Real"
        ),
        Question(
            text = "Qual artista lançou o álbum 'Lover'?",
            options = listOf(
                "Beyoncé",
                "Lady Gaga",
                "Taylor Swift",
                "Adele",
                "Billie Eilish",
                "Selena Gomez"
            ),
            correctAnswer = "Taylor Swift"
        ),
        Question(
            text = "Quem é o diretor de Titanic?",
            options = listOf(
                "James Cameron",
                "Steven Spielberg",
                "Martin Scorsese",
                "Quentin Tarantino",
                "Ridley Scott",
                "Christopher Nolan"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual é o nome da peça musical de Andrew Lloyd Webber sobre felinos?",
            options = listOf(
                "Cats",
                "Les Misérables",
                "O Fantasma da Ópera",
                "Hamilton",
                "Chicago",
                " Rent"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual é o nome do filme em que a princesa Elsa canta Let It Go?",
            options = listOf(
                "Frozen",
                "Moana",
                "Valente",
                "Enrolados",
                "Encanto",
                "A Bela e a Fera"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual é o nome do filme que venceu o Oscar de Melhor Filme em 2020?",
            options = listOf(
                "Parasita",
                "1917",
                "Coringa",
                "Era Uma Vez em Hollywood",
                "Ford vs Ferrari",
                "Adoráveis Mulheres"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual série foi responsável pela popularidade de Baby Yoda?",
            options = listOf(
                "The Mandalorian",
                "Obi-Wan Kenobi",
                "Star Wars: Rebels",
                "Clone Wars",
                "Andor",
                "Rogue One"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual cantora ficou famosa com a música Rolling in the Deep?",
            options = listOf(
                "Adele",
                "Amy Winehouse",
                "Taylor Swift",
                "Rihanna",
                "Katy Perry",
                "Alicia Keys"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Em qual filme da Disney aparece o personagem Capitão Gancho?",
            options = listOf(
                "Peter Pan",
                "A Pequena Sereia",
                "Aladdin",
                "Moana",
                "A Bela Adormecida",
                "Hércules"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Quem dirigiu o filme Pulp Fiction?",
            options = listOf(
                "Quentin Tarantino",
                "Martin Scorsese",
                "James Cameron",
                "Francis Ford Coppola",
                "Stanley Kubrick",
                "Ridley Scott"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual é o nome do vilão de \"O Senhor dos Anéis?",
            options = listOf(
                "Saruman",
                "Sauron",
                "Smaug",
                "Morgoth",
                "Gollum",
                "Witch-King"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual franquia tem os personagens Aragorn, Legolas e Gimli?",
            options = listOf(
                "O Senhor dos Anéis",
                "Game of Thrones",
                "Harry Potter",
                "Star Wars",
                "Duna",
                "As Crônicas de Nárnia"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Em que ano foi lançado o primeiro filme da franquia 'Star Wars'?",
            options = listOf(
                "1975",
                "1977",
                "1979",
                "1980",
                "1983",
                "1986"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual é o nome da nave principal em Star Trek?",
            options = listOf(
                "Millennium Falcon",
                "Enterprise",
                "Galactica",
                "Discovery",
                "Normandy",
                "Serenity"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual foi o primeiro filme brasileiro indicado ao Oscar de Melhor Filme Estrangeiro?",
            options = listOf(
                "Central do Brasil",
                "O Pagador de Promessas",
                "Cidade de Deus",
                "Carandiru",
                "Tropa de Elite",
                "Bacurau"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual novela brasileira introduziu a icônica personagem Carminha?",
            options = listOf(
                "Avenida Brasil",
                "Mulheres Apaixonadas",
                "Caminho das Índias",
                "Laços de Família",
                "O Clone",
                "Senhora do Destino"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual música da Legião Urbana começa com o verso 'Ainda que eu falasse a língua dos homens'?",
            options = listOf(
                "Índios",
                "Eduardo e Mônica",
                "Monte Castelo",
                "Tempo Perdido",
                "Pais e Filhos",
                "Será"
            ),
            correctAnswer = "James Cameron"
        ),
        Question(
            text = "Qual banda ficou famosa nos anos 90 com a música 'Mulher de Fases'?",
            options = listOf(
                "Raimundos",
                "Charlie Brown Jr.",
                "Mamonas Assassinas",
                "O Rappa",
                "Detonautas",
                "Skank"
            ),
            correctAnswer = "James Cameron"
        ),
    )

    // Estados para controlar a pergunta atual e a opção selecionada
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf("") }
    var isAnswered by remember { mutableStateOf(false) }
    var timer by remember { mutableStateOf(20) }

    val currentQuestion = questions[currentQuestionIndex]

    // Lógica para o cronômetro
    LaunchedEffect(currentQuestionIndex) {
        timer = 20
        while (timer > 0) {
            delay(1000L)
            timer -= 1
        }
        if (!isAnswered) {
            // Se o tempo acabar e a resposta não foi escolhida
            isAnswered = true
            selectedOption = ""
        }
    }

    Scaffold(
        topBar = {
            // Barra Superior
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Pergunta ${currentQuestionIndex + 1}/${questions.size}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    Text(
                        text = "Sair",
                        color = Color.Red,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { /* Lógica para sair */ }
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
            // Exibição da pergunta
            Text(
                text = currentQuestion.text,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

            // Exibição do cronômetro
            Text(
                text = "Tempo restante: $timer segundos",
                color = if (timer > 5) Color.Black else Color.Red,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            // Exibição das opções
            LazyColumn {
                items(currentQuestion.options.size) { index ->
                    val option = currentQuestion.options[index]
                    val backgroundColor = when {
                        isAnswered && option == currentQuestion.correctAnswer -> Color(0xFF4CAF50) // Verde para correta
                        isAnswered && option == selectedOption && option != currentQuestion.correctAnswer -> Color(0xFFF44336) // Vermelho para errada
                        else -> Color.LightGray
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(
                                color = backgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable(enabled = !isAnswered) {
                                if (!isAnswered) {
                                    selectedOption = option
                                    isAnswered = true
                                }
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = option,
                            color = if (isAnswered) Color.White else Color.Black,
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
                            // Lógica para finalizar o quiz
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

// Classe de dados para representar perguntas
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: String
)

package com.example.quizzapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizzapp.models.Quiz
import com.example.quizzapp.R

val quizList = listOf(
    Quiz(
        id = 1,
        title = "Entretenimento",
        iconRes = R.drawable.pop,
        questionsCount = 30,
        score = 26
    ),
    Quiz(
        id = 2,
        title = "Curiosidades",
        iconRes = R.drawable.pergunta,
        questionsCount = 20,
        score = 18
    ),
    Quiz(
        id = 3,
        title = "Conhecimentos Gerais",
        iconRes = R.drawable.conhecimento,
        questionsCount = 25,
        score = 23
    ),
    Quiz(
        id = 4,
        title = "Desenhos Animados",
        iconRes = R.drawable.donatello,
        questionsCount = 27,
        score = 24
    )
)

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // User Header
        UserHeader(userName = "Miranda Leal", userId = "ID-1809", points = 160)

        // Banner
        Banner(
            title = "Teste Seu Conhecimento Geral com Quizzes.",
            subtitle = "Explore diferentes tópicos e veja o quão longe seu conhecimento pode chegar.",
            buttonText = "Jogar Agora"
        )

        // Categories Section
        CategoriesSection()

        // Recent Activities
        RecentActivitiesSection(navController = navController)
    }
}

@Composable
fun UserHeader(userName: String, userId: String, points: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.muie),
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = userName, style = MaterialTheme.typography.titleMedium)
            Text(text = userId, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$points", style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun Banner(title: String, subtitle: String, buttonText: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Button(onClick = { /* Navegar para tela de quiz */ }) {
                Text(text = buttonText)
            }
        }
    }
}

@Composable
fun CategoriesSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryCard(categoryName = "ENTRETENIMENTO")
        CategoryCard(categoryName = "CURIOSIDADES")
        CategoryCard(categoryName = "CONHE. GERAIS")
        CategoryCard(categoryName = "DESENHOS ANIMADOS")
    }
}

@Composable
fun CategoryCard(categoryName: String) {
    Card(
        modifier = Modifier
            .size(80.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = categoryName, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun RecentActivitiesSection(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Atividades Recentes", style = MaterialTheme.typography.titleSmall)
        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
            items(quizList) { quiz ->
                RecentActivityCard(quiz = quiz, navController = navController)
            }
        }
    }
}

@Composable
fun RecentActivityCard(quiz: Quiz, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate("quizDetail/${'$'}{quiz.id}") },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = quiz.iconRes),
                contentDescription = quiz.title,
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = quiz.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "${quiz.questionsCount} Questões", style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${quiz.score}/${quiz.questionsCount}", style = MaterialTheme.typography.titleSmall)
        }
    }
}

package com.example.quizzapp.models

data class Quiz(
    val id: Int,
    val title: String,
    val iconRes: Int,
    val questionsCount: Int,
    val score: Int
)

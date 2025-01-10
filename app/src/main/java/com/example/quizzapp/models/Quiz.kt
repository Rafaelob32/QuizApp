package com.example.quizzapp.models
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Quiz(
    val id: Int,
    val title: String,
    val iconRes: Int,
    val questionsCount: Int,
    val score: Int,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
)

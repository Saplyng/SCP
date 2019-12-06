package com.example.scp

import androidx.compose.Model
import androidx.compose.frames.ModelList

sealed class Screen {
    object Home : Screen()
    data class Article(val postId: String) : Screen()
    object Picture : Screen()
}

@Model
object StatusScreen {
    var currentScreen: Screen = Screen.Home
    val favorites = ModelList<String>()
    val selectedTopics = ModelList<String>()
}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    StatusScreen.currentScreen = destination
}

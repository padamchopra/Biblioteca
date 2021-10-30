package me.padamchopra.biblioteca.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val blue = Color(0xFF4d6aff)
val pink = Color(0xFFff7094)
val green = Color(0xFF06d6a0)
val darkGrey = Color(0xFF1E1E1E)
val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)

val Colors.appBarContent: Color
    @Composable
    get() = if (isLight) onPrimary else onSurface

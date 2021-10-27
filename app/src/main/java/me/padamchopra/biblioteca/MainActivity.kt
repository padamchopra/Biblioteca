package me.padamchopra.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.padamchopra.biblioteca.navigation.BibliotecaApp
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaTheme {
                // A surface container using the 'background' color from the theme
                BibliotecaApp()
            }
        }
    }
}

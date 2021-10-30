package me.padamchopra.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import me.padamchopra.biblioteca.ui.BibliotecaApp
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.viewmodel.BibliotecaViewModule

class BibliotecaActivity : ComponentActivity() {

    private val viewModel: BibliotecaViewModule by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaTheme {
                BibliotecaApp(
                    viewModel = viewModel
                )
            }
        }
    }
}

package me.padamchopra.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import me.padamchopra.biblioteca.ui.BibliotecaApp
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.viewmodel.BibliotecaViewModel

class BibliotecaActivity : ComponentActivity() {

    private val viewModel: BibliotecaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val payload = intent.getParcelableExtra<BibliotecaPayload>(BibliotecaPayload.EXTRA_KEY)

        payload?.let {
            viewModel.setPayload(it)
        }

        setContent {
            BibliotecaTheme {
                BibliotecaApp(
                    viewModel = viewModel
                )
            }
        }
    }
}

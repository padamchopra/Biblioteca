package me.padamchopra.bibliotecasample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import me.padamchopra.biblioteca.BibliotecaActivity
import me.padamchopra.biblioteca.BibliotecaPayload

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle: BibliotecaPayload = BibliotecaPayload.Builder().build()

        setContent {
            MainActivityContent(bundle)
        }
    }
}

@Composable
private fun MainActivityContent(bundle: BibliotecaPayload) {

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            val intent = Intent(context, BibliotecaActivity::class.java)
            intent.putExtra(BibliotecaPayload.EXTRA_KEY, bundle)
            context.startActivity(intent)
        }) {
            Text(text = "Open Biblioteca")
        }
    }
}

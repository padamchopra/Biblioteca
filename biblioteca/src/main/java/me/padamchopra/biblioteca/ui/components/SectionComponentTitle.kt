package me.padamchopra.biblioteca.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme

@Composable
internal fun SectionComponentTitle(
    text: String
) {
    Text(
        modifier = Modifier.alpha(0.5f),
        text = text,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.onBackground
    )
}

@Preview(name = "Section Component Title", showBackground = true)
@Composable
private fun SectionComponentTitlePreview() {
    BibliotecaTheme {
        SectionComponentTitle(text = "Sample Title")
    }
}

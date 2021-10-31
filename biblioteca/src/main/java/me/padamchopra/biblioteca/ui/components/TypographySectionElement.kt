package me.padamchopra.biblioteca.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.theme.MATERIAL_PADDING

@Composable
internal fun TypographySectionElement(
    name: String,
    textStyle: TextStyle,
    showcaseText: String = "Lorem Ipsum"
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(all = MATERIAL_PADDING)
    ) {
        SectionComponentTitle(text = name)
        Text(
            text = showcaseText,
            style = textStyle
        )
    }
}

@Preview(name = "Typography block", showBackground = true)
@Composable
private fun TypographySectionElementPreview() {
    BibliotecaTheme {
        TypographySectionElement(name = "Heading4", textStyle = MaterialTheme.typography.h4)
    }
}

@Preview(name = "Typography block list", showBackground = true)
@Composable
private fun TypographySectionElementListPreview() {
    BibliotecaTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            TypographySectionElement(name = "Heading4", textStyle = MaterialTheme.typography.h4)
            TypographySectionElement(name = "Body1", textStyle = MaterialTheme.typography.body1)
        }
    }
}

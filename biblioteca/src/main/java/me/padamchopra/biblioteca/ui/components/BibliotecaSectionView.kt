package me.padamchopra.biblioteca.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.biblioteca.models.BibliotecaSection
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.theme.MATERIAL_PADDING

@Composable
internal fun BibliotecaSectionView(
    section: BibliotecaSection
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = MATERIAL_PADDING)) {
        Text(
            modifier = Modifier.padding(horizontal = MATERIAL_PADDING),
            text = section.title,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.onBackground
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(section.composables) { composable ->
                composable()
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.12f)
        )
    }
}

@Preview(name="Biblioteca Section", showBackground = true)
@Composable
private fun BibliotecaSectionPreview() {
    BibliotecaTheme {
        val typographyPreview: @Composable (String, TextStyle) -> Unit = { name, style ->
            TypographySectionElement(name = name, textStyle = style)
        }
        val previewList: List<@Composable () -> Unit> = listOf(
            {typographyPreview("Heading4", MaterialTheme.typography.h4)},
            {typographyPreview("Body1", MaterialTheme.typography.body1)}
        )
        BibliotecaSectionView(section = BibliotecaSection(
            index = 0,
            title = "Typography",
            composables = previewList
        ))
    }
}

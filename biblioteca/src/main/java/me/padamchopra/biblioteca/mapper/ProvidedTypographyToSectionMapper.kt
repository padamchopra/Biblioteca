package me.padamchopra.biblioteca.mapper

import androidx.compose.runtime.Composable
import me.padamchopra.biblioteca.models.BibliotecaSection
import me.padamchopra.biblioteca.models.ProvidedTypography
import me.padamchopra.biblioteca.models.SectionIndexProvider
import me.padamchopra.biblioteca.ui.components.TypographySectionElement

internal class ProvidedTypographyToSectionMapper: DataMapper<SectionIndexProvider<ProvidedTypography>, BibliotecaSection> {
    override fun mapTo(input: SectionIndexProvider<ProvidedTypography>): BibliotecaSection {
        val list: MutableList<@Composable () -> Unit> = mutableListOf()

        for (mapEntry in input.data.map) {
            list.add @Composable {
                TypographySectionElement(
                    name = mapEntry.key,
                    textStyle = mapEntry.value,
                    showcaseText = input.data.showcaseText
                )
            }
        }

        return BibliotecaSection(
            index = input.index,
            title = "Typography",
            composables = list
        )
    }
}
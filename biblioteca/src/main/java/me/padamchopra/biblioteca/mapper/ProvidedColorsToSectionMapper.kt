package me.padamchopra.biblioteca.mapper

import androidx.compose.runtime.Composable
import me.padamchopra.biblioteca.models.BibliotecaSection
import me.padamchopra.biblioteca.models.ProvidedColors
import me.padamchopra.biblioteca.models.SectionIndexProvider
import me.padamchopra.biblioteca.ui.components.ColorSectionElement
import me.padamchopra.biblioteca.utils.ColorSourceType

internal class ProvidedColorsToSectionMapper : DataMapper<SectionIndexProvider<ProvidedColors>, BibliotecaSection> {
    override fun mapTo(input: SectionIndexProvider<ProvidedColors>): BibliotecaSection {
        val list: MutableList<@Composable () -> Unit> = mutableListOf()

        for (mapEntry in input.data.colorSourceType.entries) {
            if (mapEntry.value == ColorSourceType.COMPOSE_COLOR) {
                list.add @Composable {
                    ColorSectionElement(
                        name = mapEntry.key,
                        color = input.data.map[mapEntry.key]
                    )
                }
            } else {
                list.add @Composable {
                    ColorSectionElement(
                        name = mapEntry.key,
                        color = input.data.resourceMap[mapEntry.key]
                    )
                }
            }
        }

        return BibliotecaSection(
            index = input.index,
            title = "Colors",
            composables = list
        )
    }
}
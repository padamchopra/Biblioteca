package me.padamchopra.biblioteca.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.padamchopra.biblioteca.BibliotecaPayload
import me.padamchopra.biblioteca.mapper.ProvidedColorsToSectionMapper
import me.padamchopra.biblioteca.mapper.ProvidedTypographyToSectionMapper
import me.padamchopra.biblioteca.models.BibliotecaSection
import me.padamchopra.biblioteca.models.ProvidedColors
import me.padamchopra.biblioteca.models.ProvidedTypography
import me.padamchopra.biblioteca.models.SectionIndexProvider
import me.padamchopra.biblioteca.utils.PreDefinedSection
import me.padamchopra.biblioteca.utils.Tab

internal class BibliotecaViewModel : ViewModel() {
    private val _activeTab = MutableStateFlow(Tab.THEME_TAB)
    val activeTab: StateFlow<Tab> = _activeTab

    private val _payload = MutableStateFlow<BibliotecaPayload?>(null)
//    val payload: StateFlow<BibliotecaPayload?> = _payload

    private val _themePayload = MutableStateFlow<List<BibliotecaSection>>(listOf())
    val themePayload: StateFlow<List<BibliotecaSection>> = _themePayload

    private val _providedValues = MutableStateFlow<Set<PreDefinedSection>>(setOf())
    val providedValues: StateFlow<Set<PreDefinedSection>> = _providedValues

    fun setPayload(b: BibliotecaPayload) {
        _payload.value = b
        processPayload()
    }

    private fun processPayload() {
        _payload.value?.let { payload ->
            payload.themeColors?.let { colors ->
                processProvidedColors(colors)
            }
            payload.themeTypography?.let { typography ->
                processProvidedTypography(typography)
            }
            payload.themeSections.also { sections ->
                processProvidedThemeSections(sections)
            }
        }
    }

    private fun processProvidedColors(input: ProvidedColors) {
        addToProvidedValues(PreDefinedSection.COLOR)
        val mapper = ProvidedColorsToSectionMapper()
        addToThemePayload(mapper.mapTo(
            SectionIndexProvider(
                index = _themePayload.value.size,
                data = input
            )
        ))
    }

    private fun processProvidedTypography(input: ProvidedTypography) {
        addToProvidedValues(PreDefinedSection.TYPOGRAPHY)
        val mapper = ProvidedTypographyToSectionMapper()
        addToThemePayload(mapper.mapTo(
            SectionIndexProvider(
                index = _themePayload.value.size,
                data = input
            )
        ))
    }

    private fun processProvidedThemeSections(sections: List<BibliotecaSection>) {
        for (section in sections) {
            section.changeIndex(_themePayload.value.size)
            addToThemePayload(section)
        }
    }

    private fun addToProvidedValues(value: PreDefinedSection) {
        _providedValues.value = _providedValues.value.plus(value)
    }

    private fun addToThemePayload(section: BibliotecaSection) {
        _themePayload.value = _themePayload.value.plus(section)
    }

    fun updateActiveTab(tabClicked: Tab) {
        if (_activeTab.value != tabClicked) {
            _activeTab.value = tabClicked
        }
    }
}
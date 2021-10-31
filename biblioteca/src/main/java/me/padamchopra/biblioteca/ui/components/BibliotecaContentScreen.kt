package me.padamchopra.biblioteca.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.biblioteca.R
import me.padamchopra.biblioteca.models.BibliotecaSection
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.theme.MATERIAL_PADDING
import me.padamchopra.biblioteca.ui.viewmodel.BibliotecaViewModel
import me.padamchopra.biblioteca.utils.PreDefinedSection
import me.padamchopra.biblioteca.utils.Tab

@Composable
internal fun BibliotecaContentScreen(
    activeTab: Tab,
    viewModel: BibliotecaViewModel
) {
    if (activeTab == Tab.THEME_TAB) {
        val themePayload by viewModel.themePayload.collectAsState()
        val providedValues by viewModel.providedValues.collectAsState()

        ThemeScreen(
            themePayload = themePayload,
            providedValues = providedValues
        )
    } else {
        ComponentsScreen()
    }
}

@Composable
private fun ThemeScreen(
    themePayload: List<BibliotecaSection>,
    providedValues: Set<PreDefinedSection>
) {
    
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = MATERIAL_PADDING)) {
        if (!providedValues.contains(PreDefinedSection.COLOR) || providedValues.contains(PreDefinedSection.TYPOGRAPHY)) {
            items(1) {
                OnScreenDismissableReminder(text = stringResource(
                    id = when {
                        providedValues.contains(PreDefinedSection.COLOR) -> R.string.bib_missing_typography_reminder
                        providedValues.contains(PreDefinedSection.TYPOGRAPHY) -> R.string.bib_missing_colors_reminder
                        else -> R.string.bib_missing_theme_presets_reminder
                    }
                ))
            }
        }
        items(items = themePayload, key = {
            it.index
        }) { section ->
            BibliotecaSectionView(section)
        }
    }
}

@Composable
private fun ComponentsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(MATERIAL_PADDING),
        contentAlignment = Alignment.Center
    ) {
        BibliotecaUnderDevText()
    }
}

@Preview(name = "Components Screen", showBackground = true)
@Composable
private fun ComponentsScreenPreview() {
    BibliotecaTheme {
        ComponentsScreen()
    }
}

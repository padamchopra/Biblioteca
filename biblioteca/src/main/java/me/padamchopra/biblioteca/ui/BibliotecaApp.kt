package me.padamchopra.biblioteca.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import me.padamchopra.biblioteca.ui.components.BibliotecaContentScreen
import me.padamchopra.biblioteca.ui.components.BibliotecaTopAppBar
import me.padamchopra.biblioteca.ui.viewmodel.BibliotecaViewModel

@Composable
internal fun BibliotecaApp(
    viewModel: BibliotecaViewModel
) {

    val activeTab by viewModel.activeTab.collectAsState()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            BoxWithConstraints {
                BibliotecaTopAppBar(
                    activeTab = activeTab,
                    updateActiveTab = { tab ->
                        viewModel.updateActiveTab(tab)
                    },
                    screenWidth = maxWidth.value
                )
            }
        },
        content = {
            BibliotecaContentScreen(
                activeTab = activeTab,
                viewModel = viewModel
            )
        }
    )
}

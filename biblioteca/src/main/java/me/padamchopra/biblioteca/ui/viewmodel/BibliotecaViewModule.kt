package me.padamchopra.biblioteca.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.padamchopra.biblioteca.utils.Tab

internal class BibliotecaViewModule : ViewModel() {
    private val _activeTab = MutableStateFlow(Tab.THEME_TAB)
    val activeTab: StateFlow<Tab> = _activeTab

    fun updateActiveTab(tabClicked: Tab) {
        if (_activeTab.value != tabClicked) {
            _activeTab.value = tabClicked
        }
    }
}
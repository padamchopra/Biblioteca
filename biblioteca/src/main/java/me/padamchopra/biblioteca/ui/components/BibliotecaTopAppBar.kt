package me.padamchopra.biblioteca.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.theme.MATERIAL_PADDING
import me.padamchopra.biblioteca.ui.theme.MATERIAL_ROUNDED
import me.padamchopra.biblioteca.ui.theme.appBarContent
import me.padamchopra.biblioteca.utils.Tab

@Composable
internal fun BibliotecaTopAppBar(
    activeTab: Tab,
    updateActiveTab: (Tab) -> Unit,
    screenWidth: Float
) {

    val offsetForSecondTab = (screenWidth - (2 * MATERIAL_PADDING.value))/2
    val offset: Float by animateFloatAsState(
        targetValue = if (activeTab == Tab.THEME_TAB) 0f else offsetForSecondTab
    )

    TopAppBar(
        contentPadding = PaddingValues(all = MATERIAL_PADDING)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .offset(x = offset.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .alpha(0.15f)
                    .clip(shape = RoundedCornerShape(MATERIAL_ROUNDED))
                    .background(color = MaterialTheme.colors.appBarContent)
            ) { }
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TopAppBarText(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { updateActiveTab(Tab.THEME_TAB) },
                    text = "Theme"
                )
                TopAppBarText(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { updateActiveTab(Tab.COMPONENTS_TAB) },
                    text = "Components"
                )
            }
        }
    }
}

@Composable
private fun TopAppBarText(
    modifier: Modifier,
    text: String
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.appBarContent
        )
    }
}

@Preview(name= "Top App Bar")
@Composable
private fun BibliotecaTopAppBarPreview() {
    BibliotecaTheme {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            BibliotecaTopAppBar(
                activeTab = Tab.THEME_TAB,
                updateActiveTab = {},
                screenWidth = maxWidth.value
            )
        }
    }
}

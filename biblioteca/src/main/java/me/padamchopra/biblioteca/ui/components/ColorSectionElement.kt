package me.padamchopra.biblioteca.ui.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.padamchopra.biblioteca.R
import me.padamchopra.biblioteca.ui.theme.*

@Composable
internal fun ColorSectionElement(
    name: String,
    color: Color?,
    actionCallback: () -> Unit = {}
) {
    color?.let {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(all = MATERIAL_PADDING)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                SectionComponentTitle(text = name)
//                IconButton(
//                    modifier = Modifier.size(15.dp),
//                    onClick = actionCallback
//                ) {
//                    Icon(
//                        imageVector = Icons.Filled.Edit,
//                        contentDescription = stringResource(id = R.string.bib_edit_desc),
//                        tint = MaterialTheme.colors.onBackground
//                    )
//                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(COLOR_BLOCK_HEIGHT)
                    .clip(RoundedCornerShape(MATERIAL_ROUNDED_SMALL))
                    .background(it)
            )
        }
    }
}

@Composable
internal fun ColorSectionElement(
    name: String,
    @ColorRes color: Int?,
    actionCallback: () -> Unit = {}
) {
    color?.let {
        ColorSectionElement(
            name = name,
            color = colorResource(id = it),
            actionCallback = actionCallback
        )
    }
}

@Preview(name = "Color block", showBackground = true)
@Composable
private fun ColorSectionElementPreview() {
    BibliotecaTheme {
        ColorSectionElement(name = "Pink", color = MaterialTheme.colors.secondary)
    }
}

@Preview(name = "Color block list", showBackground = true)
@Composable
private fun ColorSectionElementListPreview() {
    BibliotecaTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            ColorSectionElement(name = "Blue", color = MaterialTheme.colors.primary)
            ColorSectionElement(name = "Pink", color = MaterialTheme.colors.secondary)
        }
    }
}

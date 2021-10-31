package me.padamchopra.biblioteca.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.padamchopra.biblioteca.R
import me.padamchopra.biblioteca.ui.theme.BibliotecaTheme
import me.padamchopra.biblioteca.ui.theme.MATERIAL_ELEVATION
import me.padamchopra.biblioteca.ui.theme.MATERIAL_PADDING

@Composable
internal fun OnScreenDismissableReminder(
    text: String
) {
    var show by remember { mutableStateOf(true) }

   if (show) {
       Card(
           modifier = Modifier.fillMaxWidth().padding(all = MATERIAL_PADDING),
           backgroundColor = MaterialTheme.colors.surface,
           elevation = MATERIAL_ELEVATION
       ) {
           Row(
               modifier = Modifier.fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Text(
                   modifier = Modifier.weight(1f).padding(all = MATERIAL_PADDING),
                   text = text,
                   style = MaterialTheme.typography.body2
               )
               IconButton(onClick = { show = false }) {
                   Icon(
                       imageVector = Icons.Filled.Close,
                       contentDescription = stringResource(id = R.string.bib_dismiss_desc),
                       tint = MaterialTheme.colors.onSurface
                   )
               }
           }
       }
   }
}

@Preview(name = "On Screen Reminder", showBackground = true)
@Composable
private fun OnScreenDismissableReminderPreview() {
    BibliotecaTheme {
        OnScreenDismissableReminder(text = "Lorem ipsum dolor sit amet")
    }
}

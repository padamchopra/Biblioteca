package me.padamchopra.biblioteca.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
internal fun BibliotecaUnderDevText() {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        withStyle(style = MaterialTheme.typography.body2.copy(
            color = MaterialTheme.colors.onBackground
        ).toSpanStyle()) {
            append(
                "Biblioteca is rapidly changing and this feature is currently under development. \nIf you wish to contribute or suggest changes, check it out on\n"
            )
            withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                pushStringAnnotation(tag = "URL", annotation = "https://github.com/padamchopra/Biblioteca")
                append("GitHub")
                pop()
            }
            append(".")
        }
    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                    context.startActivity(intent)
                }
        }
    )
}

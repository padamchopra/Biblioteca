package me.padamchopra.biblioteca.models

import android.os.Parcelable
import androidx.compose.ui.text.TextStyle
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
class ProvidedTypography private constructor(
    var showcaseText: String = "Lorem Ipsum",
    val map: MutableMap<String, @RawValue TextStyle> = mutableMapOf()
): Parcelable {
    class Builder {
        private val mTypography: ProvidedTypography = ProvidedTypography()

        fun addTextStyle(name: String, textStyle: TextStyle): Builder {
            mTypography.map[name] = textStyle
            return this
        }

        fun setShowcaseText(text: String): Builder {
            mTypography.showcaseText = text
            return this
        }

        fun build(): ProvidedTypography = mTypography
    }
}

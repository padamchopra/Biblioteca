package me.padamchopra.biblioteca.models

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import me.padamchopra.biblioteca.utils.ColorSourceType

@Parcelize
class ProvidedColors private constructor(
    val map: MutableMap<String, @RawValue Color> = mutableMapOf(),
    val resourceMap: MutableMap<String, Int> = mutableMapOf(),
    val colorSourceType: MutableMap<String, ColorSourceType> = mutableMapOf()
): Parcelable {
    class Builder {
        private val mColors: ProvidedColors = ProvidedColors()

        fun addColor(name: String, color: Color): Builder {
            mColors.map[name] = color
            mColors.colorSourceType[name] = ColorSourceType.COMPOSE_COLOR
            return this
        }

        fun addColor(name: String, @ColorRes colorId: Int): Builder {
            mColors.resourceMap[name] = colorId
            mColors.colorSourceType[name] = ColorSourceType.RESOURCE_COLOR
            return this
        }

        fun build(): ProvidedColors = mColors
    }
}

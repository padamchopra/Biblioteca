package me.padamchopra.biblioteca

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import me.padamchopra.biblioteca.models.BibliotecaSection
import me.padamchopra.biblioteca.models.ProvidedColors
import me.padamchopra.biblioteca.models.ProvidedTypography

@Parcelize
class BibliotecaPayload private constructor(
    var themeColors: ProvidedColors? = null,
    var themeTypography: ProvidedTypography? = null,
    var themeSections: List<BibliotecaSection> = listOf()
): Parcelable {
    companion object {
        const val EXTRA_KEY = "biblioteca_bundle"
    }

    class Builder {
        private val mPayload = BibliotecaPayload()

        fun setProvidedColors(colors: ProvidedColors): Builder {
            mPayload.themeColors = colors
            return this
        }

        fun setProvidedColors(colorsBuilder: ProvidedColors.Builder): Builder {
            mPayload.themeColors = colorsBuilder.build()
            return this
        }

        fun setProvidedTypography(typography: ProvidedTypography): Builder {
            mPayload.themeTypography = typography
            return this
        }

        fun setProvidedTypography(typographyBuilder: ProvidedTypography.Builder): Builder {
            mPayload.themeTypography = typographyBuilder.build()
            return this
        }

        fun addExtraThemeSection(section: BibliotecaSection): Builder {
            mPayload.themeSections = mPayload.themeSections.plus(section)
            return this
        }

        fun addExtraThemeSection(sectionBuilder: BibliotecaSection.Builder): Builder {
            mPayload.themeSections = mPayload.themeSections.plus(sectionBuilder.build())
            return this
        }

        fun build(): BibliotecaPayload = mPayload
    }

}

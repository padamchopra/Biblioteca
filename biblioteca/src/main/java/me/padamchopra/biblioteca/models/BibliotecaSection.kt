package me.padamchopra.biblioteca.models

import android.os.Parcelable
import androidx.compose.runtime.Composable
import kotlinx.parcelize.Parcelize

@Parcelize
class BibliotecaSection internal constructor(
    var index: Int = 0,
    var title: String = "Section Title",
    var composables: List<@Composable () -> Unit> = listOf()
): Parcelable {
    class Builder {
        private val mSection: BibliotecaSection = BibliotecaSection()

        fun setTitle(title: String): Builder {
            mSection.title = title
            return this
        }

        fun addComposable(composable: @Composable () -> Unit): Builder {
            mSection.composables = mSection.composables.plus(composable)
            return this
        }

        fun build(): BibliotecaSection = mSection
    }

    internal fun changeIndex(newIndex: Int) {
        this.index = newIndex
    }
}

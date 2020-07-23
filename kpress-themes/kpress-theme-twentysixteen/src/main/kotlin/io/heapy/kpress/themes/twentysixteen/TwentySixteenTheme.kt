package io.heapy.kpress.themes.twentysixteen

import io.heapy.kpress.api.Model
import io.heapy.kpress.theme.api.Theme

/**
 * Port of wordpress twentysixteen theme for docs.
 *
 * @author Ibragimov Ruslan
 * @since 1.0
 */
class TwentySixteenTheme : Theme {
    override val name = TwentySixteenTheme.name

    override fun home(model: Model): String? {
        return "home"
    }

    override fun frontPage(model: Model): String? {
        return null
    }

    override fun index(model: Model): String? {
        return null
    }

    override fun comments(model: Model): String? {
        return null
    }

    override fun single(model: Model): String? {
        return null
    }

    override fun page(model: Model): String? {
        return null
    }

    override fun category(model: Model): String? {
        return null
    }

    override fun tag(model: Model): String? {
        return null
    }

    override fun taxonomy(model: Model): String? {
        return null
    }

    override fun author(model: Model): String? {
        return null
    }

    override fun date(model: Model): String? {
        return null
    }

    override fun archive(model: Model): String? {
        return null
    }

    override fun search(model: Model): String? {
        return null
    }

    override fun attachment(model: Model): String? {
        return null
    }

    override fun image(model: Model): String? {
        return null
    }

    override fun page404(model: Model) = page404Impl(model)

    companion object {
        const val name = "twentysixteen"
    }
}

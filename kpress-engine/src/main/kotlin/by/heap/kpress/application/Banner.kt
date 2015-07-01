package by.heap.kpress.application

import by.heap.kpress.extensions.logger

/**
 * Draws banner.

 * @author Ruslan Ibragimov
 */
interface Banner {

    /**
     * Draws banner.
     */
    fun print()
}

/**
 * Prints kpress banner;

 * @author Ruslan Ibragimov
 */
class KpressBanner : Banner {
    override fun print() {
        LOGGER.info(banner)
    }

    companion object {
        private val LOGGER = logger<KpressBanner>()

        private val banner = """

            _____________________________________
             _   ______________ _____ _____ _____
            | | / /| ___ \ ___ \  ___/  ___/  ___|
            | |/ / | |_/ / |_/ / |__ \ `--.\ `--.
            |    \ |  __/|    /|  __| `--. \`--. \
            | |\  \| |   | |\ \| |___/\__/ /\__/ /
            \_| \_/\_|   \_| \_\____/\____/\____/

            kpress  static  site  generator  v0.1
            _____________________________________
        """.trimIndent()
    }
}

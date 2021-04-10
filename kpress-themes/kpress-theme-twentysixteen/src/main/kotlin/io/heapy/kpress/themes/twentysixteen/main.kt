package io.heapy.kpress.themes.twentysixteen

import kotlinx.html.CommonAttributeGroupFacadeFlowSectioningContent
import kotlinx.html.FlowContent
import kotlinx.html.HTMLTag
import kotlinx.html.SectioningContent
import kotlinx.html.SectioningOrFlowContent
import kotlinx.html.TagConsumer
import kotlinx.html.attributesMapOf
import kotlinx.html.visit

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
open class MAIN(initialAttributes: Map<String, String>, override val consumer: TagConsumer<*>) :
    HTMLTag("main", consumer, initialAttributes, null, false, false),
    CommonAttributeGroupFacadeFlowSectioningContent

fun SectioningOrFlowContent.main(classes: String? = null, block: MAIN.() -> Unit = {}): Unit = MAIN(
    attributesMapOf("class", classes), consumer).visit(block)

val MAIN.asFlowContent: FlowContent
    get() = this

val MAIN.asSectioningContent: SectioningContent
    get() = this

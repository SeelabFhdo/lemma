package de.fhdo.lemma.analyzer

private const val DEFAULT_TEXTWIDTH = 80
private const val DEFAULT_ITEMLEVEL = 0

/**
 * Print a section [heading]. The [textwidth] parameter indicates the width of the surrounding box of section
 * delimiters.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun section(heading: String, textwidth: Int = DEFAULT_TEXTWIDTH) = headingArea(heading, '*', textwidth)

/**
 * Print a heading area, which comprises the given [heading] surrounded by a box of [delimiterChar]s with width
 * [textwidth].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun headingArea(heading: String, delimiterChar: Char = '-', textwidth: Int = DEFAULT_TEXTWIDTH) {
    separator(delimiterChar, textwidth)
    println(heading)
    separator(delimiterChar, textwidth)
}

/**
 * Print a the separator char [c] [count] times.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun separator(c: Char, count: Int = 80) {
    var printString = ""
    repeat(count) { printString += c }
    println(printString)
}

/**
 * Print a subsection [heading]. The [textwidth] parameter indicates the width of the surrounding box of subsection
 * delimiters.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun subsection(heading: String, textwidth: Int = DEFAULT_TEXTWIDTH) = headingArea(heading, '~', textwidth)

/**
 * Print an item of a list with the given [text], possibly prefixed by a [label], at the [DEFAULT_ITEMLEVEL].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun item(text: Any, label: String = "") = println(itemText(text, label, DEFAULT_ITEMLEVEL))

/**
 * Prepare the textual appearance of an item of a list with the given [text], possibly prefixed by a [label], at the
 * given [level].
 */
internal fun itemText(text: Any, label: String = "", level: Int = DEFAULT_ITEMLEVEL) : String {
    val prefix = "${"\t".repeat(level)}- $label" + (if (label.isNotEmpty()) ": " else "")
    return "$prefix$text"
}

/**
 * Print an item of a list with the given [text], possibly prefixed by a [label], at one level above the
 * [DEFAULT_ITEMLEVEL].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun itemItem(text: Any, label: String = "") = println(itemText(text, label, DEFAULT_ITEMLEVEL + 1))

/**
 * Print an item of a list with the given [text], possibly prefixed by a [label], at two levels above the
 * [DEFAULT_ITEMLEVEL].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun itemItemItem(text: Any, label: String = "") = println(itemText(text, label, DEFAULT_ITEMLEVEL + 2))

/**
 * Print an item of a list with the given [text], possibly prefixed by a [label], at three levels above the
 * [DEFAULT_ITEMLEVEL].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun itemItemItemItem(text: Any, label: String = "") = println(itemText(text, label, DEFAULT_ITEMLEVEL + 3))

/**
 * Print an item of a list with the given [text], possibly prefixed by a [label], at four levels above the
 * [DEFAULT_ITEMLEVEL].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun itemItemItemItemItem(text: Any, label: String = "") = println(itemText(text, label, DEFAULT_ITEMLEVEL + 4))

/**
 * Print an item of a list with the given [text], possibly prefixed by a [label], at [levelFromDefault] levels above the
 * [DEFAULT_ITEMLEVEL].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun itemOn(levelFromDefault: Int, text: Any, label: String = "") {
    // If you state itemOn(6) and the default level is one, you expect the item to appear on 6, which effectively is
    // default level plus 5
    val relativeLevel = if (DEFAULT_ITEMLEVEL == 1) levelFromDefault - 1 else levelFromDefault
    println(itemText(text, label, DEFAULT_ITEMLEVEL + relativeLevel))
}

/**
 * Print the entries in the given [Map] [m] as items of a list on the given [itemLevel]. The [String] keys of [m] will
 * be used as labels of the list items and the [toString] lambda may be employed to change their appearance. The item
 * list may further have an explicit [heading] and can be sorted by the keys of [m] ([sortByKey]; default).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T: Any> items(m: Map<String, T>, toString: (String) -> String = {it}, heading: String = "",
    sortByKey: Boolean = true, itemLevel: Int = DEFAULT_ITEMLEVEL + 1) {
    if (heading.isNotEmpty()) {
        val headingLevel = if (itemLevel > 0) itemLevel - 1 else 0
        println(itemText(heading, level = headingLevel))
    }

    val map = if (sortByKey) m.toSortedMap() else m
    map.entries.forEach { (s, v) -> println(itemText(v, toString(s), itemLevel)) }
}

/**
 * Print the entries of the nested [Map] of [m] (i.e., the [Map], which is the value of [m]). This method delegates to
 * [items] to print the entries of the nested [Map]. The [String] keys of [m] will be used as headings for the nested
 * map items. The appearance of these headings can be altered by means of the [toString] lambda.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun <T: Any> nestedMapItems(m: Map<String, Map<String, T>>, toString: (String) -> String = {it},
    heading: String = "", sortByKey: Boolean = true, itemLevel: Int = DEFAULT_ITEMLEVEL + 2) {
    if (heading.isNotEmpty()) {
        val headingLevel = if (itemLevel > 1) itemLevel - 2 else 0
        println(itemText(heading, level = headingLevel))
    }

    val map = if (sortByKey) m.toSortedMap() else m
    map.entries.forEach { (s, nestedMap) ->
        items(nestedMap, heading = toString(s), sortByKey = sortByKey, itemLevel = itemLevel)
    }
}

/**
 * Print a blank line.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun blankLine() = println()
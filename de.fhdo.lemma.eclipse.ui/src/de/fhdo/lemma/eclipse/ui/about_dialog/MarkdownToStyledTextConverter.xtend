package de.fhdo.lemma.eclipse.ui.about_dialog

import org.eclipse.swt.custom.StyleRange
import java.util.regex.Pattern
import java.util.regex.Matcher
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Event
import java.util.List
import java.util.Set
import org.eclipse.swt.program.Program
import de.fhdo.lemma.utils.LemmaUtils
import java.io.InputStream
import java.io.ByteArrayOutputStream

/**
 * Implementation of a simple converter that transforms Markdown-based content into an SWT-based
 * StyledText. Currently, the following Markdown markup elements are supported:
 *  - [foo](bar) for clickable links
 *  - **foobar** for bold text
 *  - *foobar* for italic text
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class MarkdownToStyledTextConverter {
    // The version mark in the input Markdown content will be replaced with a string representation
    // of LEMMA's current version
    val String VERSION_MARK = "\\$VERSION\\$"
    val Pattern LINK = Pattern.compile("\\[(?<text>[^\\]]*)\\]\\((?<link>[^\\)]*)\\)")
    val Pattern BOLDFACE = Pattern.compile("\\*\\*(?<text>.*)\\*\\*")
    val Pattern ITALIC = Pattern.compile("\\*(?<text>.*)\\*")

    /*
     * Assignment of actions to patterns. The actions are responsible for creating the text, which
     * replaces a matched markup pattern in the styled text, and its style.
     */
    val PATTERN_ACTIONS = newLinkedHashMap(
        LINK -> [Matcher m |
            val styleRange = m.toStyleRange("text")
            styleRange.foreground = parent.display.getSystemColor(SWT.COLOR_LINK_FOREGROUND)
            styleRange.data = m.group("link")
            return m.group("text") -> styleRange
        ],

        // We're in a linked hash map and this must come before the ITALIC pattern, because
        // otherwise ITALIC (*...*) would also match BOLDFACE (**...**)
        BOLDFACE -> [Matcher m |
            val styleRange = m.toStyleRange("text")
            styleRange.fontStyle = SWT.BOLD
            return m.group("text") -> styleRange
        ],

        ITALIC -> [Matcher m |
            val styleRange = m.toStyleRange("text")
            styleRange.fontStyle = SWT.ITALIC
            return m.group("text") -> styleRange
        ]
    )

    var Composite parent
    var int style
    var Set<Integer> linkOffsets = newHashSet

    /**
     * Constructor
     */
    new(Composite parent, int style) {
        this.parent = parent
        this.style = style
    }

    /**
     * Convert a Markdown input stream
     */
    def convert(InputStream in) {
        convert(in.readAll)
    }

    /**
     * Helper to convert an InputStream to a String
     */
    private def readAll(InputStream in) {
        val out = new ByteArrayOutputStream();
        var buffer = newByteArrayOfSize(1024)
        var int length;
        while ((length = in.read(buffer)) != -1)
            out.write(buffer, 0, length);
        return out.toString("UTF-8")
    }

    /**
     * Convert a Markdown string
     */
    def convert(String markdown) {
        var content = markdown.replaceAll(VERSION_MARK, LemmaUtils.lemmaVersionAsString)
        val ranges = <StyleRange>newArrayList
        var Pair<Pattern, Matcher> earliestMatch = null
        do {
            // We find the earliest match of one of the markup patterns in the text, execute the
            // assigned action, and replace the markup pattern with the action's result text and
            // style
            earliestMatch = findEarliestMatch(content)
            if (earliestMatch !== null) {
                val actionResult = earliestMatch.executePatternAction
                content = earliestMatch.replaceWith(actionResult, ranges)

                if (earliestMatch.key == LINK)
                    addLinkOffsets(actionResult.value)
            }
        } while(earliestMatch !== null)

        val styledText = new StyledText(parent, style)
        styledText.text = content
        styledText.styleRanges = ranges.toArray(newArrayOfSize(ranges.size))
        styledText.addLinkCursorListener
        styledText.addLinkClickListener

        return styledText
    }

    /**
     * Add listener to styled text that changes the cursor to a "Hand" symbol if it hovers over a
     * styled link
     */
    private def addLinkCursorListener(StyledText styledText) {
        styledText.addListener(SWT.MouseMove, new Listener() {
            override handleEvent(Event event) {
                val offset = styledText.getOffsetAtPoint(new Point(event.x, event.y))
                val cursor = if (hasLinkAtOffset(offset))
                        SWT.CURSOR_HAND
                    else if (styledText.blockSelection)
                        SWT.CURSOR_CROSS
                    else
                        SWT.CURSOR_IBEAM
                styledText.cursor = parent.display.getSystemCursor(cursor)
            }
        })
    }

    /**
     * Add listener to styled text that forwards clicks on styled links to the OS's default
     * application, e.g., a web browser
     */
    private def addLinkClickListener(StyledText styledText) {
        styledText.addListener(SWT.MouseDown, new Listener() {
            override handleEvent(Event event) {
                val offset = styledText.getOffsetAtPoint(new Point(event.x, event.y))

                if (offset == -1) {
                    return
                }

                try {
                    val clickedStyleRange = styledText.getStyleRangeAtOffset(offset)
                    if (clickedStyleRange !== null && hasLinkAtOffset(clickedStyleRange.start))
                        Program.launch(clickedStyleRange.data as String)
                } catch (IllegalArgumentException ex) {
                    // No character at (x, y)
                }
            }
        })
    }

    /**
     * Convert a Java regex Matcher to a basic SWT StyledRange instance
     */
    private def toStyleRange(Matcher m, String replacementGroupName) {
        val styleRange = new StyleRange
        styleRange.start = m.start
        styleRange.length = m.group(replacementGroupName).length
        return styleRange
    }

    /**
     * Find earliest match of one of the markup patterns in a given text. The earliest match is the
     * match with the lowest offset of all markup patterns' matches.
     */
    private def findEarliestMatch(String text) {
        var Matcher earliestMatch = null
        var Pattern matchPattern = null

        for (actionEntry : PATTERN_ACTIONS.entrySet) {
            val pattern = actionEntry.key
            val matcher = pattern.matcher(text)
            if (matcher.find)
                if (earliestMatch === null || matcher.start < earliestMatch.start) {
                    earliestMatch = matcher
                    matchPattern = pattern
                }
        }

        return if (earliestMatch !== null && matchPattern !== null)
                matchPattern -> earliestMatch
            else
                null
    }

    /**
     * Helper to execute a pattern action on a result of findEarliestMatch()
     */
    private def executePatternAction(Pair<Pattern, Matcher> match) {
        val matchPattern = match.key
        val matcher = match.value
        val patternAction = PATTERN_ACTIONS.get(matchPattern)
        return patternAction.apply(matcher)
    }

    /**
     * Helper to replace a match found by findEarliestMatch() with a pattern action's result
     * replacement text. This also adds the action's returned StyleRange to the passed list of
     * StyleRange instances.
     */
    private def replaceWith(Pair<Pattern, Matcher> match, Pair<String, StyleRange> actionResult,
        List<StyleRange> ranges) {
        val matcher = match.value
        val replacementText = actionResult.key
        val styleRange = actionResult.value
        ranges.add(styleRange)
        return matcher.replaceFirst(replacementText)
    }

    /**
     * Helper to collect all ranges comprised by a StyledRange that points to a clickable link
     */
    private def addLinkOffsets(StyleRange styleRange) {
        for (o : 0..<styleRange.length)
            linkOffsets.add(styleRange.start + o)
    }

    /**
     * Helper to check if an offset corresponds to a clickable link
     */
    private def hasLinkAtOffset(int offset) {
        return linkOffsets.contains(offset)
    }
}
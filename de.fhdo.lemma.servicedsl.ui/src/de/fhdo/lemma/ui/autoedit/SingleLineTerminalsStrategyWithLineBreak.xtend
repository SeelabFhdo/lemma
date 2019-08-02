package de.fhdo.lemma.ui.autoedit

import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.DocumentCommand
import org.eclipse.jface.text.BadLocationException
import java.util.regex.Pattern

/**
 * This class provides a custom single-line terminals strategy that considers line breaks. Therefore
 * it inserts an empty line after the left terminal with the whitespace characters in before the
 * current line copied to the empty line. After the empty line, a new line is inserted, which
 * contains the whitespace characters again, followed by the right terminal.
 *
 * This approach allows for using the same left and right terminals. For example, when using the
 * terminal "---" as left and right terminal, the input
 *
 *      ---
 *
 * will result in
 *
 *      ---
 *      |
 *      ---
 *
 * with "|" representing the position of the caret.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SingleLineTerminalsStrategyWithLineBreak extends SingleLineTerminalsStrategy {
    val PRECEDING_WHITESPACES = Pattern.compile("(?<whitespaces>\\s*).*")

    /**
     * Constructor
     */
    new(String left, String right) {
        super(left, right, DEFAULT)
    }

    /**
     * Allow equal left and right terminals
     */
    override boolean allowsEqualTerminals() {
        true
    }

    /**
     * Handle insertion of the left terminal. Significant portions of the code originate from the
     * original method in the super class.
     */
    override handleInsertLeftTerminal(IDocument document, DocumentCommand command)
        throws BadLocationException {
        if (command.text.length() > 0 &&
            appliedText(document, command).endsWith(getLeftTerminal()) &&
            isInsertClosingTerminal(document, command.offset + command.length)) {
            val documentContent = getDocumentContent(document, command)
            val opening = count(getLeftTerminal(), documentContent)
            val closing = count(getRightTerminal(), documentContent)
            val occurences = opening + closing
            if (occurences % 2 == 0) {
                command.shiftsCaret = false

                val currentLineContent = document.lineContent(command.offset)
                val precedingWhitespaces = currentLineContent.precedingWhitespaces
                val whitespaceCount = precedingWhitespaces.length

                // Shift caret by whitespace count
                command.caretOffset = command.offset + command.text.length() + whitespaceCount

                // Insert preceding whitespaces after current text and before the new right
                // terminal including line breaks
                command.text = command.text + precedingWhitespaces.precededByLinebreak +
                    precedingWhitespaces.precededByLinebreak + getRightTerminal()
            }
        }
    }

    /**
     * Get length of line at offset in document
     */
    private def lineLength(IDocument document, int offset) {
        return document.getLineLength(document.getLineOfOffset(offset))
    }

    /**
     * Get content of document's line at offset
     */
    private def lineContent(IDocument document, int offset) {
        return document.get(offset - document.lineLength(offset), document.lineLength(offset))
    }

    /**
     * Get preceding whitespaces of a string
     */
    private def getPrecedingWhitespaces(String s) {
        val matcher = PRECEDING_WHITESPACES.matcher(s)
        return if (matcher.matches)
                matcher.group("whitespaces")
            else
                ""
    }

    /**
     * Precede a string with a line break if it is not already preceded by a line break
     */
    private def precededByLinebreak(String s) {
        return if (!s.startsWith(System.lineSeparator))
                System.lineSeparator + s
            else
                s
    }
}
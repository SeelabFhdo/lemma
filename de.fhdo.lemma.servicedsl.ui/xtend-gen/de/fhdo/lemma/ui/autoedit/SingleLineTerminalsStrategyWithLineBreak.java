package de.fhdo.lemma.ui.autoedit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
@SuppressWarnings("all")
public class SingleLineTerminalsStrategyWithLineBreak extends SingleLineTerminalsStrategy {
  private final Pattern PRECEDING_WHITESPACES = Pattern.compile("(?<whitespaces>\\s*).*");

  /**
   * Constructor
   */
  public SingleLineTerminalsStrategyWithLineBreak(final String left, final String right) {
    super(left, right, SingleLineTerminalsStrategy.DEFAULT);
  }

  /**
   * Allow equal left and right terminals
   */
  @Override
  public boolean allowsEqualTerminals() {
    return true;
  }

  /**
   * Handle insertion of the left terminal. Significant portions of the code originate from the
   * original method in the super class.
   */
  @Override
  public void handleInsertLeftTerminal(final IDocument document, final DocumentCommand command) throws BadLocationException {
    if ((((command.text.length() > 0) && 
      this.appliedText(document, command).endsWith(this.getLeftTerminal())) && 
      this.isInsertClosingTerminal(document, (command.offset + command.length)))) {
      final String documentContent = this.getDocumentContent(document, command);
      final int opening = this.count(this.getLeftTerminal(), documentContent);
      final int closing = this.count(this.getRightTerminal(), documentContent);
      final int occurences = (opening + closing);
      if (((occurences % 2) == 0)) {
        command.shiftsCaret = false;
        final String currentLineContent = this.lineContent(document, command.offset);
        final String precedingWhitespaces = this.getPrecedingWhitespaces(currentLineContent);
        final int whitespaceCount = precedingWhitespaces.length();
        int _length = command.text.length();
        int _plus = (command.offset + _length);
        int _plus_1 = (_plus + whitespaceCount);
        command.caretOffset = _plus_1;
        String _precededByLinebreak = this.precededByLinebreak(precedingWhitespaces);
        String _plus_2 = (command.text + _precededByLinebreak);
        String _precededByLinebreak_1 = this.precededByLinebreak(precedingWhitespaces);
        String _plus_3 = (_plus_2 + _precededByLinebreak_1);
        String _rightTerminal = this.getRightTerminal();
        String _plus_4 = (_plus_3 + _rightTerminal);
        command.text = _plus_4;
      }
    }
  }

  /**
   * Get length of line at offset in document
   */
  private int lineLength(final IDocument document, final int offset) {
    try {
      return document.getLineLength(document.getLineOfOffset(offset));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Get content of document's line at offset
   */
  private String lineContent(final IDocument document, final int offset) {
    try {
      int _lineLength = this.lineLength(document, offset);
      int _minus = (offset - _lineLength);
      return document.get(_minus, this.lineLength(document, offset));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Get preceding whitespaces of a string
   */
  private String getPrecedingWhitespaces(final String s) {
    final Matcher matcher = this.PRECEDING_WHITESPACES.matcher(s);
    String _xifexpression = null;
    boolean _matches = matcher.matches();
    if (_matches) {
      _xifexpression = matcher.group("whitespaces");
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }

  /**
   * Precede a string with a line break if it is not already preceded by a line break
   */
  private String precededByLinebreak(final String s) {
    String _xifexpression = null;
    boolean _startsWith = s.startsWith(System.lineSeparator());
    boolean _not = (!_startsWith);
    if (_not) {
      String _lineSeparator = System.lineSeparator();
      _xifexpression = (_lineSeparator + s);
    } else {
      _xifexpression = s;
    }
    return _xifexpression;
  }
}

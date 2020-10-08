package de.fhdo.lemma.eclipse.ui.about_dialog;

import com.google.common.base.Objects;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of a simple converter that transforms Markdown-based content into an SWT-based
 * StyledText. Currently, the following Markdown markup elements are supported:
 *  - [foo](bar) for clickable links
 *  - **foobar** for bold text
 *  - *foobar* for italic text
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class MarkdownToStyledTextConverter {
  private final String VERSION_MARK = "\\$VERSION\\$";
  
  private final Pattern LINK = Pattern.compile("\\[(?<text>[^\\]]*)\\]\\((?<link>[^\\)]*)\\)");
  
  private final Pattern BOLDFACE = Pattern.compile("\\*\\*(?<text>.*)\\*\\*");
  
  private final Pattern ITALIC = Pattern.compile("\\*(?<text>.*)\\*");
  
  /**
   * Assignment of actions to patterns. The actions are responsible for creating the text, which
   * replaces a matched markup pattern in the styled text, and its style.
   */
  private final LinkedHashMap<Pattern, Function1<Matcher, Pair<String, StyleRange>>> PATTERN_ACTIONS = CollectionLiterals.<Pattern, Function1<Matcher, Pair<String, StyleRange>>>newLinkedHashMap(
    Pair.<Pattern, Function1<Matcher, Pair<String, StyleRange>>>of(this.LINK, ((Function1<Matcher, Pair<String, StyleRange>>) (Matcher m) -> {
      final StyleRange styleRange = this.toStyleRange(m, "text");
      styleRange.foreground = this.parent.getDisplay().getSystemColor(SWT.COLOR_LINK_FOREGROUND);
      styleRange.data = m.group("link");
      String _group = m.group("text");
      return Pair.<String, StyleRange>of(_group, styleRange);
    })), 
    Pair.<Pattern, Function1<Matcher, Pair<String, StyleRange>>>of(this.BOLDFACE, ((Function1<Matcher, Pair<String, StyleRange>>) (Matcher m) -> {
      final StyleRange styleRange = this.toStyleRange(m, "text");
      styleRange.fontStyle = SWT.BOLD;
      String _group = m.group("text");
      return Pair.<String, StyleRange>of(_group, styleRange);
    })), 
    Pair.<Pattern, Function1<Matcher, Pair<String, StyleRange>>>of(this.ITALIC, ((Function1<Matcher, Pair<String, StyleRange>>) (Matcher m) -> {
      final StyleRange styleRange = this.toStyleRange(m, "text");
      styleRange.fontStyle = SWT.ITALIC;
      String _group = m.group("text");
      return Pair.<String, StyleRange>of(_group, styleRange);
    })));
  
  private Composite parent;
  
  private int style;
  
  private Set<Integer> linkOffsets = CollectionLiterals.<Integer>newHashSet();
  
  /**
   * Constructor
   */
  public MarkdownToStyledTextConverter(final Composite parent, final int style) {
    this.parent = parent;
    this.style = style;
  }
  
  /**
   * Convert a Markdown input stream
   */
  public StyledText convert(final InputStream in) {
    return this.convert(this.readAll(in));
  }
  
  /**
   * Helper to convert an InputStream to a String
   */
  private String readAll(final InputStream in) {
    try {
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024];
      int length = 0;
      while (((length = in.read(buffer)) != (-1))) {
        out.write(buffer, 0, length);
      }
      return out.toString("UTF-8");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Convert a Markdown string
   */
  public StyledText convert(final String markdown) {
    String content = markdown.replaceAll(this.VERSION_MARK, LemmaUtils.getLemmaVersionAsString());
    final ArrayList<StyleRange> ranges = CollectionLiterals.<StyleRange>newArrayList();
    Pair<Pattern, Matcher> earliestMatch = null;
    do {
      {
        earliestMatch = this.findEarliestMatch(content);
        if ((earliestMatch != null)) {
          final Pair<String, StyleRange> actionResult = this.executePatternAction(earliestMatch);
          content = this.replaceWith(earliestMatch, actionResult, ranges);
          Pattern _key = earliestMatch.getKey();
          boolean _equals = Objects.equal(_key, this.LINK);
          if (_equals) {
            this.addLinkOffsets(actionResult.getValue());
          }
        }
      }
    } while((earliestMatch != null));
    final StyledText styledText = new StyledText(this.parent, this.style);
    styledText.setText(content);
    styledText.setStyleRanges(ranges.<StyleRange>toArray(new StyleRange[ranges.size()]));
    this.addLinkCursorListener(styledText);
    this.addLinkClickListener(styledText);
    return styledText;
  }
  
  /**
   * Add listener to styled text that changes the cursor to a "Hand" symbol if it hovers over a
   * styled link
   */
  private void addLinkCursorListener(final StyledText styledText) {
    styledText.addListener(SWT.MouseMove, new Listener() {
      @Override
      public void handleEvent(final Event event) {
        Point _point = new Point(event.x, event.y);
        final int offset = styledText.getOffsetAtPoint(_point);
        int _xifexpression = (int) 0;
        boolean _hasLinkAtOffset = MarkdownToStyledTextConverter.this.hasLinkAtOffset(offset);
        if (_hasLinkAtOffset) {
          _xifexpression = SWT.CURSOR_HAND;
        } else {
          int _xifexpression_1 = (int) 0;
          boolean _blockSelection = styledText.getBlockSelection();
          if (_blockSelection) {
            _xifexpression_1 = SWT.CURSOR_CROSS;
          } else {
            _xifexpression_1 = SWT.CURSOR_IBEAM;
          }
          _xifexpression = _xifexpression_1;
        }
        final int cursor = _xifexpression;
        styledText.setCursor(MarkdownToStyledTextConverter.this.parent.getDisplay().getSystemCursor(cursor));
      }
    });
  }
  
  /**
   * Add listener to styled text that forwards clicks on styled links to the OS's default
   * application, e.g., a web browser
   */
  private void addLinkClickListener(final StyledText styledText) {
    styledText.addListener(SWT.MouseDown, new Listener() {
      @Override
      public void handleEvent(final Event event) {
        Point _point = new Point(event.x, event.y);
        final int offset = styledText.getOffsetAtPoint(_point);
        if ((offset == (-1))) {
          return;
        }
        try {
          final StyleRange clickedStyleRange = styledText.getStyleRangeAtOffset(offset);
          if (((clickedStyleRange != null) && MarkdownToStyledTextConverter.this.hasLinkAtOffset(clickedStyleRange.start))) {
            Program.launch(((String) clickedStyleRange.data));
          }
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    });
  }
  
  /**
   * Convert a Java regex Matcher to a basic SWT StyledRange instance
   */
  private StyleRange toStyleRange(final Matcher m, final String replacementGroupName) {
    final StyleRange styleRange = new StyleRange();
    styleRange.start = m.start();
    styleRange.length = m.group(replacementGroupName).length();
    return styleRange;
  }
  
  /**
   * Find earliest match of one of the markup patterns in a given text. The earliest match is the
   * match with the lowest offset of all markup patterns' matches.
   */
  private Pair<Pattern, Matcher> findEarliestMatch(final String text) {
    Matcher earliestMatch = null;
    Pattern matchPattern = null;
    Set<Map.Entry<Pattern, Function1<Matcher, Pair<String, StyleRange>>>> _entrySet = this.PATTERN_ACTIONS.entrySet();
    for (final Map.Entry<Pattern, Function1<Matcher, Pair<String, StyleRange>>> actionEntry : _entrySet) {
      {
        final Pattern pattern = actionEntry.getKey();
        final Matcher matcher = pattern.matcher(text);
        boolean _find = matcher.find();
        if (_find) {
          if (((earliestMatch == null) || (matcher.start() < earliestMatch.start()))) {
            earliestMatch = matcher;
            matchPattern = pattern;
          }
        }
      }
    }
    Pair<Pattern, Matcher> _xifexpression = null;
    if (((earliestMatch != null) && (matchPattern != null))) {
      _xifexpression = Pair.<Pattern, Matcher>of(matchPattern, earliestMatch);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Helper to execute a pattern action on a result of findEarliestMatch()
   */
  private Pair<String, StyleRange> executePatternAction(final Pair<Pattern, Matcher> match) {
    final Pattern matchPattern = match.getKey();
    final Matcher matcher = match.getValue();
    final Function1<Matcher, Pair<String, StyleRange>> patternAction = this.PATTERN_ACTIONS.get(matchPattern);
    return patternAction.apply(matcher);
  }
  
  /**
   * Helper to replace a match found by findEarliestMatch() with a pattern action's result
   * replacement text. This also adds the action's returned StyleRange to the passed list of
   * StyleRange instances.
   */
  private String replaceWith(final Pair<Pattern, Matcher> match, final Pair<String, StyleRange> actionResult, final List<StyleRange> ranges) {
    final Matcher matcher = match.getValue();
    final String replacementText = actionResult.getKey();
    final StyleRange styleRange = actionResult.getValue();
    ranges.add(styleRange);
    return matcher.replaceFirst(replacementText);
  }
  
  /**
   * Helper to collect all ranges comprised by a StyledRange that points to a clickable link
   */
  private void addLinkOffsets(final StyleRange styleRange) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, styleRange.length, true);
    for (final Integer o : _doubleDotLessThan) {
      this.linkOffsets.add(Integer.valueOf((styleRange.start + (o).intValue())));
    }
  }
  
  /**
   * Helper to check if an offset corresponds to a clickable link
   */
  private boolean hasLinkAtOffset(final int offset) {
    return this.linkOffsets.contains(Integer.valueOf(offset));
  }
}

package de.fhdo.lemma.data;

import com.google.common.base.Objects;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Utility methods for dealing with date strings and formats supported by LEMMA.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DateUtils {
  /**
   * Parse a date string in the date formats supported by LEMMA
   */
  public static Date parseDate(final String dateString) {
    final DateTimeFormatter format = DateUtils.determineDateFormat(dateString);
    Date _xtrycatchfinallyexpression = null;
    try {
      Date _switchResult = null;
      boolean _matched = false;
      if (Objects.equal(format, DateTimeFormatter.ISO_LOCAL_DATE)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_OFFSET_DATE)) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_DATE)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = Date.from(LocalDate.parse(dateString, format).atStartOfDay(ZoneId.systemDefault()).toInstant());
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_LOCAL_TIME)) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_OFFSET_TIME)) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_TIME)) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult = Date.from(LocalDate.parse(dateString, format).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_LOCAL_DATE_TIME)) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_OFFSET_DATE_TIME)) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_DATE_TIME)) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult = Date.from(LocalDate.parse(dateString, format).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xtrycatchfinallyexpression = _switchResult;
    } catch (final Throwable _t) {
      if (_t instanceof DateTimeParseException) {
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  /**
   * Determine the date format of a date string from all of LEMMA's supported date formats
   */
  public static DateTimeFormatter determineDateFormat(final String dateString) {
    final ArrayList<DateTimeFormatter> supportedDateFormats = CollectionLiterals.<DateTimeFormatter>newArrayList(
      DateTimeFormatter.ISO_LOCAL_DATE, 
      DateTimeFormatter.ISO_OFFSET_DATE, 
      DateTimeFormatter.ISO_DATE, 
      DateTimeFormatter.ISO_LOCAL_TIME, 
      DateTimeFormatter.ISO_OFFSET_TIME, 
      DateTimeFormatter.ISO_TIME, 
      DateTimeFormatter.ISO_LOCAL_DATE_TIME, 
      DateTimeFormatter.ISO_OFFSET_DATE_TIME, 
      DateTimeFormatter.ISO_DATE_TIME);
    final Function1<DateTimeFormatter, Boolean> _function = (DateTimeFormatter it) -> {
      return Boolean.valueOf(DateUtils.isDateOfFormat(dateString, it));
    };
    return IterableExtensions.<DateTimeFormatter>findFirst(supportedDateFormats, _function);
  }

  /**
   * Check if a date string is of a given date format
   */
  public static boolean isDateOfFormat(final String dateString, final DateTimeFormatter format) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _switchResult = false;
      boolean _matched = false;
      if (Objects.equal(format, DateTimeFormatter.ISO_LOCAL_DATE)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_OFFSET_DATE)) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_DATE)) {
          _matched=true;
        }
      }
      if (_matched) {
        boolean _xblockexpression = false;
        {
          LocalDate.parse(dateString, format);
          _xblockexpression = true;
        }
        _switchResult = _xblockexpression;
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_LOCAL_TIME)) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_OFFSET_TIME)) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_TIME)) {
            _matched=true;
          }
        }
        if (_matched) {
          boolean _xblockexpression_1 = false;
          {
            LocalTime.parse(dateString, format);
            _xblockexpression_1 = true;
          }
          _switchResult = _xblockexpression_1;
        }
      }
      if (!_matched) {
        if (Objects.equal(format, DateTimeFormatter.ISO_LOCAL_DATE_TIME)) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_OFFSET_DATE_TIME)) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (Objects.equal(format, DateTimeFormatter.ISO_DATE_TIME)) {
            _matched=true;
          }
        }
        if (_matched) {
          boolean _xblockexpression_2 = false;
          {
            LocalDateTime.parse(dateString, format);
            _xblockexpression_2 = true;
          }
          _switchResult = _xblockexpression_2;
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xtrycatchfinallyexpression = _switchResult;
    } catch (final Throwable _t) {
      if (_t instanceof DateTimeParseException) {
        _xtrycatchfinallyexpression = false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}

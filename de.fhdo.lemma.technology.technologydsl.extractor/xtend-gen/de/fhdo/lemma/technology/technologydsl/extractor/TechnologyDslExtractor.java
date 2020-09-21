package de.fhdo.lemma.technology.technologydsl.extractor;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.JoinPointType;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Model-to-text extractor for the Technology DSL.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class TechnologyDslExtractor {
  /**
   * Extract TechnologyModel
   */
  public String extractToString(final Technology techModel) {
    final StringBuilder sb = new StringBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("technology ");
    String _name = techModel.getName();
    _builder.append(_name);
    _builder.append(" {");
    sb.append(_builder);
    sb.append("\n");
    EList<Protocol> _protocols = techModel.getProtocols();
    boolean _tripleNotEquals = (_protocols != null);
    if (_tripleNotEquals) {
      sb.append(this.indent("types {"));
      final Function<TechnologySpecificPrimitiveType, String> _function = (TechnologySpecificPrimitiveType it) -> {
        return this.extractToString(it);
      };
      this.<TechnologySpecificPrimitiveType>appendAsSeparatedLines(sb, techModel.getPrimitiveTypes(), _function, false);
      sb.append(this.indent("\n}\n"));
      sb.append(this.indent("protocols {"));
      final Function<Protocol, String> _function_1 = (Protocol it) -> {
        return this.extractToString(it);
      };
      this.<Protocol>appendAsSeparatedLines(sb, techModel.getProtocols(), _function_1, false);
      sb.append(this.indent("\n}\n"));
      sb.append(this.indent("service aspects {"));
      final Function<ServiceAspect, String> _function_2 = (ServiceAspect it) -> {
        return this.extractToString(it);
      };
      this.<ServiceAspect>appendAsSeparatedLines(sb, techModel.getServiceAspects(), _function_2, false);
      sb.append(this.indent("\n}"));
    }
    sb.append("\n}");
    return sb.toString();
  }
  
  /**
   * Adds four whitespaces before a string as indent
   */
  public String indent(final CharSequence string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("    ");
    _builder.append(string, "    ");
    return _builder.toString();
  }
  
  /**
   * Helper to append a list of lines to a StringBuilder and separate them from already existing
   * lines in that StringBuilder by an empty line. If separateConvertedStrings is set to true,
   * even the given lines are separated by an empty line.
   */
  private <T extends Object> void appendAsSeparatedLines(final StringBuilder sb, final List<T> lines, final Function<T, String> stringConverter, final boolean separateConvertedStrings) {
    boolean _isEmpty = lines.isEmpty();
    if (_isEmpty) {
      return;
    }
    if (((sb.length() > 0) && (!sb.toString().endsWith("\n\n")))) {
      boolean _endsWith = sb.toString().endsWith("\n");
      if (_endsWith) {
        sb.append("\n");
      } else {
        sb.append("\n\n");
      }
    }
    String _xifexpression = null;
    if (separateConvertedStrings) {
      _xifexpression = "\n\n";
    } else {
      _xifexpression = "\n";
    }
    final String stringSeparator = _xifexpression;
    final Function1<T, String> _function = (T it) -> {
      return stringConverter.apply(it);
    };
    final String stringLines = IterableExtensions.join(ListExtensions.<T, String>map(lines, _function), stringSeparator);
    sb.append(stringLines);
  }
  
  /**
   * Extract Protocol
   */
  public String extractToString(final Protocol protocol) {
    StringConcatenation _builder = new StringConcatenation();
    {
      CommunicationType _communicationType = protocol.getCommunicationType();
      boolean _equals = Objects.equal(_communicationType, CommunicationType.SYNCHRONOUS);
      if (_equals) {
        _builder.append("sync ");
      } else {
        _builder.append("async ");
      }
    }
    String _name = protocol.getName();
    _builder.append(_name);
    _builder.append(" data formats ");
    {
      EList<DataFormat> _dataFormats = protocol.getDataFormats();
      boolean _hasElements = false;
      for(final DataFormat df : _dataFormats) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _extractToString = this.extractToString(df);
        _builder.append(_extractToString);
      }
    }
    {
      DataFormat _defaultFormat = protocol.getDefaultFormat();
      boolean _tripleNotEquals = (_defaultFormat != null);
      if (_tripleNotEquals) {
        _builder.append(" default with format ");
        String _formatName = protocol.getDefaultFormat().getFormatName();
        _builder.append(_formatName);
      }
    }
    _builder.append(";");
    return this.indent(this.indent(_builder));
  }
  
  /**
   * Extract Aspect
   */
  public String extractToString(final ServiceAspect aspect) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("aspect ");
    String _name = aspect.getName();
    _builder.append(_name);
    {
      boolean _isIsSingleValued = aspect.isIsSingleValued();
      if (_isIsSingleValued) {
        _builder.append("<singleval>");
      }
    }
    _builder.append(" for ");
    {
      EList<JoinPointType> _joinPoints = aspect.getJoinPoints();
      boolean _hasElements = false;
      for(final JoinPointType jp : _joinPoints) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _extractToString = this.extractToString(jp);
        _builder.append(_extractToString);
      }
    }
    _builder.append(";");
    return this.indent(this.indent(_builder));
  }
  
  /**
   * Extract DataFormat
   */
  public String extractToString(final DataFormat dataformat) {
    StringConcatenation _builder = new StringConcatenation();
    String _formatName = dataformat.getFormatName();
    _builder.append(_formatName);
    return _builder.toString();
  }
  
  /**
   * Extract JointPointType
   */
  public String extractToString(final JoinPointType jpt) {
    StringConcatenation _builder = new StringConcatenation();
    String _lowerCase = jpt.getLiteral().toLowerCase();
    _builder.append(_lowerCase);
    return _builder.toString();
  }
  
  /**
   * Extract TechnologySpecificPrimitiveType
   */
  public String extractToString(final TechnologySpecificPrimitiveType type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("primitive type ");
    String _name = type.getName();
    _builder.append(_name);
    _builder.append(" based on ");
    {
      EList<PrimitiveType> _basicBuiltinPrimitiveTypes = type.getBasicBuiltinPrimitiveTypes();
      boolean _hasElements = false;
      for(final PrimitiveType bbp : _basicBuiltinPrimitiveTypes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _typeName = bbp.getTypeName();
        _builder.append(_typeName);
      }
    }
    {
      boolean _isDefault = type.isDefault();
      if (_isDefault) {
        _builder.append(" default");
      }
    }
    _builder.append(";");
    return this.indent(this.indent(_builder));
  }
}

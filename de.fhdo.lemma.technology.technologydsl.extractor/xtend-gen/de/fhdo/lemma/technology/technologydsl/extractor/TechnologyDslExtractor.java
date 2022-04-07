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
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Model-to-text extractor for the Technology DSL.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class TechnologyDslExtractor {
  /**
   * Used as seperator to list, e.g., protocols and types
   */
  private static final String LINE_SEP = System.getProperty("line.separator");
  
  /**
   * Extract TechnologyModel
   */
  public String extractToString(final Technology techModel) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(techModel.getPrimitiveTypes());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("types {");
        _builder.newLine();
        _builder.append("                ");
        {
          EList<TechnologySpecificPrimitiveType> _primitiveTypes = techModel.getPrimitiveTypes();
          boolean _hasElements = false;
          for(final TechnologySpecificPrimitiveType pt : _primitiveTypes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(TechnologyDslExtractor.LINE_SEP, "                ");
            }
            CharSequence _extractToString = this.extractToString(pt);
            _builder.append(_extractToString, "                ");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("            ");
        _builder.append("}");
        _builder.newLine();
        _xifexpression = _builder.toString();
      }
      final String types = _xifexpression;
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(techModel.getProtocols());
      boolean _not_1 = (!_isNullOrEmpty_1);
      if (_not_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("protocols {");
        _builder_1.newLine();
        _builder_1.append("                ");
        {
          EList<Protocol> _protocols = techModel.getProtocols();
          boolean _hasElements_1 = false;
          for(final Protocol pr : _protocols) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder_1.appendImmediate(TechnologyDslExtractor.LINE_SEP, "                ");
            }
            CharSequence _extractToString_1 = this.extractToString(pr);
            _builder_1.append(_extractToString_1, "                ");
          }
        }
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("            ");
        _builder_1.append("}");
        _builder_1.newLine();
        _xifexpression_1 = _builder_1.toString();
      }
      final String protocols = _xifexpression_1;
      String _xifexpression_2 = null;
      boolean _isNullOrEmpty_2 = IterableExtensions.isNullOrEmpty(techModel.getServiceAspects());
      boolean _not_2 = (!_isNullOrEmpty_2);
      if (_not_2) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("service aspects {");
        _builder_2.newLine();
        _builder_2.append("                ");
        {
          EList<ServiceAspect> _serviceAspects = techModel.getServiceAspects();
          boolean _hasElements_2 = false;
          for(final ServiceAspect sa : _serviceAspects) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder_2.appendImmediate(TechnologyDslExtractor.LINE_SEP, "                ");
            }
            CharSequence _extractToString_2 = this.extractToString(sa);
            _builder_2.append(_extractToString_2, "                ");
          }
        }
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("            ");
        _builder_2.append("}");
        _builder_2.newLine();
        _xifexpression_2 = _builder_2.toString();
      }
      final String aspects = _xifexpression_2;
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("technology ");
      String _name = techModel.getName();
      _builder_3.append(_name);
      _builder_3.append(" {");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("            ");
      _builder_3.append(types, "            ");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("            ");
      _builder_3.append(protocols, "            ");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("            ");
      _builder_3.append(aspects, "            ");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("        ");
      _builder_3.append("}");
      _builder_3.newLine();
      _xblockexpression = _builder_3.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Protocol
   */
  public CharSequence extractToString(final Protocol protocol) {
    CharSequence _xblockexpression = null;
    {
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
      final String comm = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        EList<DataFormat> _dataFormats = protocol.getDataFormats();
        boolean _hasElements = false;
        for(final DataFormat df : _dataFormats) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate(", ", "");
          }
          _builder_1.append("\"");
          String _extractToString = this.extractToString(df);
          _builder_1.append(_extractToString);
          _builder_1.append("\"");
        }
      }
      final String formats = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      {
        DataFormat _defaultFormat = protocol.getDefaultFormat();
        boolean _tripleNotEquals = (_defaultFormat != null);
        if (_tripleNotEquals) {
          _builder_2.append(" default with format \"");
          String _formatName = protocol.getDefaultFormat().getFormatName();
          _builder_2.append(_formatName);
          _builder_2.append("\"");
        }
      }
      final String defaultFormat = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(comm);
      String _name = protocol.getName();
      _builder_3.append(_name);
      _builder_3.append(" data formats ");
      _builder_3.append(formats);
      _builder_3.append(defaultFormat);
      _builder_3.append(";");
      _xblockexpression = _builder_3;
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Aspect
   */
  public CharSequence extractToString(final ServiceAspect aspect) {
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
    return _builder;
  }
  
  /**
   * Extract DataFormat
   */
  public String extractToString(final DataFormat dataformat) {
    return dataformat.getFormatName();
  }
  
  /**
   * Extract JointPointType
   */
  public String extractToString(final JoinPointType jpt) {
    return jpt.getName().toLowerCase();
  }
  
  /**
   * Extract TechnologySpecificPrimitiveType
   */
  public CharSequence extractToString(final TechnologySpecificPrimitiveType type) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
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
      final String basicTypes = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("primitive type ");
      String _name = type.getName();
      _builder_1.append(_name);
      _builder_1.append(" based on ");
      _builder_1.append(basicTypes);
      {
        boolean _isDefault = type.isDefault();
        if (_isDefault) {
          _builder_1.append(" default");
        }
      }
      _builder_1.append(";");
      _xblockexpression = _builder_1;
    }
    return _xblockexpression;
  }
}

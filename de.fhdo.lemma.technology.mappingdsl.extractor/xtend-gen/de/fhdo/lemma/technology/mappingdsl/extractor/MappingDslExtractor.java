package de.fhdo.lemma.technology.mappingdsl.extractor;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Model-to-text extractor for the Mapping DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class MappingDslExtractor {
  /**
   * Extract TechnologyMapping
   */
  public String extractToString(final TechnologyMapping mappingModel) {
    final StringBuilder sb = new StringBuilder();
    final Function<Import, String> _function = (Import it) -> {
      return this.extractToString(it);
    };
    this.<Import>appendAsSeparatedLines(sb, mappingModel.getImports(), _function);
    final Function<ComplexTypeMapping, String> _function_1 = (ComplexTypeMapping it) -> {
      return this.extractToString(it);
    };
    this.<ComplexTypeMapping>appendAsSeparatedLines(sb, mappingModel.getTypeMappings(), _function_1);
    return sb.toString();
  }
  
  /**
   * Helper to append a list of lines to a StringBuilder and separate them from already existing
   * lines in that StringBuilder by an empty line
   */
  private <T extends Object> void appendAsSeparatedLines(final StringBuilder sb, final List<T> lines, final Function<T, String> stringConverter) {
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
    final Function1<T, String> _function = (T it) -> {
      return stringConverter.apply(it);
    };
    final String stringLines = IterableExtensions.join(ListExtensions.<T, String>map(lines, _function), "\n");
    sb.append(stringLines);
  }
  
  /**
   * Extract Import
   */
  public String extractToString(final Import _import) {
    String _xblockexpression = null;
    {
      String _switchResult = null;
      ImportType _importType = _import.getImportType();
      if (_importType != null) {
        switch (_importType) {
          case DATATYPES:
            _switchResult = "datatypes";
            break;
          case MICROSERVICES:
            _switchResult = "microservices";
            break;
          case TECHNOLOGY:
            _switchResult = "technology";
            break;
          default:
            break;
        }
      }
      final String importTypeString = _switchResult;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import ");
      _builder.append(importTypeString);
      _builder.append(" from ");
      String _importURI = _import.getImportURI();
      _builder.append(_importURI);
      _builder.append(" as ");
      String _name = _import.getName();
      _builder.append(_name);
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract ComplexTypeMapping
   */
  public String extractToString(final ComplexTypeMapping mapping) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<TechnologyReference> _technologyReferences = mapping.getTechnologyReferences();
      boolean _hasElements = false;
      for(final TechnologyReference r : _technologyReferences) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _extractToString = this.extractToString(r);
        _builder.append(_extractToString);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("type ");
    String _extractToString_1 = this.extractToString(mapping.getType());
    _builder.append(_extractToString_1);
    final String preamble = _builder.toString();
    if (((mapping.getAspects().isEmpty() && 
      mapping.getFieldMappings().isEmpty()) && 
      mapping.getOperationMappings().isEmpty())) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(preamble);
      _builder_1.append(" {}");
      return _builder_1.toString();
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(preamble);
    _builder_2.append(" {");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("    ");
    {
      boolean _isEmpty = mapping.getAspects().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder_2.append("aspects {");
      }
    }
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("        ");
    {
      EList<TechnologySpecificImportedServiceAspect> _aspects = mapping.getAspects();
      boolean _hasElements_1 = false;
      for(final TechnologySpecificImportedServiceAspect a : _aspects) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder_2.appendImmediate("\n", "        ");
        }
        String _extractToString_2 = this.extractToString(a);
        _builder_2.append(_extractToString_2, "        ");
      }
    }
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("    ");
    {
      boolean _isEmpty_1 = mapping.getAspects().isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder_2.append("}");
      }
    }
    String extractedMapping = _builder_2.toString();
    boolean _isEmpty_2 = mapping.getFieldMappings().isEmpty();
    boolean _not_2 = (!_isEmpty_2);
    if (_not_2) {
      boolean _isEmpty_3 = mapping.getAspects().isEmpty();
      boolean _not_3 = (!_isEmpty_3);
      if (_not_3) {
        String _extractedMapping = extractedMapping;
        extractedMapping = (_extractedMapping + "\n\n");
      }
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(extractedMapping);
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("    ");
      {
        EList<TechnologySpecificFieldMapping> _fieldMappings = mapping.getFieldMappings();
        boolean _hasElements_2 = false;
        for(final TechnologySpecificFieldMapping f : _fieldMappings) {
          if (!_hasElements_2) {
            _hasElements_2 = true;
          } else {
            _builder_3.appendImmediate("\n", "    ");
          }
          String _extractToString_3 = this.extractToString(f);
          _builder_3.append(_extractToString_3, "    ");
        }
      }
      _builder_3.newLineIfNotEmpty();
      extractedMapping = _builder_3.toString();
    }
    boolean _endsWith = extractedMapping.endsWith("\n");
    boolean _not_4 = (!_endsWith);
    if (_not_4) {
      String _extractedMapping_1 = extractedMapping;
      extractedMapping = (_extractedMapping_1 + "\n");
    }
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append(extractedMapping);
    _builder_4.append("}");
    return _builder_4.toString();
  }
  
  /**
   * Extract TechnologyReference
   */
  private String extractToString(final TechnologyReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@technology(");
    String _name = reference.getTechnology().getName();
    _builder.append(_name);
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      boolean _isIsTypeDefinitionTechnology = reference.isIsTypeDefinitionTechnology();
      if (_isIsTypeDefinitionTechnology) {
        _builder_1.append(", typedef=true");
      }
    }
    String _plus = (_builder.toString() + _builder_1);
    return (_plus + 
      ")");
  }
  
  /**
   * Extract ImportedComplexTypeToMap
   */
  private String extractToString(final ImportedComplexTypeToMap mappedType) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = mappedType.getServiceModelImport().getName();
    _builder.append(_name);
    _builder.append("::");
    StringConcatenation _builder_1 = new StringConcatenation();
    String _name_1 = mappedType.getDataModelImport().getName();
    _builder_1.append(_name_1);
    _builder_1.append("::");
    String _plus = (_builder.toString() + _builder_1);
    String _buildQualifiedName = mappedType.getType().buildQualifiedName(".");
    return (_plus + _buildQualifiedName);
  }
  
  /**
   * Extract TechnologySpecificImportedServiceAspect
   */
  private String extractToString(final TechnologySpecificImportedServiceAspect importedAspect) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = importedAspect.getTechnology().getName();
    _builder.append(_name);
    _builder.append("::");
    StringConcatenation _builder_1 = new StringConcatenation();
    String _buildQualifiedName = importedAspect.getAspect().buildQualifiedName(".", false, true);
    _builder_1.append(_buildQualifiedName);
    _builder_1.append(";");
    return (_builder.toString() + _builder_1);
  }
  
  /**
   * Extract TechnologySpecificFieldMapping
   */
  private String extractToString(final TechnologySpecificFieldMapping fieldMapping) {
    String _xblockexpression = null;
    {
      boolean _isEmpty = fieldMapping.getAspects().isEmpty();
      if (_isEmpty) {
        StringConcatenation _builder = new StringConcatenation();
        String _name = fieldMapping.getDataField().getName();
        _builder.append(_name);
        _builder.append(";");
        return _builder.toString();
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_1 = fieldMapping.getDataField().getName();
      _builder_1.append(_name_1);
      _builder_1.append(" {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("    ");
      _builder_1.append("aspects {");
      _builder_1.newLine();
      _builder_1.append("        ");
      {
        EList<TechnologySpecificImportedServiceAspect> _aspects = fieldMapping.getAspects();
        boolean _hasElements = false;
        for(final TechnologySpecificImportedServiceAspect a : _aspects) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate("\n", "        ");
          }
          String _extractToString = this.extractToString(a);
          _builder_1.append(_extractToString, "        ");
        }
      }
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _xblockexpression = _builder_1.toString();
    }
    return _xblockexpression;
  }
}

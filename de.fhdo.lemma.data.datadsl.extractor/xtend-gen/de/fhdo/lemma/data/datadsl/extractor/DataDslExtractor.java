package de.fhdo.lemma.data.datadsl.extractor;

import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.ImportedComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.data.Version;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Model-to-text extractor for the Data DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DataDslExtractor {
  /**
   * Extract DataModel
   */
  public String extractToString(final DataModel dataModel) {
    final StringBuilder sb = new StringBuilder();
    final Function<ComplexTypeImport, String> _function = (ComplexTypeImport it) -> {
      return this.extractToString(it);
    };
    this.<ComplexTypeImport>appendAsSeparatedLines(sb, dataModel.getComplexTypeImports(), _function, false);
    final Function<Version, String> _function_1 = (Version it) -> {
      return this.extractToString(it);
    };
    this.<Version>appendAsSeparatedLines(sb, dataModel.getVersions(), _function_1, true);
    final Function<Context, String> _function_2 = (Context it) -> {
      return this.extractToString(it);
    };
    this.<Context>appendAsSeparatedLines(sb, dataModel.getContexts(), _function_2, true);
    final Function<ComplexType, String> _function_3 = (ComplexType it) -> {
      return this.extractTypeDefinitionToString(it);
    };
    this.<ComplexType>appendAsSeparatedLines(sb, dataModel.getComplexTypes(), _function_3, true);
    return sb.toString();
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
   * Extract ComplexTypeImport
   */
  public String extractToString(final ComplexTypeImport complexTypeImport) {
    String _xblockexpression = null;
    {
      final String lemmaName = Util.lemmaName(complexTypeImport.getName());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import datatypes from ");
      String _importURI = complexTypeImport.getImportURI();
      _builder.append(_importURI);
      _builder.append(" as ");
      _builder.append(lemmaName);
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract ComplexType
   */
  public String extractTypeDefinitionToString(final ComplexType complexType) {
    String _switchResult = null;
    boolean _matched = false;
    if (complexType instanceof DataStructure) {
      _matched=true;
      _switchResult = this.extractToString(((DataStructure)complexType));
    }
    if (!_matched) {
      if (complexType instanceof Enumeration) {
        _matched=true;
        _switchResult = this.extractToString(((Enumeration)complexType));
      }
    }
    if (!_matched) {
      if (complexType instanceof CollectionType) {
        _matched=true;
        _switchResult = this.extractToString(((CollectionType)complexType));
      }
    }
    return _switchResult;
  }
  
  /**
   * Extract DataStructure
   */
  public String extractToString(final DataStructure dataStructure) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("structure ");
      String _lemmaName = Util.lemmaName(dataStructure.getName());
      _builder.append(_lemmaName);
      final String preamble = _builder.toString();
      boolean _isEmpty = dataStructure.getDataFields().isEmpty();
      if (_isEmpty) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(preamble);
        _builder_1.append(" {}");
        return _builder_1.toString();
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(preamble);
      _builder_2.append(" {");
      _builder_2.newLineIfNotEmpty();
      {
        EList<DataField> _dataFields = dataStructure.getDataFields();
        boolean _hasElements = false;
        for(final DataField f : _dataFields) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_2.appendImmediate(",", "    ");
          }
          _builder_2.append("    ");
          String _extractToString = this.extractToString(f);
          _builder_2.append(_extractToString, "    ");
          _builder_2.newLineIfNotEmpty();
        }
      }
      _builder_2.append("}");
      _xblockexpression = _builder_2.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract DataField
   */
  public String extractToString(final DataField dataField) {
    String _xblockexpression = null;
    {
      final Object directFieldType = this.fieldType(dataField);
      String _switchResult = null;
      boolean _matched = false;
      if (directFieldType instanceof Type) {
        _matched=true;
        _switchResult = this.extractTypeReferenceToString(((Type)directFieldType), Util.qualifiedName(dataField));
      }
      if (!_matched) {
        if (directFieldType instanceof ImportedComplexType) {
          _matched=true;
          _switchResult = this.extractTypeReferenceToString(((ImportedComplexType)directFieldType));
        }
      }
      final String type = _switchResult;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(type);
      _builder.append(" ");
      String _lemmaName = Util.lemmaName(dataField.getName());
      _builder.append(_lemmaName);
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Get the type of a DataField
   */
  private Object fieldType(final DataField dataField) {
    EObject _xifexpression = null;
    PrimitiveType _primitiveType = dataField.getPrimitiveType();
    boolean _tripleNotEquals = (_primitiveType != null);
    if (_tripleNotEquals) {
      _xifexpression = dataField.getPrimitiveType();
    } else {
      EObject _xifexpression_1 = null;
      ComplexType _complexType = dataField.getComplexType();
      boolean _tripleNotEquals_1 = (_complexType != null);
      if (_tripleNotEquals_1) {
        _xifexpression_1 = dataField.getComplexType();
      } else {
        _xifexpression_1 = dataField.getImportedComplexType();
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Extract Type reference
   */
  public String extractTypeReferenceToString(final Type type, final String referringQualifier) {
    String _switchResult = null;
    boolean _matched = false;
    if (type instanceof PrimitiveType) {
      _matched=true;
      _switchResult = this.extractTypeReferenceToString(((PrimitiveType)type));
    }
    if (!_matched) {
      if (type instanceof ComplexType) {
        _matched=true;
        _switchResult = this.extractTypeReferenceToString(((ComplexType)type), referringQualifier);
      }
    }
    return _switchResult;
  }
  
  /**
   * Extract PrimitiveType reference
   */
  public String extractTypeReferenceToString(final PrimitiveType primitiveType) {
    return primitiveType.getTypeName();
  }
  
  /**
   * Extract ComplexType reference
   */
  public String extractTypeReferenceToString(final ComplexType complexType, final String referringQualifier) {
    String _xifexpression = null;
    if ((referringQualifier != null)) {
      _xifexpression = Util.calculateRelativeQualifier(Util.qualifiedName(complexType), referringQualifier);
    } else {
      _xifexpression = Util.lemmaName(complexType.getName());
    }
    return _xifexpression;
  }
  
  /**
   * Extract ImportedComplexType reference
   */
  public String extractTypeReferenceToString(final ImportedComplexType importedComplexType) {
    String _xblockexpression = null;
    {
      Type _importedType = importedComplexType.getImportedType();
      final ComplexType complexType = ((ComplexType) _importedType);
      StringConcatenation _builder = new StringConcatenation();
      String _lemmaName = Util.lemmaName(importedComplexType.getImport().getName());
      _builder.append(_lemmaName);
      _builder.append("::");
      String _qualifiedName = Util.qualifiedName(complexType);
      _builder.append(_qualifiedName);
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Enumeration
   */
  public String extractToString(final Enumeration enumeration) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum ");
      String _lemmaName = Util.lemmaName(enumeration.getName());
      _builder.append(_lemmaName);
      final String preamble = _builder.toString();
      boolean _isEmpty = enumeration.getFields().isEmpty();
      if (_isEmpty) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(preamble);
        _builder_1.append(" {}");
        return _builder_1.toString();
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(preamble);
      _builder_2.append(" {");
      _builder_2.newLineIfNotEmpty();
      {
        EList<EnumerationField> _fields = enumeration.getFields();
        boolean _hasElements = false;
        for(final EnumerationField f : _fields) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_2.appendImmediate(",", "    ");
          }
          _builder_2.append("    ");
          String _extractToString = this.extractToString(f);
          _builder_2.append(_extractToString, "    ");
          _builder_2.newLineIfNotEmpty();
        }
      }
      _builder_2.append("}");
      _xblockexpression = _builder_2.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract EnumerationField
   */
  private String extractToString(final EnumerationField field) {
    return Util.lemmaName(field.getName());
  }
  
  /**
   * Extract CollectionType
   */
  public String extractToString(final CollectionType collectionType) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("collection ");
      String _lemmaName = Util.lemmaName(CollectionType.class.getName());
      _builder.append(_lemmaName);
      final String preamble = _builder.toString();
      String _xifexpression = null;
      boolean _isIsPrimitiveCollection = collectionType.isIsPrimitiveCollection();
      if (_isIsPrimitiveCollection) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(preamble);
        _builder_1.append(" { ");
        String _extractTypeReferenceToString = this.extractTypeReferenceToString(collectionType.getPrimitiveType());
        _builder_1.append(_extractTypeReferenceToString);
        _builder_1.append(" }");
        _xifexpression = _builder_1.toString();
      } else {
        String _xifexpression_1 = null;
        boolean _isIsStructuredCollection = collectionType.isIsStructuredCollection();
        if (_isIsStructuredCollection) {
          String _xblockexpression_1 = null;
          {
            final Function1<DataField, String> _function = (DataField it) -> {
              String _xblockexpression_2 = null;
              {
                final String fieldTypeReference = this.extractTypeReferenceToString(it.getEffectiveType(), 
                  Util.qualifiedName(collectionType));
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append(fieldTypeReference);
                _builder_2.append(" ");
                String _lemmaName_1 = Util.lemmaName(it.getName());
                _builder_2.append(_lemmaName_1);
                _xblockexpression_2 = _builder_2.toString();
              }
              return _xblockexpression_2;
            };
            final String fieldDefinitions = IterableExtensions.join(ListExtensions.<DataField, String>map(collectionType.getDataFields(), _function), ", ");
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(preamble);
            _builder_2.append(" { ");
            _builder_2.append(fieldDefinitions);
            _builder_2.append(" }");
            _xblockexpression_1 = _builder_2.toString();
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(preamble);
          _builder_2.append(" {}");
          _xifexpression_1 = _builder_2.toString();
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Context
   */
  public String extractToString(final Context context) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("context ");
      String _lemmaName = Util.lemmaName(context.getName());
      _builder.append(_lemmaName);
      final String preamble = _builder.toString();
      boolean _isEmpty = context.getComplexTypes().isEmpty();
      if (_isEmpty) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(preamble);
        _builder_1.append(" {}");
        return _builder_1.toString();
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(preamble);
      _builder_2.append(" {");
      _builder_2.newLineIfNotEmpty();
      {
        EList<ComplexType> _complexTypes = context.getComplexTypes();
        boolean _hasElements = false;
        for(final ComplexType t : _complexTypes) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_2.appendImmediate("\n", "    ");
          }
          _builder_2.append("    ");
          String _extractTypeDefinitionToString = this.extractTypeDefinitionToString(t);
          _builder_2.append(_extractTypeDefinitionToString, "    ");
          _builder_2.newLineIfNotEmpty();
        }
      }
      _builder_2.append("}");
      _xblockexpression = _builder_2.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Extract Version
   */
  public String extractToString(final Version version) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("version ");
      String _lemmaName = Util.lemmaName(version.getName());
      _builder.append(_lemmaName);
      final String preamble = _builder.toString();
      if ((version.getContexts().isEmpty() && version.getComplexTypes().isEmpty())) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(preamble);
        _builder_1.append(" {}");
        return _builder_1.toString();
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(preamble);
      _builder_2.append(" {");
      _builder_2.newLineIfNotEmpty();
      {
        EList<Context> _contexts = version.getContexts();
        boolean _hasElements = false;
        for(final Context c : _contexts) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_2.appendImmediate("\n", "    ");
          }
          _builder_2.append("    ");
          String _extractToString = this.extractToString(c);
          _builder_2.append(_extractToString, "    ");
          _builder_2.newLineIfNotEmpty();
        }
      }
      {
        EList<ComplexType> _complexTypes = version.getComplexTypes();
        boolean _hasElements_1 = false;
        for(final ComplexType t : _complexTypes) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder_2.appendImmediate("\n", "    ");
          }
          _builder_2.append("    ");
          String _extractTypeDefinitionToString = this.extractTypeDefinitionToString(t);
          _builder_2.append(_extractTypeDefinitionToString, "    ");
          _builder_2.newLineIfNotEmpty();
        }
      }
      _builder_2.append("}");
      _xblockexpression = _builder_2.toString();
    }
    return _xblockexpression;
  }
}

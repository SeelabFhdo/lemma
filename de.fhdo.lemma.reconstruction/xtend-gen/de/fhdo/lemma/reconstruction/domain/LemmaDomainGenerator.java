package de.fhdo.lemma.reconstruction.domain;

import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.ComplexTypeFeature;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataFieldFeature;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.PrimitiveUnspecified;
import de.fhdo.lemma.data.Version;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Class for generating LEMMA domain data models based on reconstructed Context.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class LemmaDomainGenerator {
  private static final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;

  private static Context context = LemmaDomainGenerator.DATA_FACTORY.createContext();

  public LemmaDomainGenerator() {
  }

  /**
   * generate LEMMA domain data model based on a reconstructed context
   */
  public DataModel generateDataModel(final de.fhdo.lemma.reconstruction.domain.Context reconstructedContext) {
    LemmaDomainGenerator.context = this.generateContextFrom(reconstructedContext);
    final Consumer<DataStructure> _function = (DataStructure it) -> {
      final Function1<ComplexType, Boolean> _function_1 = (ComplexType complexTyp) -> {
        String _lowerCase = complexTyp.getName().toLowerCase();
        String _lowerCase_1 = it.getName().toLowerCase();
        return Boolean.valueOf(Objects.equals(_lowerCase, _lowerCase_1));
      };
      ComplexType _findFirst = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function_1);
      boolean _tripleEquals = (_findFirst == null);
      if (_tripleEquals) {
        LemmaDomainGenerator.context.getComplexTypes().add(this.createDataStructureFrom(it));
      }
    };
    reconstructedContext.getDataStructures().forEach(_function);
    final Consumer<EnumType> _function_1 = (EnumType it) -> {
      LemmaDomainGenerator.context.getComplexTypes().add(this.createEnumFrom(it));
    };
    reconstructedContext.getEnums().forEach(_function_1);
    final Consumer<DataStructure> _function_2 = (DataStructure reconstructedData) -> {
      final Function1<ComplexType, Boolean> _function_3 = (ComplexType lemmaStructure) -> {
        String _name = lemmaStructure.getName();
        String _name_1 = reconstructedData.getName();
        return Boolean.valueOf(Objects.equals(_name, _name_1));
      };
      ComplexType _findFirst = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function_3);
      final de.fhdo.lemma.data.DataStructure structure = ((de.fhdo.lemma.data.DataStructure) _findFirst);
      LemmaDomainGenerator.context.getComplexTypes().add(this.assignDataFieldsToStructure(structure, reconstructedData));
    };
    reconstructedContext.getDataStructures().forEach(_function_2);
    final Consumer<EnumType> _function_3 = (EnumType reconstructedEnum) -> {
      final Function1<ComplexType, Boolean> _function_4 = (ComplexType lemmaEnum) -> {
        String _name = lemmaEnum.getName();
        String _name_1 = reconstructedEnum.getName();
        return Boolean.valueOf(Objects.equals(_name, _name_1));
      };
      ComplexType _findFirst = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function_4);
      final Enumeration enum_ = ((Enumeration) _findFirst);
      LemmaDomainGenerator.context.getComplexTypes().add(this.assignEnumFieldsToStructure(enum_, reconstructedEnum));
    };
    reconstructedContext.getEnums().forEach(_function_3);
    final DataModel dataModel = LemmaDomainGenerator.DATA_FACTORY.createDataModel();
    dataModel.getContexts().add(LemmaDomainGenerator.context);
    return dataModel;
  }

  /**
   * Generate a LEMMA domain model context from a reconstructed context
   */
  private Context generateContextFrom(final de.fhdo.lemma.reconstruction.domain.Context reconstructedContext) {
    final Context context = LemmaDomainGenerator.DATA_FACTORY.createContext();
    context.setName(reconstructedContext.getName());
    final Version version = LemmaDomainGenerator.DATA_FACTORY.createVersion();
    version.setName(reconstructedContext.getName());
    context.setVersion(version);
    return context;
  }

  /**
   * Generate a LEMMA domain model data structure from a reconstructed data structure
   */
  private de.fhdo.lemma.data.DataStructure createDataStructureFrom(final DataStructure reconstructedDataStructure) {
    final de.fhdo.lemma.data.DataStructure dataStructure = LemmaDomainGenerator.DATA_FACTORY.createDataStructure();
    dataStructure.setName(reconstructedDataStructure.getName());
    final Consumer<MetaData> _function = (MetaData data) -> {
      dataStructure.getFeatures().add(this.assignFeaturesToDataStructure(data));
    };
    reconstructedDataStructure.getMetaData().forEach(_function);
    return dataStructure;
  }

  /**
   * Assign a LEMMA domain model feature to a data structure
   */
  private ComplexTypeFeature assignFeaturesToDataStructure(final MetaData data) {
    if (((!data.getValues().isEmpty()) || (data.getValues() != null))) {
      return this.getTypeFeatureFrom(data.getName());
    } else {
      return null;
    }
  }

  /**
   * Get e LEMMA domain model feature based on a string
   */
  private ComplexTypeFeature getTypeFeatureFrom(final String name) {
    ComplexTypeFeature _switchResult = null;
    if (name != null) {
      switch (name) {
        case "Aggregate":
          _switchResult = ComplexTypeFeature.AGGREGATE;
          break;
        case "ApplicationService":
          _switchResult = ComplexTypeFeature.APPLICATION_SERVICE;
          break;
        case "DomainEvent":
          _switchResult = ComplexTypeFeature.DOMAIN_EVENT;
          break;
        case "DomainService":
          _switchResult = ComplexTypeFeature.DOMAIN_SERVICE;
          break;
        case "Entity":
          _switchResult = ComplexTypeFeature.ENTITY;
          break;
        case "Factory":
          _switchResult = ComplexTypeFeature.FACTORY;
          break;
        case "InfrastructureService":
          _switchResult = ComplexTypeFeature.INFRASTRUCTURE_SERVICE;
          break;
        case "Repository":
          _switchResult = ComplexTypeFeature.REPOSITORY;
          break;
        case "Service":
          _switchResult = ComplexTypeFeature.SERVICE;
          break;
        case "Specification":
          _switchResult = ComplexTypeFeature.SPECIFICATION;
          break;
        case "valueObject":
          _switchResult = ComplexTypeFeature.VALUE_OBJECT;
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }

  /**
   * Generate a LEMMA domain model enumeration from a reconstructed enumeration
   */
  private ComplexType createEnumFrom(final EnumType reconstructedEnum) {
    Enumeration _xblockexpression = null;
    {
      final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
        String _name = it.getName();
        String _name_1 = reconstructedEnum.getName();
        return Boolean.valueOf(Objects.equals(_name, _name_1));
      };
      final ComplexType enum_ = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function);
      if ((enum_ != null)) {
        return enum_;
      }
      final Enumeration newEnum = LemmaDomainGenerator.DATA_FACTORY.createEnumeration();
      newEnum.setName(reconstructedEnum.getName());
      final Consumer<String> _function_1 = (String it) -> {
        final EnumerationField field = LemmaDomainGenerator.DATA_FACTORY.createEnumerationField();
        field.setName(it);
        newEnum.getFields().add(field);
      };
      reconstructedEnum.getValues().forEach(_function_1);
      _xblockexpression = newEnum;
    }
    return _xblockexpression;
  }

  /**
   * Assign data fields to a data structure
   */
  private de.fhdo.lemma.data.DataStructure assignDataFieldsToStructure(final de.fhdo.lemma.data.DataStructure lemmaStructure, final DataStructure dataStructure) {
    int _size = lemmaStructure.getDataFields().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      return lemmaStructure;
    }
    final Consumer<Field> _function = (Field it) -> {
      final DataField field = this.generateDataFildFrom(it);
      lemmaStructure.getDataFields().add(field);
    };
    dataStructure.getFields().forEach(_function);
    return lemmaStructure;
  }

  /**
   * Assign data fields to a data structure
   */
  private Enumeration assignEnumFieldsToStructure(final Enumeration enumeration, final EnumType reconstrcutedEnumeration) {
    return enumeration;
  }

  /**
   * Assign data fields to a data structure
   */
  private DataField generateDataFildFrom(final Field reconstructedAttribute) {
    DataField _xblockexpression = null;
    {
      final DataField dataFild = LemmaDomainGenerator.DATA_FACTORY.createDataField();
      dataFild.setName(reconstructedAttribute.getName());
      PrimitiveType _primitiveType = reconstructedAttribute.getPrimitiveType();
      boolean _tripleNotEquals = (_primitiveType != null);
      if (_tripleNotEquals) {
        dataFild.setPrimitiveType(this.getPrimitiveFrom(reconstructedAttribute.getPrimitiveType().getName()));
      } else {
        dataFild.setComplexType(this.getComplexTypefrom(reconstructedAttribute));
      }
      final Consumer<MetaData> _function = (MetaData it) -> {
        final DataFieldFeature feature = this.getDataFieldFeatureFrom(it.getName());
        dataFild.getFeatures().add(feature);
      };
      reconstructedAttribute.getMetaData().forEach(_function);
      _xblockexpression = dataFild;
    }
    return _xblockexpression;
  }

  /**
   * Get a LEMMA domain model primitive type based on
   */
  private de.fhdo.lemma.data.PrimitiveType getPrimitiveFrom(final String type) {
    de.fhdo.lemma.data.PrimitiveType _switchResult = null;
    String _lowerCase = type.toLowerCase();
    if (_lowerCase != null) {
      switch (_lowerCase) {
        case "boolean":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveBoolean();
          break;
        case "byte":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveByte();
          break;
        case "character":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveCharacter();
          break;
        case "date":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveDate();
          break;
        case "double":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveDouble();
          break;
        case "float":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveFloat();
          break;
        case "int":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveInteger();
          break;
        case "long":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveLong();
          break;
        case "short":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveShort();
          break;
        case "string":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveString();
          break;
        case "bigdecimal":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveFloat();
          break;
        case "integer":
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveInteger();
          break;
        default:
          _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveUnspecified();
          break;
      }
    } else {
      _switchResult = LemmaDomainGenerator.DATA_FACTORY.createPrimitiveUnspecified();
    }
    return _switchResult;
  }

  /**
   * Get a LEMMA domain model complex type based on a reconstructed field
   */
  private ComplexType getComplexTypefrom(final Field field) {
    ComplexType _switchResult = null;
    ClassType _classType = field.getComplexType().getClassType();
    if (_classType != null) {
      switch (_classType) {
        case DATA_STRUCTURE:
          _switchResult = this.getComplexTypeFromDataStructure(field.getComplexType());
          break;
        case ENUMERATION:
          _switchResult = this.getComplexTypeFromEnumeration(field.getComplexType());
          break;
        case COLLECTION:
          _switchResult = this.getListTypeFromCollection(field);
          break;
        case MAP:
          _switchResult = null;
          break;
        case UNSPECIFIED:
          _switchResult = this.getUnspecifiedComplexType(field);
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }

  /**
   * Get a complex type from a reconstructed complex type
   */
  private ComplexType getComplexTypeFromDataStructure(final de.fhdo.lemma.reconstruction.domain.ComplexType complexType) {
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      String _name = it.getName();
      String _name_1 = complexType.getName();
      return Boolean.valueOf(Objects.equals(_name, _name_1));
    };
    return IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function);
  }

  /**
   * Get an enumeration from a reconstructed complex type
   */
  private ComplexType getComplexTypeFromEnumeration(final de.fhdo.lemma.reconstruction.domain.ComplexType complexType) {
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      return Boolean.valueOf(complexType.getQualifiedName().toLowerCase().endsWith(it.getName().toLowerCase()));
    };
    final ComplexType type = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function);
    return type;
  }

  /**
   * Get a list type from a reconstructed complex type
   */
  private ComplexType getListTypeFromCollection(final Field field) {
    final Function1<ComplexType, Boolean> _function = (ComplexType complexTyp) -> {
      String _lowerCase = complexTyp.getName().toLowerCase();
      String _lowerCase_1 = field.getName().toLowerCase();
      return Boolean.valueOf(Objects.equals(_lowerCase, _lowerCase_1));
    };
    final ComplexType complex = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function);
    if ((complex != null)) {
      return complex;
    }
    final CollectionType list = LemmaDomainGenerator.DATA_FACTORY.createCollectionType();
    final Function1<MetaData, Boolean> _function_1 = (MetaData it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equals(_name, "CollectionType"));
    };
    final MetaData data = IterableExtensions.<MetaData>findFirst(field.getMetaData(), _function_1);
    final Function1<Map.Entry<String, String>, Boolean> _function_2 = (Map.Entry<String, String> it) -> {
      String _key = it.getKey();
      return Boolean.valueOf(Objects.equals(_key, "Type"));
    };
    final Map.Entry<String, String> collectionInfo = IterableExtensions.<Map.Entry<String, String>>findFirst(data.getValues().entrySet(), _function_2);
    final String reconstrcutionType = collectionInfo.getValue();
    list.setName(StringExtensions.toFirstUpper(field.getName()));
    final de.fhdo.lemma.data.PrimitiveType lemmaType = this.getPrimitiveFrom(reconstrcutionType);
    if ((!(lemmaType instanceof PrimitiveUnspecified))) {
      list.setPrimitiveType(lemmaType);
    } else {
      final DataField dataField = LemmaDomainGenerator.DATA_FACTORY.createDataField();
      final Function1<ComplexType, Boolean> _function_3 = (ComplexType it) -> {
        String _lowerCase = it.getName().toLowerCase();
        String _lowerCase_1 = reconstrcutionType.toLowerCase();
        return Boolean.valueOf(Objects.equals(_lowerCase, _lowerCase_1));
      };
      final ComplexType complexType = IterableExtensions.<ComplexType>findFirst(LemmaDomainGenerator.context.getComplexTypes(), _function_3);
      if ((complexType != null)) {
        dataField.setComplexType(complexType);
        dataField.setName(field.getName());
        list.getDataFields().add(dataField);
      } else {
        list.setPrimitiveType(LemmaDomainGenerator.DATA_FACTORY.createPrimitiveUnspecified());
      }
    }
    LemmaDomainGenerator.context.getComplexTypes().add(list);
    return list;
  }

  /**
   * Get an unspecified field type from a reconstructed field
   */
  private de.fhdo.lemma.data.DataStructure getUnspecifiedComplexType(final Field field) {
    final de.fhdo.lemma.data.DataStructure dataStructure = LemmaDomainGenerator.DATA_FACTORY.createDataStructure();
    dataStructure.setName(StringExtensions.toFirstUpper(field.getName()));
    final DataField dataField = LemmaDomainGenerator.DATA_FACTORY.createDataField();
    dataField.setPrimitiveType(LemmaDomainGenerator.DATA_FACTORY.createPrimitiveUnspecified());
    dataField.setName(field.getName());
    dataStructure.getDataFields().add(dataField);
    final Function1<ComplexType, Boolean> _function = (ComplexType it) -> {
      String _lowerCase = it.getName().toLowerCase();
      String _lowerCase_1 = field.getName().toLowerCase();
      return Boolean.valueOf(Objects.equals(_lowerCase, _lowerCase_1));
    };
    boolean _exists = IterableExtensions.<ComplexType>exists(LemmaDomainGenerator.context.getComplexTypes(), _function);
    boolean _not = (!_exists);
    if (_not) {
      LemmaDomainGenerator.context.getComplexTypes().add(dataStructure);
    }
    return dataStructure;
  }

  private DataFieldFeature getDataFieldFeatureFrom(final String name) {
    DataFieldFeature _switchResult = null;
    if (name != null) {
      switch (name) {
        case "NeverEmpty":
          _switchResult = DataFieldFeature.NEVER_EMPTY;
          break;
        case "Identifier":
          _switchResult = DataFieldFeature.IDENTIFIER;
          break;
        case "Part":
          _switchResult = DataFieldFeature.PART;
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }
}

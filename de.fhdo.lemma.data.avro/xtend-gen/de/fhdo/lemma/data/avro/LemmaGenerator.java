package de.fhdo.lemma.data.avro;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataFactory;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.DataStructure;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.PrimitiveInteger;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.data.Version;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ServiceFactory;
import de.fhdo.lemma.service.TechnologyReference;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.TechnologyFactory;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap;
import de.fhdo.lemma.technology.mapping.MappingFactory;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generate LEMMA models from Avro schema specifications.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class LemmaGenerator {
  private static final String DOMAIN_MODEL_IMPORT_ALIAS = "Domain";
  
  private static final String SERVICE_MODEL_IMPORT_ALIAS = "Services";
  
  private static final DataFactory DATA_FACTORY = DataFactory.eINSTANCE;
  
  private static final MappingFactory MAPPING_FACTORY = MappingFactory.eINSTANCE;
  
  private static final ServiceFactory SERVICE_FACTORY = ServiceFactory.eINSTANCE;
  
  private static final TechnologyFactory TECHNOLOGY_FACTORY = TechnologyFactory.eINSTANCE;
  
  /**
   * Generate LEMMA models from Avro protocol. Returns a pair consisting of the generated domain
   * and possibly generated mapping model.
   */
  public Pair<DataModel, TechnologyMapping> generateModelsFrom(final Protocol protocol, final String serviceModelPath, final String avroModelPath) {
    return this.generateModelsFrom(protocol, LemmaGenerator.DOMAIN_MODEL_IMPORT_ALIAS, serviceModelPath, 
      LemmaGenerator.SERVICE_MODEL_IMPORT_ALIAS, avroModelPath, Shared.AVRO_TECHNOLOGY_NAME);
  }
  
  /**
   * Generate LEMMA models from Avro protocol. Returns a pair consisting of the generated domain
   * and possibly generated mapping model. This method allows for specifying import aliases of
   * generated models. Returns a pair consisting of the generated domain and possibly generated
   * mapping model.
   */
  public Pair<DataModel, TechnologyMapping> generateModelsFrom(final Protocol protocol, final String domainImportAlias, final String serviceModelPath, final String serviceImportAlias, final String avroModelPath, final String avroImportAlias) {
    return this.generateModelsFrom(IterableExtensions.<Schema>toList(protocol.getTypes()), domainImportAlias, serviceModelPath, serviceImportAlias, avroModelPath, avroImportAlias);
  }
  
  /**
   * Generate LEMMA models from several Avro schemas. Returns a pair consisting of the generated
   * domain and possibly generated mapping model.
   */
  public Pair<DataModel, TechnologyMapping> generateModelsFrom(final List<Schema> schemas, final String serviceModelPath, final String avroModelPath) {
    return this.generateModelsFrom(schemas, LemmaGenerator.DOMAIN_MODEL_IMPORT_ALIAS, serviceModelPath, 
      LemmaGenerator.SERVICE_MODEL_IMPORT_ALIAS, avroModelPath, Shared.AVRO_TECHNOLOGY_NAME);
  }
  
  /**
   * Generate LEMMA models from several Avro schemas. Returns a pair consisting of the generated
   * domain and possibly generated mapping model. This method allows for specifying import aliases
   * of generated models. Returns a pair consisting of the generated domain and possibly generated
   * mapping model.
   */
  public Pair<DataModel, TechnologyMapping> generateModelsFrom(final List<Schema> schemas, final String domainImportAlias, final String serviceModelPath, final String serviceImportAlias, final String avroModelPath, final String avroImportAlias) {
    final ArrayList<EObject> dataModelElements = CollectionLiterals.<EObject>newArrayList();
    final ArrayList<EObject> mappingModelElements = CollectionLiterals.<EObject>newArrayList();
    final Consumer<Schema> _function = (Schema it) -> {
      final Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> generatedEObjects = this.generateEObjectsFromNamedSchema(it);
      if ((generatedEObjects != null)) {
        List<EObject> _elvis = null;
        List<EObject> _get = generatedEObjects.getValue().get(DataModel.class);
        if (_get != null) {
          _elvis = _get;
        } else {
          List<EObject> _emptyList = CollectionLiterals.<EObject>emptyList();
          _elvis = _emptyList;
        }
        dataModelElements.addAll(_elvis);
        List<EObject> _elvis_1 = null;
        List<EObject> _get_1 = generatedEObjects.getValue().get(TechnologyMapping.class);
        if (_get_1 != null) {
          _elvis_1 = _get_1;
        } else {
          List<EObject> _emptyList_1 = CollectionLiterals.<EObject>emptyList();
          _elvis_1 = _emptyList_1;
        }
        mappingModelElements.addAll(_elvis_1);
      }
    };
    schemas.forEach(_function);
    final DataModel dataModel = this.toDataModel(dataModelElements);
    final TechnologyMapping mappingModel = this.toMappingModel(mappingModelElements, domainImportAlias, serviceModelPath, serviceImportAlias, avroModelPath, avroImportAlias);
    return Pair.<DataModel, TechnologyMapping>of(dataModel, mappingModel);
  }
  
  /**
   * Generate LEMMA EObjects from Avro named schema. Returns a pair consisting of the EObject
   * specifically derived from the passed schema and all other EObjects that were derived during
   * EObject generation in the context of the passed schema.
   */
  private Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> generateEObjectsFromNamedSchema(final Schema schema) {
    boolean _isNamedSchema = Shared.isNamedSchema(schema);
    boolean _not = (!_isNamedSchema);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Avro schema of type ");
      Schema.Type _type = schema.getType();
      _builder.append(_type);
      _builder.append(" is not a ");
      String _plus = (_builder.toString() + 
        "named schema");
      throw new IllegalArgumentException(_plus);
    }
    Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> _switchResult = null;
    Schema.Type _type_1 = schema.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case ENUM:
          _switchResult = this.toEnumeration(schema);
          break;
        case FIXED:
        case RECORD:
          _switchResult = this.toDataStructure(schema);
          break;
        default:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("schema type ");
          Schema.Type _type_2 = schema.getType();
          _builder_1.append(_type_2);
          _builder_1.append(" is not supported");
          String _plus_1 = ("EObject generation from named Avro " + _builder_1);
          throw new IllegalArgumentException(_plus_1);
      }
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("schema type ");
      Schema.Type _type_2 = schema.getType();
      _builder_1.append(_type_2);
      _builder_1.append(" is not supported");
      String _plus_1 = ("EObject generation from named Avro " + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    return _switchResult;
  }
  
  /**
   * Generate LEMMA EObjects from Avro Enum. Returns a pair consisting of the EObject (LEMMA
   * Enumeration) specifically derived from the passed schema and all other EObjects that were
   * derived during EObject generation in the context of the passed schema.
   */
  public Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toEnumeration(final Schema schema) {
    this.ensureType(schema, Schema.Type.ENUM);
    final Enumeration enumeration = this.createEnumeration(this.lemmaNameElseSchemaName(schema), schema.getNamespace());
    this.startedEObjectCreation(DataModel.class, enumeration);
    final Function1<String, EnumerationField> _function = (String it) -> {
      return this.createEnumerationField(it);
    };
    enumeration.getFields().addAll(ListExtensions.<String, EnumerationField>map(schema.getEnumSymbols(), _function));
    this.finishedEObjectCreation(DataModel.class, enumeration);
    Map<Class<? extends EObject>, List<EObject>> _allCreatedEObjects = this.allCreatedEObjects();
    return Pair.<EObject, Map<Class<? extends EObject>, List<EObject>>>of(enumeration, _allCreatedEObjects);
  }
  
  /**
   * Helper to ensure that an Avro schema is one of the expected types. Throws an
   * IllegalArgumentException if that is not the case.
   */
  private void ensureType(final Schema schema, final Schema.Type... expectedTypes) {
    boolean _contains = ArrayExtensions.contains(expectedTypes, schema.getType());
    boolean _not = (!_contains);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Schema ");
      String _fullName = schema.getFullName();
      _builder.append(_fullName);
      _builder.append(" is not of one of ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("the expected types ");
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(expectedTypes)), ", ");
      _builder_1.append(_join);
      String _plus = (_builder.toString() + _builder_1);
      throw new IllegalArgumentException(_plus);
    }
  }
  
  /**
   * Return the simple LEMMA name from this schema. If a LEMMA name is not present, return the
   * simple name of the schema.
   */
  private String lemmaNameElseSchemaName(final Schema schema) {
    return LemmaUtils.getSimpleName(Shared.lemmaNameOrElse(schema, schema.getName()));
  }
  
  /**
   * Create a LEMMA Enumeration instance
   */
  private Enumeration createEnumeration(final String name, final String avroNamespace) {
    final Enumeration enumeration = LemmaGenerator.DATA_FACTORY.createEnumeration();
    enumeration.setName(name);
    enumeration.setVersion(this.getOrCreateVersion(avroNamespace));
    enumeration.setContext(this.getOrCreateContext(avroNamespace));
    return enumeration;
  }
  
  /**
   * Helper to retrieve a LEMMA Version from an Avro namespace. In case a corresponding Version
   * instance was already created, return it. If no version information could be extracted from
   * the Avro namespace, return null.
   */
  private Version getOrCreateVersion(final String avroNamespace) {
    if (((avroNamespace == null) || (Util.qualifyingLevelCount(avroNamespace) < 3))) {
      return null;
    }
    final String versionName = Util.getQualifyingPartsAsList(avroNamespace).get(0);
    Version version = this.<Version>getCreatedEObject(DataModel.class, versionName);
    if ((version == null)) {
      version = LemmaGenerator.DATA_FACTORY.createVersion();
      version.setName(versionName);
      this.addCreatedEObject(DataModel.class, version);
    }
    return version;
  }
  
  /**
   * Helper to retrieve a LEMMA Context from an Avro namespace. In case a corresponding Context
   * instance was already created, return it. If no context information could be extracted from
   * the Avro namespace, return null.
   */
  private Context getOrCreateContext(final String avroNamespace) {
    if ((avroNamespace == null)) {
      return null;
    }
    int _qualifyingLevelCount = Util.qualifyingLevelCount(avroNamespace);
    final boolean hasVersion = (_qualifyingLevelCount >= 3);
    String _xifexpression = null;
    if (hasVersion) {
      String _xblockexpression = null;
      {
        final List<String> qualifyingParts = Util.getQualifyingPartsAsList(avroNamespace);
        _xblockexpression = IterableExtensions.join(qualifyingParts.subList(1, qualifyingParts.size()), ".");
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = avroNamespace;
    }
    final String contextNameParts = _xifexpression;
    final String contextName = Shared.toLemmaNamespace(contextNameParts);
    Context context = this.<Context>getCreatedEObject(DataModel.class, contextName);
    if ((context == null)) {
      context = LemmaGenerator.DATA_FACTORY.createContext();
      context.setName(contextName);
      context.setVersion(this.getOrCreateVersion(avroNamespace));
      this.addCreatedEObject(DataModel.class, context);
    }
    return context;
  }
  
  /**
   * Map of all EObjects that were successfully created during generation. The key of the map
   * identifies the model type. The value of the map is a nested map, whose key is the qualified
   * name of the value EObject under creation.
   */
  private final HashMap<Class<? extends EObject>, Map<String, EObject>> createdEObjects = CollectionLiterals.<Class<? extends EObject>, Map<String, EObject>>newHashMap();
  
  /**
   * Map of all fully-qualified names of all EObjects discovered during a generation run for a
   * given model type. Note, that this map is never deleted.
   */
  private final HashMap<Class<? extends EObject>, Set<String>> eObjectNames = CollectionLiterals.<Class<? extends EObject>, Set<String>>newHashMap();
  
  /**
   * Add an EObject to the map of created EObjects for the given model type
   */
  private void addCreatedEObject(final Class<? extends EObject> modelType, final EObject eObject) {
    this.addCreatedEObject(modelType, eObject, Util.qualifiedName(eObject));
  }
  
  /**
   * Add an EObject to the map of created EObjects for the given model type and qualified name
   */
  private void addCreatedEObject(final Class<? extends EObject> modelType, final EObject eObject, final String qualifiedName) {
    Util.<Class<? extends EObject>, String, EObject>addToValueMap(this.createdEObjects, modelType, qualifiedName, eObject);
    Util.<Class<? extends EObject>, String>addToValueSet(this.eObjectNames, modelType, qualifiedName);
  }
  
  /**
   * Get an EObject with the given qualified name for the given model type from the cache of
   * created EObjects
   */
  private <T extends EObject> T getCreatedEObject(final Class<? extends EObject> modelType, final String qualifiedName) {
    Map<String, EObject> _get = this.createdEObjects.get(modelType);
    T _eObject = null;
    if (_get!=null) {
      _eObject=this.<T>getEObject(_get, qualifiedName);
    }
    return _eObject;
  }
  
  /**
   * Generic helper to retrieve an EObject with a certain type from a map of EObjects by the
   * specified qualified name
   */
  private <T extends EObject> T getEObject(final Map<String, EObject> eObjectMap, final String qualifiedName) {
    final EObject eObject = eObjectMap.get(qualifiedName);
    T _xifexpression = null;
    if ((eObject != null)) {
      T _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ((T) eObject);
      } catch (final Throwable _t) {
        if (_t instanceof ClassCastException) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xifexpression = _xtrycatchfinallyexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Check if an EObject with the given qualified name got already created
   */
  private boolean existsCreatedEObject(final Class<? extends EObject> modelType, final String qualifiedName) {
    final Map<String, EObject> eObjects = this.createdEObjects.get(modelType);
    boolean _xifexpression = false;
    if ((eObjects != null)) {
      _xifexpression = eObjects.containsKey(qualifiedName);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  /**
   * Helper to return all EObjects that were created
   */
  private Map<Class<? extends EObject>, List<EObject>> allCreatedEObjects() {
    final Function1<Map<String, EObject>, List<EObject>> _function = (Map<String, EObject> it) -> {
      return IterableExtensions.<EObject>toList(it.values());
    };
    return MapExtensions.<Class<? extends EObject>, Map<String, EObject>, List<EObject>>mapValues(this.createdEObjects, _function);
  }
  
  /**
   * Map of all EObjects, whose creation is not finished yet, e.g., because nested EObjects are
   * currently generated. An entry is removed from the stack, as soon as the corresponding EObject
   * for a model got fully created. The structure of the map is the same as for "createdEObjects".
   */
  private final HashMap<Class<? extends EObject>, Map<String, EObject>> eObjectCreationStack = CollectionLiterals.<Class<? extends EObject>, Map<String, EObject>>newHashMap();
  
  /**
   * Signal the start of the creation of a new EObject
   */
  private void startedEObjectCreation(final Class<? extends EObject> modelType, final EObject eObject) {
    this.addToCreationStack(modelType, eObject);
  }
  
  /**
   * Add an EObject to the creation stack for the given model type
   */
  private void addToCreationStack(final Class<? extends EObject> modelType, final EObject eObject) {
    this.addToCreationStack(modelType, eObject, Util.qualifiedName(eObject));
  }
  
  /**
   * Add an EObject to the creation stack for the given model type and fully-qualified name
   */
  private void addToCreationStack(final Class<? extends EObject> modelType, final EObject eObject, final String qualifiedName) {
    Util.<Class<? extends EObject>, String, EObject>addToValueMap(this.eObjectCreationStack, modelType, qualifiedName, eObject);
    Util.<Class<? extends EObject>, String>addToValueSet(this.eObjectNames, modelType, qualifiedName);
  }
  
  /**
   * Check if an EObject with the given qualified name exists on the EObject creation stack for
   * the given model type
   */
  private boolean existsOnCreationStack(final Class<? extends EObject> modelType, final String qualifiedName) {
    final Map<String, EObject> eObjects = this.eObjectCreationStack.get(modelType);
    boolean _xifexpression = false;
    if ((eObjects != null)) {
      _xifexpression = eObjects.containsKey(qualifiedName);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  /**
   * Get EObject with the given qualified name and for the given model type from the EObject
   * creation stack
   */
  private <T extends EObject> T getFromCreationStack(final Class<? extends EObject> modelType, final String qualifiedName) {
    Map<String, EObject> _get = this.eObjectCreationStack.get(modelType);
    T _eObject = null;
    if (_get!=null) {
      _eObject=this.<T>getEObject(_get, qualifiedName);
    }
    return _eObject;
  }
  
  /**
   * Remove EObject for the given model type from the EObject creation stack
   */
  private void removeFromCreationStack(final Class<? extends EObject> modelType, final EObject eObject) {
    Util.<Class<? extends EObject>, String, EObject>removeFromValueMap(this.eObjectCreationStack, modelType, Util.qualifiedName(eObject));
  }
  
  /**
   * Create a LEMMA EnumerationField instance
   */
  private EnumerationField createEnumerationField(final String name) {
    final EnumerationField enumerationField = LemmaGenerator.DATA_FACTORY.createEnumerationField();
    enumerationField.setName(name);
    return enumerationField;
  }
  
  /**
   * Signal the finishing of the creation of a new EObject
   */
  private void finishedEObjectCreation(final Class<? extends EObject> modelType, final EObject eObject) {
    this.addCreatedEObject(modelType, eObject);
    this.removeFromCreationStack(modelType, eObject);
  }
  
  /**
   * Create a new LEMMA DataModel from the given EObject instances
   */
  private DataModel toDataModel(final List<EObject> eObjects) {
    final DataModel dataModel = LemmaGenerator.DATA_FACTORY.createDataModel();
    final LinkedHashMap<String, Version> versions = CollectionLiterals.<String, Version>newLinkedHashMap();
    final LinkedHashMap<String, Context> contexts = CollectionLiterals.<String, Context>newLinkedHashMap();
    final LinkedHashMap<String, ComplexType> complexTypes = CollectionLiterals.<String, ComplexType>newLinkedHashMap();
    final Consumer<EObject> _function = (EObject it) -> {
      boolean _matched = false;
      if (it instanceof Version) {
        _matched=true;
        versions.put(((Version)it).getName(), ((Version)it));
      }
      if (!_matched) {
        if (it instanceof Context) {
          _matched=true;
          contexts.put(Util.qualifiedName(it), ((Context)it));
        }
      }
      if (!_matched) {
        if (it instanceof ComplexType) {
          _matched=true;
          complexTypes.put(Util.qualifiedName(it), ((ComplexType)it));
        }
      }
    };
    eObjects.forEach(_function);
    boolean _isEmpty = versions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      dataModel.getVersions().addAll(versions.values());
    } else {
      boolean _isEmpty_1 = contexts.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        dataModel.getContexts().addAll(contexts.values());
      } else {
        dataModel.getComplexTypes().addAll(complexTypes.values());
      }
    }
    return dataModel;
  }
  
  /**
   * Create a new LEMMA TechnologyMapping model from the given EObject instances. The domain
   * import alias must correspond to the alias of the domain model in a service model. The service
   * and Avro import aliases will be used to identify Import instances from the EObject instances
   * that shall point to the given service and Avro technology model paths.
   */
  private TechnologyMapping toMappingModel(final List<EObject> eObjects, final String domainImportAlias, final String serviceModelPath, final String serviceImportAlias, final String avroModelPath, final String avroImportAlias) {
    final TechnologyMapping mappingModel = LemmaGenerator.MAPPING_FACTORY.createTechnologyMapping();
    final LinkedHashMap<String, Import> imports = CollectionLiterals.<String, Import>newLinkedHashMap();
    final LinkedHashMap<String, ComplexTypeMapping> typeMappings = CollectionLiterals.<String, ComplexTypeMapping>newLinkedHashMap();
    final Consumer<EObject> _function = (EObject it) -> {
      boolean _matched = false;
      if (it instanceof Import) {
        _matched=true;
        String _name = ((Import)it).getName();
        boolean _equals = Objects.equal(_name, LemmaGenerator.SERVICE_MODEL_IMPORT_ALIAS);
        if (_equals) {
          ((Import)it).setImportURI(serviceModelPath);
          ((Import)it).setName(serviceImportAlias);
        } else {
          String _name_1 = ((Import)it).getName();
          boolean _equals_1 = Objects.equal(_name_1, Shared.AVRO_TECHNOLOGY_NAME);
          if (_equals_1) {
            ((Import)it).setImportURI(avroModelPath);
            ((Import)it).setName(avroImportAlias);
          }
        }
        if ((Objects.equal(((Import)it).getImportType(), ImportType.MICROSERVICES) || 
          Objects.equal(((Import)it).getImportType(), ImportType.TECHNOLOGY))) {
          imports.put(((Import)it).getName(), ((Import)it));
        }
      }
      if (!_matched) {
        if (it instanceof ComplexTypeMapping) {
          _matched=true;
          Import _serviceModelImport = ((ComplexTypeMapping)it).getType().getServiceModelImport();
          _serviceModelImport.setName(serviceImportAlias);
          Import _dataModelImport = ((ComplexTypeMapping)it).getType().getDataModelImport();
          _dataModelImport.setName(domainImportAlias);
          typeMappings.put(Util.qualifiedName(it), ((ComplexTypeMapping)it));
        }
      }
    };
    eObjects.forEach(_function);
    mappingModel.getImports().addAll(imports.values());
    mappingModel.getTypeMappings().addAll(typeMappings.values());
    return mappingModel;
  }
  
  /**
   * Generate LEMMA EObjects from Avro Fixed or Record schema. Returns a pair consisting of the
   * EObject (LEMMA DataStructure) specifically derived from the passed schema and all other
   * EObjects that were derived during EObject generation in the context of the passed schema.
   */
  public Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toDataStructure(final Schema schema) {
    this.ensureType(schema, 
      Schema.Type.FIXED, 
      Schema.Type.RECORD);
    return this.toDataStructure(schema, schema.getNamespace());
  }
  
  /**
   * Generate LEMMA EObjects from Avro Fixed, Map, Record, or Union schema in the given namespace.
   * Returns a pair consisting of the EObject (LEMMA DataStructure) specifically derived from the
   * passed schema and all other EObjects that were derived during EObject generation in the
   * context of the passed schema.
   */
  public Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toDataStructure(final Schema schema, final String namespace) {
    this.ensureType(schema, 
      Schema.Type.FIXED, 
      Schema.Type.MAP, 
      Schema.Type.RECORD, 
      Schema.Type.UNION);
    boolean _existsEObject = this.existsEObject(this.lemmaNameElseSchemaName(schema), namespace, DataModel.class);
    if (_existsEObject) {
      return null;
    }
    final DataStructure dataStructure = this.createDataStructure(this.lemmaNameElseSchemaName(schema), namespace);
    this.startedEObjectCreation(DataModel.class, dataStructure);
    final Function1<Schema.Field, DataField> _function = (Schema.Field it) -> {
      return this.toDataField(it.name(), it.schema(), it.defaultVal(), dataStructure);
    };
    dataStructure.getDataFields().addAll(
      ListExtensions.<Schema.Field, DataField>map(schema.getFields(), _function));
    boolean _isError = schema.isError();
    if (_isError) {
      this.adaptToAvroError(dataStructure);
    } else {
      Schema.Type _type = schema.getType();
      boolean _equals = Objects.equal(_type, Schema.Type.FIXED);
      if (_equals) {
        this.adaptToAvroFixed(dataStructure);
      } else {
        Schema.Type _type_1 = schema.getType();
        boolean _equals_1 = Objects.equal(_type_1, Schema.Type.MAP);
        if (_equals_1) {
          this.adaptToAvroMap(dataStructure);
        } else {
          Schema.Type _type_2 = schema.getType();
          boolean _equals_2 = Objects.equal(_type_2, Schema.Type.UNION);
          if (_equals_2) {
            this.adaptToAvroUnion(dataStructure);
          }
        }
      }
    }
    this.finishedEObjectCreation(DataModel.class, dataStructure);
    Map<Class<? extends EObject>, List<EObject>> _allCreatedEObjects = this.allCreatedEObjects();
    return Pair.<EObject, Map<Class<? extends EObject>, List<EObject>>>of(dataStructure, _allCreatedEObjects);
  }
  
  /**
   * Check if an EObject with the given name and Avro namespace was already created or is under
   * creation in the context of the given model type
   */
  private boolean existsEObject(final String name, final String avroNamespace, final Class<? extends EObject> modelType) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(avroNamespace);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(avroNamespace);
        _builder.append(".");
      }
    }
    _builder.append(name);
    final String qualifiedName = _builder.toString();
    return (this.existsCreatedEObject(modelType, qualifiedName) || 
      this.existsOnCreationStack(modelType, qualifiedName));
  }
  
  /**
   * Create a LEMMA DataStructure with the given name, and a version and context corresponding to
   * the given Avro namespace
   */
  private DataStructure createDataStructure(final String name, final String avroNamespace) {
    final DataStructure structure = LemmaGenerator.DATA_FACTORY.createDataStructure();
    structure.setName(name);
    structure.setVersion(this.getOrCreateVersion(avroNamespace));
    structure.setContext(this.getOrCreateContext(avroNamespace));
    return structure;
  }
  
  /**
   * Create a LEMMA DataField with the given name and type derived from the given Avro schema.
   * The data field may receive an initialization value and is part of a concrete ComplexType.
   */
  private DataField toDataField(final String name, final Schema typeSchema, final Object initializationValue, final ComplexType parentType) {
    final DataField dataField = LemmaGenerator.DATA_FACTORY.createDataField();
    dataField.setName(name);
    final Type type = this.toType(typeSchema, parentType);
    boolean _matched = false;
    if (type instanceof PrimitiveType) {
      _matched=true;
      dataField.setPrimitiveType(((PrimitiveType)type));
    }
    if (!_matched) {
      if (type instanceof ComplexType) {
        _matched=true;
        dataField.setComplexType(((ComplexType)type));
      }
    }
    if ((type instanceof PrimitiveType)) {
      String _string = null;
      if (initializationValue!=null) {
        _string=initializationValue.toString();
      }
      dataField.setInitializationValue(Shared.toPrimitiveLemmaValue(_string, ((PrimitiveType)type)));
    }
    return dataField;
  }
  
  /**
   * Derive LEMMA Type from the given Avro schema
   */
  private Type toType(final Schema schema, final ComplexType parentType) {
    Type _xifexpression = null;
    boolean _isPrimitiveAvroType = Shared.isPrimitiveAvroType(schema);
    if (_isPrimitiveAvroType) {
      _xifexpression = Shared.toPrimitiveLemmaType(schema);
    } else {
      ComplexType _xifexpression_1 = null;
      boolean _existsCreatedEObject = this.existsCreatedEObject(DataModel.class, schema.getFullName());
      if (_existsCreatedEObject) {
        _xifexpression_1 = this.<ComplexType>getCreatedEObject(DataModel.class, schema.getFullName());
      } else {
        ComplexType _xifexpression_2 = null;
        boolean _existsOnCreationStack = this.existsOnCreationStack(DataModel.class, schema.getFullName());
        if (_existsOnCreationStack) {
          _xifexpression_2 = this.<ComplexType>getFromCreationStack(DataModel.class, schema.getFullName());
        } else {
          ComplexType _xifexpression_3 = null;
          boolean _isNamedSchema = Shared.isNamedSchema(schema);
          if (_isNamedSchema) {
            EObject _key = this.generateEObjectsFromNamedSchema(schema).getKey();
            _xifexpression_3 = ((ComplexType) _key);
          } else {
            ComplexType _xblockexpression = null;
            {
              final String namespace = LemmaUtils.getQualifyingParts(Util.qualifiedName(parentType));
              EObject _key_1 = this.generateEObjectsFromUnnamedSchema(schema, namespace).getKey();
              _xblockexpression = ((ComplexType) _key_1);
            }
            _xifexpression_3 = _xblockexpression;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    final Type type = _xifexpression;
    if ((type == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Type ");
      Schema.Type _type = schema.getType();
      _builder.append(_type);
      _builder.append(" of schema ");
      StringConcatenation _builder_1 = new StringConcatenation();
      String _fullName = schema.getFullName();
      _builder_1.append(_fullName);
      _builder_1.append(" cannot be converted to LEMMA type");
      String _plus = (_builder.toString() + _builder_1);
      throw new IllegalArgumentException(_plus);
    }
    return type;
  }
  
  /**
   * Generate LEMMA EObjects from an Avro unnamed schema (Arrays, Maps, Unions). Returns a pair
   * consisting of the LEMMA EObject specifically derived from the passed schema and all other
   * EObjects that were derived during EObject generation in the context of the passed schema.
   */
  private Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> generateEObjectsFromUnnamedSchema(final Schema schema, final String namespace) {
    boolean _isNamedSchema = Shared.isNamedSchema(schema);
    if (_isNamedSchema) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Avro schema of type ");
      Schema.Type _type = schema.getType();
      _builder.append(_type);
      _builder.append(" is not an ");
      String _plus = (_builder.toString() + 
        "unnamed schema");
      throw new IllegalArgumentException(_plus);
    }
    Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> _switchResult = null;
    Schema.Type _type_1 = schema.getType();
    if (_type_1 != null) {
      switch (_type_1) {
        case ARRAY:
          _switchResult = this.toCollectionType(schema, namespace);
          break;
        case MAP:
        case UNION:
          _switchResult = this.toDataStructure(schema, namespace);
          break;
        default:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("schema type ");
          Schema.Type _type_2 = schema.getType();
          _builder_1.append(_type_2);
          _builder_1.append(" is not supported");
          String _plus_1 = ("EObject generation from unnamed Avro " + _builder_1);
          throw new IllegalArgumentException(_plus_1);
      }
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("schema type ");
      Schema.Type _type_2 = schema.getType();
      _builder_1.append(_type_2);
      _builder_1.append(" is not supported");
      String _plus_1 = ("EObject generation from unnamed Avro " + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    return _switchResult;
  }
  
  /**
   * Generate LEMMA EObjects from Avro Array schema in the given namespace. Returns a pair
   * consisting of the EObject (LEMMA CollectionType) specifically derived from the passed schema
   * and all other EObjects that were derived during EObject generation in the context of the
   * passed schema.
   */
  public Pair<EObject, Map<Class<? extends EObject>, List<EObject>>> toCollectionType(final Schema schema, final String namespace) {
    this.ensureType(schema, Schema.Type.ARRAY);
    String _lemmaNameElseSchemaName = this.lemmaNameElseSchemaName(schema);
    String _lemmaName = Shared.lemmaName(schema);
    boolean _tripleNotEquals = (_lemmaName != null);
    final CollectionType collectionType = this.createCollectionType(_lemmaNameElseSchemaName, namespace, _tripleNotEquals);
    this.startedEObjectCreation(DataModel.class, collectionType);
    final Schema typeSchema = schema.getElementType();
    boolean _isPrimitiveAvroType = Shared.isPrimitiveAvroType(typeSchema);
    if (_isPrimitiveAvroType) {
      collectionType.setPrimitiveType(Shared.toPrimitiveLemmaType(schema.getElementType()));
    } else {
      Schema.Type _type = typeSchema.getType();
      boolean _equals = Objects.equal(_type, Schema.Type.RECORD);
      if (_equals) {
        final Function1<Schema.Field, DataField> _function = (Schema.Field it) -> {
          return this.toDataField(it.name(), it.schema(), null, collectionType);
        };
        collectionType.getDataFields().addAll(
          ListExtensions.<Schema.Field, DataField>map(typeSchema.getFields(), _function));
      } else {
        collectionType.getDataFields().add(
          this.toDataField(StringExtensions.toFirstLower(this.lemmaNameElseSchemaName(typeSchema)), typeSchema, null, collectionType));
      }
    }
    this.finishedEObjectCreation(DataModel.class, collectionType);
    Map<Class<? extends EObject>, List<EObject>> _allCreatedEObjects = this.allCreatedEObjects();
    return Pair.<EObject, Map<Class<? extends EObject>, List<EObject>>>of(collectionType, _allCreatedEObjects);
  }
  
  /**
   * Create LEMMA CollectionType with the given name and in the LEMMA namespace corresponding to
   * the given Avro namespace. A unique name for the CollectionType may be generated, e.g., when
   * the source Avro schema was an unnamed nested schema inside another schema.
   */
  private CollectionType createCollectionType(final String name, final String avroNamespace, final boolean generateUniqueName) {
    final CollectionType collectionType = LemmaGenerator.DATA_FACTORY.createCollectionType();
    collectionType.setName(name);
    collectionType.setVersion(this.getOrCreateVersion(avroNamespace));
    collectionType.setContext(this.getOrCreateContext(avroNamespace));
    if (generateUniqueName) {
      collectionType.setName(this.toUniqueName(Util.qualifiedName(collectionType), DataModel.class));
    }
    return collectionType;
  }
  
  /**
   * Adapt a LEMMA DataStructure to represent an Avro Error. Avro Errors are represented in LEMMA
   * by means of structures with the AvroError aspect.
   */
  private void adaptToAvroError(final DataStructure structure) {
    final Pair<ComplexTypeMapping, Import> mappingAndAvroImport = this.createDefaultComplexTypeMapping(structure);
    final ComplexTypeMapping complexTypeMapping = mappingAndAvroImport.getKey();
    final Import avroImport = mappingAndAvroImport.getValue();
    this.startedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
    this.addAspect(complexTypeMapping, avroImport, Shared.ERROR_ASPECT);
    this.finishedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
  }
  
  /**
   * Create a LEMMA ComplexTypeMapping for the given LEMMA DataStructure based on the Avro
   * technology model. The mapping takes default values for the Avro technology name, and service
   * and domain model import aliases. The method returns a pair consisting of the
   * ComplexTypeMapping and the Import instance for the Avro technology model.
   */
  private Pair<ComplexTypeMapping, Import> createDefaultComplexTypeMapping(final DataStructure structure) {
    final Import preliminaryAvroImport = this.getOrCreateImport(Shared.AVRO_TECHNOLOGY_NAME, null, 
      ImportType.TECHNOLOGY, TechnologyMapping.class);
    final Import preliminaryServiceModelImport = this.getOrCreateImport(LemmaGenerator.SERVICE_MODEL_IMPORT_ALIAS, null, 
      ImportType.MICROSERVICES, TechnologyMapping.class);
    final Import preliminaryDomainModelImport = this.getOrCreateImport(LemmaGenerator.DOMAIN_MODEL_IMPORT_ALIAS, null, 
      ImportType.DATATYPES, TechnologyMapping.class);
    ComplexTypeMapping _createComplexTypeMapping = this.createComplexTypeMapping(preliminaryAvroImport, preliminaryServiceModelImport, preliminaryDomainModelImport, structure);
    return Pair.<ComplexTypeMapping, Import>of(_createComplexTypeMapping, preliminaryAvroImport);
  }
  
  /**
   * Helper to get or create an Import instance with the given name, URI and type, and for the
   * given model type
   */
  private Import getOrCreateImport(final String name, final String importUri, final ImportType importType, final Class<? extends EObject> importingModelType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$import.");
    _builder.append(name);
    final String qualifiedName = _builder.toString();
    Import _import = this.<Import>getCreatedEObject(importingModelType, qualifiedName);
    if ((_import == null)) {
      _import = LemmaGenerator.SERVICE_FACTORY.createImport();
      _import.setName(name);
      _import.setImportURI(importUri);
      _import.setImportType(importType);
      this.addCreatedEObject(importingModelType, _import, qualifiedName);
    }
    return _import;
  }
  
  /**
   * Create a LEMMA ComplexTypeMapping for the given LEMMA ComplexType using the specified
   * technology, service, and domain model Imports
   */
  private ComplexTypeMapping createComplexTypeMapping(final Import technologyImport, final Import serviceModelImport, final Import domainModelImport, final ComplexType complexType) {
    final ComplexTypeMapping mapping = LemmaGenerator.MAPPING_FACTORY.createComplexTypeMapping();
    mapping.getTechnologyReferences().add(this.createTechnologyReference(technologyImport));
    mapping.setType(this.createImportedComplexTypeToMap(serviceModelImport, domainModelImport, complexType));
    return mapping;
  }
  
  /**
   * Create a LEMMA TechnologyReference for the given technology Import
   */
  private TechnologyReference createTechnologyReference(final Import technologyImport) {
    final TechnologyReference technologyReference = LemmaGenerator.SERVICE_FACTORY.createTechnologyReference();
    technologyReference.setTechnology(technologyImport);
    return technologyReference;
  }
  
  /**
   * Create a LEMMA ImportedComplexTypeToMap for the given ComplexType with the specified service
   * and domain model Imports
   */
  private ImportedComplexTypeToMap createImportedComplexTypeToMap(final Import serviceModelImport, final Import domainModelImport, final ComplexType complexType) {
    final ImportedComplexTypeToMap importedComplexTypeToMap = LemmaGenerator.MAPPING_FACTORY.createImportedComplexTypeToMap();
    importedComplexTypeToMap.setServiceModelImport(serviceModelImport);
    importedComplexTypeToMap.setDataModelImport(domainModelImport);
    importedComplexTypeToMap.setType(complexType);
    return importedComplexTypeToMap;
  }
  
  /**
   * Add an aspect with the specified name from the given technology Import to the given
   * ComplexTypeMapping
   */
  private void addAspect(final ComplexTypeMapping mapping, final Import technologyImport, final String aspectName) {
    mapping.getAspects().add(this.createImportedAspect(technologyImport, aspectName));
  }
  
  /**
   * Create a LEMMA TechnologySpecificImportedServiceAspect for the aspect with the given name
   * from the specified technology Import
   */
  private TechnologySpecificImportedServiceAspect createImportedAspect(final Import technologyImport, final String aspectName) {
    final TechnologySpecificImportedServiceAspect aspect = LemmaGenerator.MAPPING_FACTORY.createTechnologySpecificImportedServiceAspect();
    aspect.setTechnology(technologyImport);
    aspect.setAspect(LemmaGenerator.TECHNOLOGY_FACTORY.createServiceAspect());
    ServiceAspect _aspect = aspect.getAspect();
    _aspect.setName(aspectName);
    return aspect;
  }
  
  /**
   * Adapt a LEMMA DataStructure to represent an Avro Fixed type. Avro Fixed types are represented
   * in LEMMA by means of structures with a single integer data field, whose initialization value
   * must be greater zero. Moreover, the structure receives the AvroFixed and the field the
   * AvroFixedSize aspect.
   */
  private void adaptToAvroFixed(final DataStructure structure) {
    final int fieldCount = structure.getDataFields().size();
    if ((fieldCount != 1)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Structure ");
      String _qualifiedName = Util.qualifiedName(structure);
      _builder.append(_qualifiedName);
      _builder.append(" does ");
      String _plus = (_builder.toString() + 
        "not represent an Avro Fixed type: Invalid field count (expected: 1, found: ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(fieldCount);
      _builder_1.append(")");
      String _plus_1 = (_plus + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    final DataField sizeField = structure.getDataFields().get(0);
    Type _effectiveType = sizeField.getEffectiveType();
    boolean _not = (!(_effectiveType instanceof PrimitiveInteger));
    if (_not) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Structure ");
      String _qualifiedName_1 = Util.qualifiedName(structure);
      _builder_2.append(_qualifiedName_1);
      _builder_2.append(" does ");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("not represent an Avro Fixed type: Size field ");
      String _name = sizeField.getName();
      _builder_3.append(_name);
      _builder_3.append(" has invalid ");
      String _plus_2 = (_builder_2.toString() + _builder_3);
      String _plus_3 = (_plus_2 + 
        "type (expected: PrimitiveInteger, found: ");
      StringConcatenation _builder_4 = new StringConcatenation();
      String _simpleName = sizeField.getEffectiveType().getClass().getSimpleName();
      _builder_4.append(_simpleName);
      _builder_4.append(")");
      String _plus_4 = (_plus_3 + _builder_4);
      throw new IllegalArgumentException(_plus_4);
    } else {
      PrimitiveValue _initializationValue = sizeField.getInitializationValue();
      boolean _tripleEquals = (_initializationValue == null);
      if (_tripleEquals) {
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("Structure ");
        String _qualifiedName_2 = Util.qualifiedName(structure);
        _builder_5.append(_qualifiedName_2);
        _builder_5.append(" does ");
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("not represent an Avro Fixed type: Size field ");
        String _name_1 = sizeField.getName();
        _builder_6.append(_name_1);
        _builder_6.append(" has no ");
        String _plus_5 = (_builder_5.toString() + _builder_6);
        String _plus_6 = (_plus_5 + 
          "initialization value");
        throw new IllegalArgumentException(_plus_6);
      } else {
        if (((sizeField.getInitializationValue().asInteger() == null) || 
          ((sizeField.getInitializationValue().asInteger()).intValue() <= 0))) {
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("Structure ");
          String _qualifiedName_3 = Util.qualifiedName(structure);
          _builder_7.append(_qualifiedName_3);
          _builder_7.append(" does ");
          String _plus_7 = (_builder_7.toString() + 
            "not represent an Avro Fixed type: Initialization value ");
          StringConcatenation _builder_8 = new StringConcatenation();
          String _valueAsString = sizeField.getInitializationValue().valueAsString();
          _builder_8.append(_valueAsString);
          _builder_8.append(" of size field ");
          String _plus_8 = (_plus_7 + _builder_8);
          StringConcatenation _builder_9 = new StringConcatenation();
          String _name_2 = sizeField.getName();
          _builder_9.append(_name_2);
          _builder_9.append(" is not a valid positive Integer value");
          String _plus_9 = (_plus_8 + _builder_9);
          throw new IllegalArgumentException(_plus_9);
        }
      }
    }
    final Pair<ComplexTypeMapping, Import> mappingAndAvroImport = this.createDefaultComplexTypeMapping(structure);
    final ComplexTypeMapping complexTypeMapping = mappingAndAvroImport.getKey();
    final Import avroImport = mappingAndAvroImport.getValue();
    this.startedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
    this.addAspect(complexTypeMapping, avroImport, Shared.FIXED_ASPECT);
    this.addAspect(complexTypeMapping, sizeField, avroImport, Shared.FIXED_SIZE_ASPECT);
    this.finishedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
  }
  
  /**
   * Add an aspect with the specified name from the given technology Import and for the given data
   * field to the passed ComplexTypeMapping
   */
  private void addAspect(final ComplexTypeMapping mapping, final DataField field, final Import technologyImport, final String aspectName) {
    final TechnologySpecificFieldMapping fieldMapping = LemmaGenerator.MAPPING_FACTORY.createTechnologySpecificFieldMapping();
    fieldMapping.setTechnology(technologyImport);
    fieldMapping.setDataField(field);
    fieldMapping.getAspects().add(this.createImportedAspect(technologyImport, aspectName));
    mapping.getFieldMappings().add(fieldMapping);
  }
  
  /**
   * Adapt a LEMMA DataStructure to represent an Avro Map type. Avro Map types are represented
   * in LEMMA by means of structures with a single data field for storing the map's values. The
   * structure is then adapted to comprise a second field called "key" of type String for the
   * map's keys. The structure receives the AvroMap aspect. The key and value field are augmented
   * with the AvroMapKey and AvroMapValue aspect, respectively.
   */
  private void adaptToAvroMap(final DataStructure structure) {
    structure.setName(this.toUniqueName(Util.qualifiedName(structure), DataModel.class));
    final int fieldCount = structure.getDataFields().size();
    if ((fieldCount != 1)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Structure ");
      String _qualifiedName = Util.qualifiedName(structure);
      _builder.append(_qualifiedName);
      _builder.append(" does ");
      String _plus = (_builder.toString() + 
        "not represent an Avro Map: Invalid field count (expected: 1, found: ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(fieldCount);
      _builder_1.append(")");
      String _plus_1 = (_plus + _builder_1);
      throw new IllegalArgumentException(_plus_1);
    }
    final Pair<ComplexTypeMapping, Import> mappingAndAvroImport = this.createDefaultComplexTypeMapping(structure);
    final ComplexTypeMapping complexTypeMapping = mappingAndAvroImport.getKey();
    final Import avroImport = mappingAndAvroImport.getValue();
    this.startedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
    this.addAspect(complexTypeMapping, avroImport, Shared.MAP_ASPECT);
    final DataField valueField = structure.getDataFields().get(0);
    this.addAspect(complexTypeMapping, valueField, avroImport, Shared.MAP_VALUE_ASPECT);
    final Function1<DataField, Boolean> _function = (DataField it) -> {
      return Boolean.valueOf(it.getName().startsWith("key"));
    };
    final int keyFieldCount = IterableExtensions.size(IterableExtensions.<DataField>filter(structure.getDataFields(), _function));
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("key");
    {
      if ((keyFieldCount > 0)) {
        _builder_2.append((keyFieldCount + 1));
      }
    }
    final String keyFieldName = _builder_2.toString();
    final DataField keyField = this.toDataField(keyFieldName, Schema.create(Schema.Type.STRING), null, structure);
    structure.getDataFields().add(keyField);
    this.addAspect(complexTypeMapping, keyField, avroImport, Shared.MAP_KEY_ASPECT);
    this.finishedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
  }
  
  /**
   * Derive a unique name based on the given qualified name and in the context of the given LEMMA
   * model type. If the given qualified name is not unique already, the derived unique name will
   * be prefixed by an index starting at 1 and being incremented for each existing name.
   */
  private String toUniqueName(final String qualifiedName, final Class<? extends EObject> modelType) {
    String uniqueQualifiedName = qualifiedName;
    final Pair<String, String> nameParts = Util.splitNameParts(uniqueQualifiedName);
    String uniqueName = nameParts.getValue();
    if (((!this.eObjectNames.containsKey(modelType)) || 
      (!this.eObjectNames.get(modelType).contains(uniqueQualifiedName)))) {
      return uniqueName;
    }
    int uniqueIndex = 0;
    while (this.eObjectNames.get(modelType).contains(uniqueQualifiedName)) {
      {
        int _uniqueIndex = uniqueIndex;
        uniqueIndex = (_uniqueIndex + 1);
        uniqueQualifiedName = (uniqueQualifiedName + Integer.valueOf(uniqueIndex));
        uniqueName = (uniqueName + Integer.valueOf(uniqueIndex));
      }
    }
    return uniqueName;
  }
  
  /**
   * Adapt a LEMMA DataStructure to represent an Avro Union. Avro Unions are represented in LEMMA
   * by means of structures with the AvroUnion aspect.
   */
  private void adaptToAvroUnion(final DataStructure structure) {
    structure.setName(this.toUniqueName(Util.qualifiedName(structure), DataModel.class));
    final Pair<ComplexTypeMapping, Import> mappingAndAvroImport = this.createDefaultComplexTypeMapping(structure);
    final ComplexTypeMapping complexTypeMapping = mappingAndAvroImport.getKey();
    final Import avroImport = mappingAndAvroImport.getValue();
    this.startedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
    this.addAspect(complexTypeMapping, avroImport, Shared.UNION_ASPECT);
    this.finishedEObjectCreation(TechnologyMapping.class, complexTypeMapping);
  }
}

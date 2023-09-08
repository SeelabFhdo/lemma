package de.fhdo.lemma.data.avro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.Context;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.intermediate.IntermediateComplexType;
import de.fhdo.lemma.data.intermediate.IntermediateContext;
import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType;
import de.fhdo.lemma.data.intermediate.IntermediateType;
import de.fhdo.lemma.data.intermediate.IntermediateVersion;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * This class collects _static_ utility methods for the Avro plugin.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Util {
  /**
   * Enumeration for complex type definition kinds inside a data model
   */
  private enum COMPLEX_TYPE_DEFINITION_KIND {
    VERSION,

    VERSION_CONTEXT,

    CONTEXT,

    TOP_LEVEL;
  }

  /**
   * Get all visible fields of an IntermediateDataStructure
   */
  public static List<IntermediateDataField> visibleFields(final IntermediateDataStructure structure) {
    final Function1<IntermediateDataField, Boolean> _function = (IntermediateDataField it) -> {
      boolean _isHidden = it.isHidden();
      return Boolean.valueOf((!_isHidden));
    };
    return IterableExtensions.<IntermediateDataField>toList(IterableExtensions.<IntermediateDataField>filter(structure.getDataFields(), _function));
  }

  /**
   * Check if an EObject exhibits an aspect of the given qualifiedAspectName
   */
  public static boolean hasAspect(final EObject eObject, final String qualifiedAspectName) {
    EList<IntermediateImportedAspect> _switchResult = null;
    boolean _matched = false;
    if (eObject instanceof IntermediateDataStructure) {
      _matched=true;
      _switchResult = ((IntermediateDataStructure)eObject).getAspects();
    }
    if (!_matched) {
      if (eObject instanceof IntermediateDataField) {
        _matched=true;
        _switchResult = ((IntermediateDataField)eObject).getAspects();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      String _simpleName = eObject.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" does not support having aspects");
      String _plus = ("EObject of type " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final EList<IntermediateImportedAspect> aspects = _switchResult;
    final Function1<IntermediateImportedAspect, Boolean> _function = (IntermediateImportedAspect it) -> {
      String _qualifiedName = it.getQualifiedName();
      return Boolean.valueOf(Objects.equal(_qualifiedName, qualifiedAspectName));
    };
    return IterableExtensions.<IntermediateImportedAspect>exists(aspects, _function);
  }

  /**
   * Get the count of qualifying levels from a qualified string. This count corresponds to the
   * number of qualifying parts of the qualified string.
   */
  public static int qualifyingLevelCount(final String qualifiedString) {
    int _xblockexpression = (int) 0;
    {
      final String qualifyingParts = LemmaUtils.getQualifyingParts(qualifiedString);
      _xblockexpression = Util.countMatches(qualifyingParts, ".");
    }
    return _xblockexpression;
  }

  /**
   * Helper to count how often a given String sub is comprised in a given String s.
   * 
   * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
   * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
   * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
   * include Apache Commons Lang by default.
   */
  private static int countMatches(final String s, final String sub) {
    if ((StringExtensions.isNullOrEmpty(s) || StringExtensions.isNullOrEmpty(sub))) {
      return 0;
    }
    int count = 0;
    int idx = 0;
    while (((idx = s.indexOf(sub, idx)) != (-1))) {
      {
        count++;
        int _idx = idx;
        int _length = sub.length();
        idx = (_idx + _length);
      }
    }
    return count;
  }

  /**
   * Convenience method to get the qualifying parts of a qualified string as list
   */
  public static List<String> getQualifyingPartsAsList(final String qualifiedString) {
    final String qualifyingParts = LemmaUtils.getQualifyingParts(qualifiedString);
    String[] _split = null;
    if (qualifyingParts!=null) {
      _split=qualifyingParts.split("\\.");
    }
    return (List<String>)Conversions.doWrapArray(_split);
  }

  /**
   * Split a given qualified string into its qualifying parts and simple name. Returns a pair
   * consisting of the qualifying parts and simple name.
   */
  public static Pair<String, String> splitNameParts(final String qualifiedString) {
    String _qualifyingParts = LemmaUtils.getQualifyingParts(qualifiedString);
    String _simpleName = LemmaUtils.getSimpleName(qualifiedString);
    return Pair.<String, String>of(_qualifyingParts, _simpleName);
  }

  /**
   * Load an intermediate data model in XMI format from the given file path
   */
  public static IntermediateDataModel loadIntermediateDataModel(final String filepath) {
    try {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      final Map<String, Object> extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      extensionFactoryMap.put("xmi", _xMIResourceFactoryImpl);
      String _removeFileUri = LemmaUtils.removeFileUri(filepath);
      final String absolutePath = new File(_removeFileUri).getAbsolutePath();
      final Resource resource = resourceSet.createResource(URI.createURI(LemmaUtils.convertToFileUri(absolutePath)));
      resource.load(null);
      EObject _get = resource.getContents().get(0);
      final IntermediateDataModel modelRoot = ((IntermediateDataModel) _get);
      final Consumer<IntermediateImport> _function = (IntermediateImport it) -> {
        it.setImportUri(LemmaUtils.convertToAbsoluteFileUri(it.getImportUri(), absolutePath));
      };
      modelRoot.getImports().forEach(_function);
      return modelRoot;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Add a value to a nested set inside a map. Suppose a map
   *      val map = {"key1" -> {"setValue1"}}
   * 
   * Invoking this methods with
   *      addToValueSet(map, "key1", "setValue2")
   * will change the map to
   *      {"key1" -> {"setValue1", "setValue2"}}
   * 
   * In case a nested set does not exist for the target key ("key1" above) or the target key
   * itself does not exist, a new nested set with the new value ("newValue" above) will be put to
   * the target map ("map" above).
   */
  public static <K extends Object, V extends Object> boolean addToValueSet(final Map<K, Set<V>> targetMap, final K targetKey, final V newValue) {
    final Function<Void, Set<V>> _function = (Void it) -> {
      return CollectionLiterals.<V>newHashSet();
    };
    return Util.<K, V, Set<V>>addToValueCollection(targetMap, targetKey, newValue, _function);
  }

  /**
   * Generic function to add a value to a nested Collection of elements inside a map (cf.
   * addToValueSet). The newCollection function will be invoked to retrieve a new instance of the
   * nested Collection, if necessary.
   */
  public static <K extends Object, V extends Object, C extends Collection<V>> boolean addToValueCollection(final Map<K, C> targetMap, final K targetKey, final V newValue, final Function<Void, C> newCollection) {
    C _xifexpression = null;
    boolean _containsKey = targetMap.containsKey(targetKey);
    if (_containsKey) {
      _xifexpression = targetMap.get(targetKey);
    } else {
      C _xblockexpression = null;
      {
        final C newList = newCollection.apply(null);
        targetMap.put(targetKey, newList);
        _xblockexpression = newList;
      }
      _xifexpression = _xblockexpression;
    }
    final C targetCollection = _xifexpression;
    return targetCollection.add(newValue);
  }

  /**
   * Generic function to remove a value from a nested Collection of elements inside a map
   */
  public static <K extends Object, V extends Object> boolean removeFromValueCollection(final Map<K, ? extends Collection<V>> targetMap, final K targetKey, final V oldValue) {
    final Collection<V> targetList = targetMap.get(targetKey);
    if ((targetList == null)) {
      return false;
    }
    boolean _isEmpty = targetList.isEmpty();
    if (_isEmpty) {
      targetMap.remove(targetKey);
    }
    return targetList.remove(oldValue);
  }

  /**
   * Add a value to a nested map inside a map. Suppose a map
   *      val map = {"key1" -> {"nestedKey1" -> "nestedValue1"}}
   * 
   * Invoking this methods with
   *      addToValueMap(map, "key1", "nestedKey1", "newValue")
   * will change the map to
   *      {"key1" -> {"nestedKey1" -> "newValue"}}
   * 
   * In case a nested map does not exist for the target key ("key1" above) or the target key
   * itself does not exist, a new nested map with the new value ("newValue" above) will be put to
   * the target map ("map" above).
   */
  public static <K1 extends Object, K2 extends Object, V extends Object> V addToValueMap(final Map<K1, Map<K2, V>> targetMap, final K1 targetKey, final K2 nestedKey, final V newValue) {
    Map<K2, V> _xifexpression = null;
    boolean _containsKey = targetMap.containsKey(targetKey);
    if (_containsKey) {
      _xifexpression = targetMap.get(targetKey);
    } else {
      HashMap<K2, V> _xblockexpression = null;
      {
        final HashMap<K2, V> newMap = CollectionLiterals.<K2, V>newHashMap();
        targetMap.put(targetKey, newMap);
        _xblockexpression = newMap;
      }
      _xifexpression = _xblockexpression;
    }
    final Map<K2, V> nestedMap = _xifexpression;
    return nestedMap.put(nestedKey, newValue);
  }

  /**
   * Remove a key from a nested map inside a map. Suppose a map
   *      val map = {"key1" -> {"nestedKey1" -> "nestedValue1"}}
   * 
   * Invoking this methods with
   *      removeFromValueMap(map, "key1", "nestedKey1")
   * will change the map to
   *      {"key1" -> {}}
   * 
   * The result is the value, which was associated with the given nested key ("nestedValue1" for
   * "nestedKey1" above). If the nested key does not exist, the method returns null.
   */
  public static <K1 extends Object, K2 extends Object, V extends Object> V removeFromValueMap(final Map<K1, Map<K2, V>> targetMap, final K1 targetKey, final K2 nestedKey) {
    final Map<K2, V> nestedMap = targetMap.get(targetKey);
    V _xifexpression = null;
    if ((nestedMap != null)) {
      V _xblockexpression = null;
      {
        final V nestedRemovalResult = nestedMap.remove(nestedKey);
        boolean _isEmpty = nestedMap.isEmpty();
        if (_isEmpty) {
          targetMap.remove(targetKey);
        }
        _xblockexpression = nestedRemovalResult;
      }
      _xifexpression = _xblockexpression;
    } else {
      return null;
    }
    return _xifexpression;
  }

  /**
   * Check if the given LEMMA intermediate type is a primitive type with the given type name
   */
  public static boolean isPrimitiveType(final IntermediateType type, final String typeName) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _xblockexpression = false;
      {
        final IntermediatePrimitiveType primitiveType = ((IntermediatePrimitiveType) type);
        String _name = primitiveType.getName();
        _xblockexpression = Objects.equal(_name, typeName);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        _xtrycatchfinallyexpression = false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  /**
   * Get the qualified name of a LEMMA EObject instance. Throws an IllegalArgumentException, if
   * the EObject does not support having a qualified name.
   */
  public static String qualifiedName(final EObject eObject) {
    String _switchResult = null;
    boolean _matched = false;
    if (eObject instanceof Context) {
      _matched=true;
      _switchResult = ((Context)eObject).buildQualifiedName(".");
    }
    if (!_matched) {
      if (eObject instanceof ComplexType) {
        _matched=true;
        _switchResult = ((ComplexType)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof DataOperation) {
        _matched=true;
        _switchResult = ((DataOperation)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof DataOperationParameter) {
        _matched=true;
        _switchResult = ((DataOperationParameter)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof DataField) {
        _matched=true;
        _switchResult = ((DataField)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof EnumerationField) {
        _matched=true;
        _switchResult = ((EnumerationField)eObject).buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof ComplexTypeMapping) {
        _matched=true;
        _switchResult = ((ComplexTypeMapping)eObject).getType().getType().buildQualifiedName(".");
      }
    }
    if (!_matched) {
      if (eObject instanceof IntermediateVersion) {
        _matched=true;
        _switchResult = ((IntermediateVersion)eObject).getName();
      }
    }
    if (!_matched) {
      if (eObject instanceof IntermediateContext) {
        _matched=true;
        _switchResult = ((IntermediateContext)eObject).getQualifiedName();
      }
    }
    if (!_matched) {
      if (eObject instanceof IntermediateComplexType) {
        _matched=true;
        _switchResult = ((IntermediateComplexType)eObject).getQualifiedName();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EObjects of type ");
      String _simpleName = eObject.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" is not supported");
      String _plus = ("Building fully-qualified name for " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }

  /**
   * Get the error message of an Exception. If the exception's error message is null or empty,
   * return the simple name of the Exception class.
   */
  public static String getErrorMessageOrSimpleClassName(final Exception ex) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(ex.getMessage());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = ex.getMessage();
    } else {
      _xifexpression = ex.getClass().getSimpleName();
    }
    return _xifexpression;
  }

  /**
   * Get the top level type containers of a data model. A top level type container is an EObject
   * instance at the top level of a data model that may hold complex type definitions.
   * Effectively, only (Intermediate)Versions, (Intermediate)Contexts, or the
   * (Intermediate)DataModel itself may be a top level container.
   */
  public static List<? extends EObject> getTopLevelComplexTypeContainers(final IntermediateDataModel dataModel) {
    List<? extends EObject> _switchResult = null;
    Util.COMPLEX_TYPE_DEFINITION_KIND _complexTypeDefinitionKind = Util.complexTypeDefinitionKind(dataModel);
    if (_complexTypeDefinitionKind != null) {
      switch (_complexTypeDefinitionKind) {
        case VERSION:
        case VERSION_CONTEXT:
          _switchResult = dataModel.getVersions();
          break;
        case CONTEXT:
          _switchResult = dataModel.getContexts();
          break;
        case TOP_LEVEL:
          List<? extends EObject> _xifexpression = null;
          boolean _isEmpty = dataModel.getComplexTypes().isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _xifexpression = CollectionLiterals.<IntermediateDataModel>newArrayList(dataModel);
          } else {
            _xifexpression = CollectionLiterals.<EObject>emptyList();
          }
          _switchResult = _xifexpression;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }

  /**
   * Get the complex type definition level of a data model. This is the level in the data model,
   * at which complex types may be defined (cf. the COMPLEX_TYPE_DEFINITION_KIND enumeration).
   */
  private static Util.COMPLEX_TYPE_DEFINITION_KIND complexTypeDefinitionKind(final IntermediateDataModel dataModel) {
    Util.COMPLEX_TYPE_DEFINITION_KIND _xifexpression = null;
    boolean _isEmpty = dataModel.getVersions().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Util.COMPLEX_TYPE_DEFINITION_KIND _xifexpression_1 = null;
      boolean _isEmpty_1 = dataModel.getContexts().isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = Util.COMPLEX_TYPE_DEFINITION_KIND.VERSION;
      } else {
        _xifexpression_1 = Util.COMPLEX_TYPE_DEFINITION_KIND.VERSION_CONTEXT;
      }
      _xifexpression = _xifexpression_1;
    } else {
      Util.COMPLEX_TYPE_DEFINITION_KIND _xifexpression_2 = null;
      boolean _isEmpty_2 = dataModel.getContexts().isEmpty();
      boolean _not_1 = (!_isEmpty_2);
      if (_not_1) {
        _xifexpression_2 = Util.COMPLEX_TYPE_DEFINITION_KIND.CONTEXT;
      } else {
        _xifexpression_2 = Util.COMPLEX_TYPE_DEFINITION_KIND.TOP_LEVEL;
      }
      _xifexpression = _xifexpression_2;
    }
    return _xifexpression;
  }

  /**
   * Get all complex types defined in a data model
   */
  public static List<IntermediateComplexType> getComplexTypes(final IntermediateDataModel dataModel) {
    List<IntermediateComplexType> _switchResult = null;
    Util.COMPLEX_TYPE_DEFINITION_KIND _complexTypeDefinitionKind = Util.complexTypeDefinitionKind(dataModel);
    if (_complexTypeDefinitionKind != null) {
      switch (_complexTypeDefinitionKind) {
        case VERSION:
          final Function1<IntermediateVersion, EList<IntermediateComplexType>> _function = (IntermediateVersion it) -> {
            return it.getComplexTypes();
          };
          _switchResult = IterableExtensions.<IntermediateComplexType>toList(Iterables.<IntermediateComplexType>concat(ListExtensions.<IntermediateVersion, EList<IntermediateComplexType>>map(dataModel.getVersions(), _function)));
          break;
        case VERSION_CONTEXT:
          final Function1<IntermediateVersion, EList<IntermediateContext>> _function_1 = (IntermediateVersion it) -> {
            return it.getContexts();
          };
          final Function1<IntermediateContext, EList<IntermediateComplexType>> _function_2 = (IntermediateContext it) -> {
            return it.getComplexTypes();
          };
          _switchResult = IterableExtensions.<IntermediateComplexType>toList(Iterables.<IntermediateComplexType>concat(IterableExtensions.<IntermediateContext, EList<IntermediateComplexType>>map(Iterables.<IntermediateContext>concat(ListExtensions.<IntermediateVersion, EList<IntermediateContext>>map(dataModel.getVersions(), _function_1)), _function_2)));
          break;
        case CONTEXT:
          final Function1<IntermediateContext, EList<IntermediateComplexType>> _function_3 = (IntermediateContext it) -> {
            return it.getComplexTypes();
          };
          _switchResult = IterableExtensions.<IntermediateComplexType>toList(Iterables.<IntermediateComplexType>concat(ListExtensions.<IntermediateContext, EList<IntermediateComplexType>>map(dataModel.getContexts(), _function_3)));
          break;
        case TOP_LEVEL:
          _switchResult = dataModel.getComplexTypes();
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
}

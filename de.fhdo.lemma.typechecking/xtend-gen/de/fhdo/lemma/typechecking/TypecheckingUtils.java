package de.fhdo.lemma.typechecking;

import de.fhdo.lemma.data.ComplexType;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.Type;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologySpecificCollectionType;
import de.fhdo.lemma.technology.TechnologySpecificDataStructure;
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * This class defines _static_ utility methods to be used across DSLs' implementations for generic
 * type and typechecking tasks.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TypecheckingUtils {
  /**
   * Get fully qualified name of a type
   */
  public static String getTypeName(final Type type) {
    return TypecheckingUtils.getTypeName(type, false);
  }
  
  /**
   * Get name of a type, possibly without qualifying parts
   */
  public static String getTypeName(final Type type, final boolean withoutQualifyingParts) {
    final List<String> nameParts = TypecheckingUtils.getTypeNameParts(type, withoutQualifyingParts);
    if ((nameParts == null)) {
      return null;
    }
    return QualifiedName.create(nameParts).toString();
  }
  
  /**
   * Get full qualifying name parts of a type
   */
  public static List<String> getTypeNameParts(final Type type, final boolean withoutQualifyingParts) {
    if ((type == null)) {
      return null;
    }
    List<String> _switchResult = null;
    boolean _matched = false;
    if (type instanceof TechnologySpecificPrimitiveType) {
      _matched=true;
      _switchResult = ((TechnologySpecificPrimitiveType)type).getQualifiedNameParts();
    }
    if (!_matched) {
      if (type instanceof PrimitiveType) {
        _matched=true;
        String _typeName = ((PrimitiveType)type).getTypeName();
        _switchResult = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_typeName));
      }
    }
    if (!_matched) {
      if (type instanceof ComplexType) {
        _matched=true;
        _switchResult = ((ComplexType)type).getQualifiedNameParts();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    final List<String> nameParts = _switchResult;
    if ((nameParts == null)) {
      return null;
    }
    if (withoutQualifyingParts) {
      final ArrayList<String> namePartsWithoutQualifyingParts = CollectionLiterals.<String>newArrayList(IterableExtensions.<String>last(nameParts));
      return namePartsWithoutQualifyingParts;
    } else {
      return nameParts;
    }
  }
  
  /**
   * Determine if a type is technology-specific
   */
  public static boolean isTechnologySpecific(final Type type) {
    if ((type == null)) {
      return false;
    }
    return (((type instanceof TechnologySpecificPrimitiveType) || 
      (type instanceof TechnologySpecificDataStructure)) || 
      (type instanceof TechnologySpecificCollectionType));
  }
  
  /**
   * Get technology of technology-specific type
   */
  public static Technology getTechnology(final Type type) {
    Technology _xblockexpression = null;
    {
      if (((type == null) || (!TypecheckingUtils.isTechnologySpecific(type)))) {
        return null;
      }
      Technology _switchResult = null;
      boolean _matched = false;
      if (type instanceof TechnologySpecificPrimitiveType) {
        _matched=true;
        _switchResult = ((TechnologySpecificPrimitiveType)type).getTechnology();
      }
      if (!_matched) {
        if (type instanceof TechnologySpecificDataStructure) {
          _matched=true;
          _switchResult = ((TechnologySpecificDataStructure)type).getTechnology();
        }
      }
      if (!_matched) {
        if (type instanceof TechnologySpecificCollectionType) {
          _matched=true;
          _switchResult = ((TechnologySpecificCollectionType)type).getTechnology();
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  /**
   * Find default technology-specific primitive type for builtin primitive type
   */
  public static TechnologySpecificPrimitiveType findDefaultTechnologySpecificPrimitiveType(final Technology technology, final PrimitiveType primitiveType) {
    if (((technology == null) || (primitiveType == null))) {
      return null;
    }
    final Function1<TechnologySpecificPrimitiveType, Boolean> _function = (TechnologySpecificPrimitiveType it) -> {
      return Boolean.valueOf((it.isDefault() && IterableExtensions.<PrimitiveType>exists(it.getBasicBuiltinPrimitiveTypes(), ((Function1<PrimitiveType, Boolean>) (PrimitiveType it_1) -> {
        String _typeName = it_1.getTypeName();
        String _typeName_1 = primitiveType.getTypeName();
        return Boolean.valueOf((_typeName == _typeName_1));
      }))));
    };
    return IterableExtensions.<TechnologySpecificPrimitiveType>findFirst(technology.getPrimitiveTypes(), _function);
  }
}

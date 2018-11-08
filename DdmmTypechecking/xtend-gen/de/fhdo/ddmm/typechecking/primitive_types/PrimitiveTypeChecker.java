package de.fhdo.ddmm.typechecking.primitive_types;

import de.fhdo.ddmm.data.PrimitiveType;
import de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType;
import de.fhdo.ddmm.typechecking.TypeCheckerI;
import de.fhdo.ddmm.typechecking.TypecheckingUtils;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Simple TypeChecker implementation for PrimitiveTypes and TechnologySpecificPrimitiveTypes that
 * builds upon the metamodel's PrimitiveType compatibility check.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class PrimitiveTypeChecker implements TypeCheckerI<PrimitiveType> {
  /**
   * Compare two built-in or technology-specific primitive types. Note that mixing PrimitiveType
   * and TechnologySpecificPrimitiveType instances is possible.
   */
  @Override
  public boolean compatible(final PrimitiveType basicType, final PrimitiveType typeToCheck) {
    return this.checkCompatibility(basicType, typeToCheck);
  }
  
  /**
   * Dispatcher method to check compatibility of two PrimitiveType instances
   */
  private boolean _checkCompatibility(final PrimitiveType basicType, final PrimitiveType typeToCheck) {
    return basicType.isCompatibleWith(typeToCheck);
  }
  
  /**
   * Dispatcher method to check if PrimitiveType instance is compatible with
   * TechnologySpecificPrimitiveType instance
   */
  private boolean _checkCompatibility(final TechnologySpecificPrimitiveType basicType, final PrimitiveType typeToCheck) {
    final Function1<PrimitiveType, Boolean> _function = (PrimitiveType it) -> {
      return Boolean.valueOf(it.isCompatibleWith(typeToCheck));
    };
    return IterableExtensions.<PrimitiveType>exists(basicType.getBasicBuiltinPrimitiveTypes(), _function);
  }
  
  /**
   * Dispatcher method to check if TechnologySpecificPrimitiveType instance is compatible with
   * PrimitiveType instance
   */
  private boolean _checkCompatibility(final PrimitiveType basicType, final TechnologySpecificPrimitiveType typeToCheck) {
    final Function1<PrimitiveType, Boolean> _function = (PrimitiveType it) -> {
      return Boolean.valueOf(basicType.isCompatibleWith(it));
    };
    return IterableExtensions.<PrimitiveType>exists(typeToCheck.getBasicBuiltinPrimitiveTypes(), _function);
  }
  
  /**
   * Dispatcher method to check compatibility of two TechnologySpecificPrimitiveType instances
   */
  private boolean _checkCompatibility(final TechnologySpecificPrimitiveType basicType, final TechnologySpecificPrimitiveType typeToCheck) {
    final Function1<PrimitiveType, Boolean> _function = (PrimitiveType basic) -> {
      final Function1<PrimitiveType, Boolean> _function_1 = (PrimitiveType toCheck) -> {
        return Boolean.valueOf(basic.isCompatibleWith(toCheck));
      };
      return Boolean.valueOf(IterableExtensions.<PrimitiveType>exists(typeToCheck.getBasicBuiltinPrimitiveTypes(), _function_1));
    };
    return IterableExtensions.<PrimitiveType>exists(basicType.getBasicBuiltinPrimitiveTypes(), _function);
  }
  
  /**
   * Get name of primitive or technology-specific primitive type
   */
  @Override
  public String typeName(final PrimitiveType type) {
    return TypecheckingUtils.getTypeName(type);
  }
  
  private boolean checkCompatibility(final PrimitiveType basicType, final PrimitiveType typeToCheck) {
    if (basicType instanceof TechnologySpecificPrimitiveType
         && typeToCheck instanceof TechnologySpecificPrimitiveType) {
      return _checkCompatibility((TechnologySpecificPrimitiveType)basicType, (TechnologySpecificPrimitiveType)typeToCheck);
    } else if (basicType instanceof TechnologySpecificPrimitiveType
         && typeToCheck != null) {
      return _checkCompatibility((TechnologySpecificPrimitiveType)basicType, typeToCheck);
    } else if (basicType != null
         && typeToCheck instanceof TechnologySpecificPrimitiveType) {
      return _checkCompatibility(basicType, (TechnologySpecificPrimitiveType)typeToCheck);
    } else if (basicType != null
         && typeToCheck != null) {
      return _checkCompatibility(basicType, typeToCheck);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(basicType, typeToCheck).toString());
    }
  }
}

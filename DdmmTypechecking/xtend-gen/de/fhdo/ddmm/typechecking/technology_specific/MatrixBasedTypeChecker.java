package de.fhdo.ddmm.typechecking.technology_specific;

import com.google.common.base.Objects;
import de.fhdo.ddmm.data.Type;
import de.fhdo.ddmm.technology.CompatibilityDirection;
import de.fhdo.ddmm.technology.CompatibilityMatrixEntry;
import de.fhdo.ddmm.technology.PossiblyImportedTechnologySpecificType;
import de.fhdo.ddmm.technology.Technology;
import de.fhdo.ddmm.typechecking.TypeCheckerI;
import de.fhdo.ddmm.typechecking.TypecheckingUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Type checker for technology-specific types, whose compatibility might be defined in a
 * compatibility matrix.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class MatrixBasedTypeChecker implements TypeCheckerI<Type> {
  /**
   * Compare two technology-specific types on the basis of the compatibility matrix of their
   * parent technology model. If no compatibility matrix is defined, the method will return false.
   */
  @Override
  public boolean compatible(final Type basicType, final Type typeToCheck) {
    if (((!TypecheckingUtils.isTechnologySpecific(basicType)) && 
      (!TypecheckingUtils.isTechnologySpecific(typeToCheck)))) {
      return false;
    }
    final Technology basicModel = EcoreUtil2.<Technology>getContainerOfType(basicType, Technology.class);
    final EList<CompatibilityMatrixEntry> compatibilityEntries = basicModel.getCompatibilityEntries();
    boolean _isEmpty = compatibilityEntries.isEmpty();
    if (_isEmpty) {
      return false;
    }
    final Technology toCheckModel = EcoreUtil2.<Technology>getContainerOfType(typeToCheck, Technology.class);
    final Function1<CompatibilityMatrixEntry, Boolean> _function = (CompatibilityMatrixEntry entry) -> {
      final Function1<PossiblyImportedTechnologySpecificType, Boolean> _function_1 = (PossiblyImportedTechnologySpecificType compatibleType) -> {
        return Boolean.valueOf(this.compatibleEntry(basicType, basicModel, typeToCheck, toCheckModel, 
          entry.getMappingType().getType(), compatibleType.getType(), entry.getDirection()));
      };
      return Boolean.valueOf(IterableExtensions.<PossiblyImportedTechnologySpecificType>exists(entry.getCompatibleTypes(), _function_1));
    };
    return IterableExtensions.<CompatibilityMatrixEntry>exists(compatibilityEntries, _function);
  }
  
  /**
   * Check if an entry in a compatibility matrix describes the compatibility between the given
   * basic type and the type to check
   */
  private boolean compatibleEntry(final Type basicType, final Technology basicModel, final Type typeToCheck, final Technology toCheckModel, final Type mappingType, final Type compatibleType, final CompatibilityDirection direction) {
    final String basicName = QualifiedName.create(basicModel.getName(), this.typeName(basicType)).toString();
    final String toCheckName = QualifiedName.create(toCheckModel.getName(), this.typeName(typeToCheck)).toString();
    final Technology mappingModel = EcoreUtil2.<Technology>getContainerOfType(mappingType, Technology.class);
    final String mappingName = QualifiedName.create(mappingModel.getName(), this.typeName(mappingType)).toString();
    final Technology compatibleModel = EcoreUtil2.<Technology>getContainerOfType(compatibleType, Technology.class);
    final String compatibleName = QualifiedName.create(compatibleModel.getName(), this.typeName(compatibleType)).toString();
    if ((direction == CompatibilityDirection.MAPPING_TO_COMPATIBLE_TYPES)) {
      return (Objects.equal(toCheckName, mappingName) && Objects.equal(basicName, compatibleName));
    } else {
      if ((direction == CompatibilityDirection.COMPATIBLE_TYPES_TO_MAPPING)) {
        return (Objects.equal(toCheckName, compatibleName) && Objects.equal(basicName, mappingName));
      } else {
        if ((direction == CompatibilityDirection.BIDIRECTIONAL)) {
          return ((Objects.equal(toCheckName, mappingName) && Objects.equal(basicName, compatibleName)) || 
            (Objects.equal(toCheckName, compatibleName) && Objects.equal(basicName, mappingName)));
        }
      }
    }
    return false;
  }
  
  /**
   * Get type name
   */
  @Override
  public String typeName(final Type type) {
    return TypecheckingUtils.getTypeName(type);
  }
}

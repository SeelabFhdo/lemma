package de.fhdo.ddmm.typechecking;

import de.fhdo.ddmm.data.Type;

/**
 * Interface for type checkers of a certain Type
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public interface TypeCheckerI<T extends Type> {
  public abstract boolean compatible(final T basicType, final T typeToCheck);
  
  public abstract String typeName(final T type);
}

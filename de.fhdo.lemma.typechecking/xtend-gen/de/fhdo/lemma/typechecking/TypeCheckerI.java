package de.fhdo.lemma.typechecking;

import de.fhdo.lemma.data.Type;

/**
 * Interface for type checkers of a certain Type
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public interface TypeCheckerI<T extends Type> {
  boolean compatible(final T basicType, final T typeToCheck);

  String typeName(final T type);
}

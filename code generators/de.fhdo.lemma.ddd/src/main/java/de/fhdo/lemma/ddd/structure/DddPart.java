package de.fhdo.lemma.ddd.structure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for Parts according to Domain-driven Design (cf.
 * https://domainlanguage.com/ddd/reference).
 *
 * @author Florian Rademacher (florian.rademacher@fh-dortmund.de)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DddPart {
}

package de.fhdo.lemma.ddd.behavior;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for Validators according to Domain-driven Design (cf.
 * https://domainlanguage.com/ddd/reference).
 *
 * @author Florian Rademacher (florian.rademacher@fh-dortmund.de)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DddValidator {
}

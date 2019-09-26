package de.fhdo.lemma.msa.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for identifying microservices generated with LEMMA.
 *
 * @author Florian Rademacher (florian.rademacher@fh-dortmund.de)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LemmaMicroservice {
    LemmaMicroserviceType type();
}

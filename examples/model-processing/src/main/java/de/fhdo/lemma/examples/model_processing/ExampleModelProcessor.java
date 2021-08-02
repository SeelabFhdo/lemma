package de.fhdo.lemma.examples.model_processing;

import de.fhdo.lemma.model_processing.AbstractModelProcessor;

/**
 * Entrypoint for the example LEMMA model processor. LEMMA's model processing framework requires such entrypoints to
 * constitute Java classes that extend {@link de.fhdo.lemma.model_processing.AbstractModelProcessor}.
 */
public class ExampleModelProcessor extends AbstractModelProcessor {
    /**
     * Program entrypoint
     */
    public static void main(String[] args) {
        // Delegate flow control to LEMMA's model processing framework following the Inversion of Control pattern (see
        // the below constructor)
        new ExampleModelProcessor().run(args);
    }

    /**
     * Constructor
     */
    public ExampleModelProcessor() {
        // LEMMA's model processing framework relies on annotation-driven Inversion of Control. Consequently, a model
        // processor must specify the Java package for the framework to search for implementations of, e.g., model
        // validators or code generation modules.
        super("de.fhdo.lemma.examples.model_processing");
    }
}
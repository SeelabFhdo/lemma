/*
 * generated by Xtext 2.12.0
 */
package de.fhdo.lemma.technology


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class TechnologyDslStandaloneSetup extends TechnologyDslStandaloneSetupGenerated {

    def static void doSetup() {
        new TechnologyDslStandaloneSetup().createInjectorAndDoEMFRegistration()
    }
}

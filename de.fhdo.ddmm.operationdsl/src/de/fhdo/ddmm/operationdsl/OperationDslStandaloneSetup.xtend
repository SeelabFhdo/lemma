/*
 * generated by Xtext 2.12.0
 */
package de.fhdo.ddmm.operationdsl


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class OperationDslStandaloneSetup extends OperationDslStandaloneSetupGenerated {

	def static void doSetup() {
		new OperationDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
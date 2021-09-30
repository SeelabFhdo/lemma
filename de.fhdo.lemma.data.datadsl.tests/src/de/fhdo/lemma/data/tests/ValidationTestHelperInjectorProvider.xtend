package de.fhdo.lemma.data.tests

import de.fhdo.lemma.data.DataDslRuntimeModule
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import de.fhdo.lemma.xtext.test.utils.ExtendedValidationTestHelper

/**
 * This class extends the DataDslInjectorProvider class to bind injectable
 * ExtendedValidationTestHelper instances to the ValidationTestHelper type.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ValidationTestHelperInjectorProvider extends DataDslInjectorProvider {
    override DataDslRuntimeModule createRuntimeModule() {
        val runtimeModule = super.createRuntimeModule()
        return new DataDslRuntimeModule() {
            /**
             * Bind ExtendedValidationTestHelper
             */
            def Class<? extends ValidationTestHelper> bindValidationTestHelper() {
                ExtendedValidationTestHelper
            }

            // Analogous to super class
            override bindClassLoaderToInstance() {
                return runtimeModule.bindClassLoaderToInstance()
            }
        }
    }
}
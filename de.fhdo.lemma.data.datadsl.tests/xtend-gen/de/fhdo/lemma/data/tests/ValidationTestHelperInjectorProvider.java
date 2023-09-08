package de.fhdo.lemma.data.tests;

import de.fhdo.lemma.data.DataDslRuntimeModule;
import de.fhdo.lemma.xtext.test.utils.ExtendedValidationTestHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;

/**
 * This class extends the DataDslInjectorProvider class to bind injectable
 * ExtendedValidationTestHelper instances to the ValidationTestHelper type.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ValidationTestHelperInjectorProvider extends DataDslInjectorProvider {
  @Override
  public DataDslRuntimeModule createRuntimeModule() {
    abstract class __ValidationTestHelperInjectorProvider_1 extends DataDslRuntimeModule {
      /**
       * Bind ExtendedValidationTestHelper
       */
      public abstract Class<? extends ValidationTestHelper> bindValidationTestHelper();
    }

    final DataDslRuntimeModule runtimeModule = super.createRuntimeModule();
    return new __ValidationTestHelperInjectorProvider_1() {
      /**
       * Bind ExtendedValidationTestHelper
       */
      public Class<? extends ValidationTestHelper> bindValidationTestHelper() {
        return ExtendedValidationTestHelper.class;
      }

      @Override
      public ClassLoader bindClassLoaderToInstance() {
        return runtimeModule.bindClassLoaderToInstance();
      }
    };
  }
}

/*
 * generated by Xtext 2.26.0
 */
package de.fhdo.lemma.operationdsl.ui.tests;

import com.google.inject.Injector;
import de.fhdo.lemma.operationdsl.ui.internal.OperationdslActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class OperationDslUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return OperationdslActivator.getInstance().getInjector("de.fhdo.lemma.operationdsl.OperationDsl");
	}

}

/*
 * generated by Xtext 2.26.0
 */
package de.fhdo.lemma.technology.mappingdsl.ui;

import com.google.inject.Injector;
import de.fhdo.lemma.technology.mappingdsl.ui.internal.MappingdslActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MappingDslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(MappingdslActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		MappingdslActivator activator = MappingdslActivator.getInstance();
		return activator != null ? activator.getInjector(MappingdslActivator.DE_FHDO_LEMMA_TECHNOLOGY_MAPPINGDSL_MAPPINGDSL) : null;
	}

}

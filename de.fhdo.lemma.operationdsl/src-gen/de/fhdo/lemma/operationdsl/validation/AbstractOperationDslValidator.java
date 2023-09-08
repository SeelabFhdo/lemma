/*
 * generated by Xtext 2.32.0
 */
package de.fhdo.lemma.operationdsl.validation;

import de.fhdo.lemma.validation.ServiceDslValidator;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public abstract class AbstractOperationDslValidator extends ServiceDslValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>(super.getEPackages());
		result.add(EPackage.Registry.INSTANCE.getEPackage("de.fhdo.lemma.operation"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("de.fhdo.lemma.technology"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("de.fhdo.lemma.service"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("de.fhdo.lemma.data"));
		return result;
	}
}

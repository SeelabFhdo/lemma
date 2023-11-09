/*
 * generated by Xtext 2.32.0
 */
package de.fhdo.lemma.technology.validation;

import de.fhdo.lemma.data.validation.DataDslValidator;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

@ComposedChecks(validators = {NamesAreUniqueValidator.class})
public abstract class AbstractTechnologyDslValidator extends DataDslValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>(super.getEPackages());
		result.add(EPackage.Registry.INSTANCE.getEPackage("de.fhdo.lemma.technology"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("de.fhdo.lemma.data"));
		return result;
	}
}

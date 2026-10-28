package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Abstract class for architecture information gathering.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
abstract class AbstractReconstructionElement {
	@Accessors
	String name
	@Accessors
	String qualifiedContextName

	new() {

	}

	new(String name, String qualifiedContextName) {
		this.name = name
		this.qualifiedContextName = qualifiedContextName
	}
}
package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors

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
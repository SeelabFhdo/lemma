package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors

class PrimitiveType {
	@Accessors
	String name
	
	new () {
		
	}
	
	new (String name) {
		this.name = name
	}
}
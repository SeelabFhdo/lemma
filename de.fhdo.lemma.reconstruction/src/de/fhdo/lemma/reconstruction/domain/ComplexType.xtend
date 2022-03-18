package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors

class ComplexType {
	@Accessors
	String name
	@Accessors
	String qualifiedName
	@Accessors
	ClassType classType
	
	new() {
		
	}
	
	new (String name, String qualifedName, ClassType classType) {
		this.name = name
		this.qualifiedName = qualifedName
		this.classType = classType
	}
}
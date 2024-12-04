package de.fhdo.lemma.reconstruction.domain

import com.fasterxml.jackson.annotation.JsonProperty
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Data structure class for reconstructing complex types.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ComplexType {
	@Accessors
	String name
	@Accessors
	String qualifiedName
	@Accessors
	@JsonProperty("class_type")
	ClassType classType
	
	new() {
		
	}
	
	new (String name, String qualifedName, ClassType classType) {
		this.name = name
		this.qualifiedName = qualifedName
		this.classType = classType
	}
}
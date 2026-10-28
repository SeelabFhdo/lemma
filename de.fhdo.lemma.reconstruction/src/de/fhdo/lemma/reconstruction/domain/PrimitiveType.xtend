package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Class for reconstructed primitive types.   
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
 class PrimitiveType {
	@Accessors
	String name
	
	new () {
		
	}
	
	new (String name) {
		this.name = name
	}
}
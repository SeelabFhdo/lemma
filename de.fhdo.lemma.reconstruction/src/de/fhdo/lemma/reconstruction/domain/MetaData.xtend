package de.fhdo.lemma.reconstruction.domain

import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Class collection meta data information from reconstructed elements  
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MetaData {
	@Accessors
	String name
	@Accessors
	Map<String, String> values = newHashMap

	new () {

	}

	new (String name) {
		this.name = name
	}
}
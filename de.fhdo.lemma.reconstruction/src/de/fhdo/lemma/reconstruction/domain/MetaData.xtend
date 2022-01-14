package de.fhdo.lemma.reconstruction.domain

import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

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
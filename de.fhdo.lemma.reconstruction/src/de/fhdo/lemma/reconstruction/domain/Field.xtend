package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import com.fasterxml.jackson.annotation.JsonProperty

class Field {
	@Accessors
	String name
	@Accessors
	PrimitiveType primitiveType
	@Accessors
	ComplexType complexType
	@Accessors
	@JsonProperty("metaData")
	List<MetaData> metaData = newLinkedList
	
	new() {
		
	}
	
	new(String name, String visibility) {
		this.name = name
	}
}
package de.fhdo.lemma.reconstruction.domain

import com.fasterxml.jackson.annotation.JsonProperty
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

class Collection {
	@Accessors
	String name
	@Accessors
	String qualified_name
	@Accessors
	@JsonProperty("complex_field_type")
	ComplexType complexType
	@Accessors
	@JsonProperty("primitive_field_type")
	PrimitiveType primitiveType
	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList
	
	new () {
		
	}
	
	new (String name, String qualified_name) {
		this.name = name
		this.qualified_name = qualified_name
	}
	
	new (String name, String qualified_name, PrimitiveType primitiveType, ComplexType complexType) {
		this.name = name
		this.qualified_name = qualified_name
		this.complexType = complexType
		this. primitiveType = primitiveType
	}
	
	
}
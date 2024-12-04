package de.fhdo.lemma.reconstruction.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Data structure for capturing information about fields of data types. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Field {
	@Accessors
	String name
	@Accessors
	@JsonProperty("primitive_field_type")
	PrimitiveType primitiveType
	@Accessors
	@JsonProperty("complex_field_type")
	ComplexType complexType
	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList
	
	new() {
		
	}
	
	new(String name, String visibility) {
		this.name = name
	}
}
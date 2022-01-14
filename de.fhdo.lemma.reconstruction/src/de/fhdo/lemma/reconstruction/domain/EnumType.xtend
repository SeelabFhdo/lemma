package de.fhdo.lemma.reconstruction.domain

import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List

class EnumType extends AbstractReconstructionElement {
	@Accessors
	@JsonProperty("values")
	List<String> values = newLinkedList
	@Accessors
	@JsonProperty("MetaData")
	List<MetaData> MetaData = newLinkedList
	
	new () {

	}
	
	new (String name, String qualifiedContextName) {
		super(name, qualifiedContextName)
	}


}
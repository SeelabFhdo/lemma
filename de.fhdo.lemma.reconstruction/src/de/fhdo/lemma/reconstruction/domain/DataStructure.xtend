package de.fhdo.lemma.reconstruction.domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty

class DataStructure extends AbstractReconstructionElement {
	@Accessors
	@JsonProperty("fields")
	List<Field> fields = newLinkedList
	@Accessors
	@JsonProperty("metaData")
	List<MetaData> metaData = newLinkedList

	new() {

	}

	new(String name, String qualifiedContextName) {
		super(name, qualifiedContextName)
	}
}
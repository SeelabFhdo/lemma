package de.fhdo.lemma.reconstruction.domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty

class Context {
	@Accessors
	String qualifiedName
	@Accessors
	String name
	@Accessors
	String version
	@Accessors
	@JsonProperty("dataStructures")
	List<DataStructure> dataStructures = newLinkedList
	@Accessors
	@JsonProperty("enums")
	List<EnumType> enums= newLinkedList
	
	new () {

	}

	new (String qalifiedName, String name, String version) {
		this.qualifiedName = qalifiedName
		this.name = name
		this.version = version
	}
}
package de.fhdo.lemma.reconstruction.service

import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import de.fhdo.lemma.reconstruction.domain.MetaData

class Operation {
	@Accessors
	String name
	@Accessors
	@JsonProperty("parameters")
	List<Parameter> parameters = newLinkedList
	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList	
}
package de.fhdo.lemma.reconstruction.service

import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import de.fhdo.lemma.reconstruction.domain.MetaData

class Microservice {
	@Accessors
	String name
	@Accessors
	@JsonProperty("qualified_name")
	String qualifedName
	@Accessors
	String version
	@Accessors
	String type
	@Accessors
	String visibility
	@Accessors
	@JsonProperty("interfaces")
	List<Interface> interfaces = newLinkedList
	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList
}
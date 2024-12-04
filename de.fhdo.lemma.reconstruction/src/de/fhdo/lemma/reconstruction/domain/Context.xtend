package de.fhdo.lemma.reconstruction.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Class for capturing information about a context. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class Context {
	@Accessors
	@JsonProperty("qualified_name")
	String qualifiedName
	@Accessors
	String name
	@Accessors
	String version
	@Accessors
	@JsonProperty("data_structures")
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
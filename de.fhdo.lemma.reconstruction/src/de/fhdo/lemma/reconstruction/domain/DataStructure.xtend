package de.fhdo.lemma.reconstruction.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Class for capturing information about a data structure. 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */

class DataStructure extends AbstractReconstructionElement {
	@Accessors
	@JsonProperty("fields")
	List<Field> fields = newLinkedList
	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList

	new() {

	}

	new(String name, String qualifiedContextName) {
		super(name, qualifiedContextName)
	}
}
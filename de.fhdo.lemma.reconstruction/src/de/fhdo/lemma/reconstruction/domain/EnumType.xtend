package de.fhdo.lemma.reconstruction.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Class for capturing information about enumerations.  
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
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
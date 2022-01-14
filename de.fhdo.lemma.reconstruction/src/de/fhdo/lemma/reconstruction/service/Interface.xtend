package de.fhdo.lemma.reconstruction.service
	
import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import de.fhdo.lemma.reconstruction.domain.MetaData

class Interface {
	@Accessors
	String name
	@Accessors
	String version
	@Accessors
	String visibility
	@Accessors
	@JsonProperty("metaData")
	List<MetaData> metaData = newLinkedList
	@Accessors
	@JsonProperty("operations")
	List<Operation> operations = newLinkedList
}
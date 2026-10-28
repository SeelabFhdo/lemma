package de.fhdo.lemma.reconstruction.service

import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.reconstruction.domain.ComplexType
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import de.fhdo.lemma.reconstruction.domain.MetaData
import de.fhdo.lemma.reconstruction.domain.PrimitiveType

class Parameter {
	@Accessors
	String name
	@Accessors
	@JsonProperty("primitive_parameter_type")
	PrimitiveType primitiveType
	@Accessors
	@JsonProperty("complex_parameter_type")
	ComplexType complexType
	@Accessors
	@JsonProperty("communication_type")
	CommunicationType communicationType
	@Accessors
	@JsonProperty("exchange_pattern")
	ExchangePattern exchangePattern
	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList
}
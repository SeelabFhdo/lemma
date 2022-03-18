package de.fhdo.lemma.reconstruction.service

import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import de.fhdo.lemma.reconstruction.domain.MetaData
import de.fhdo.lemma.reconstruction.domain.PrimitiveType
import de.fhdo.lemma.reconstruction.domain.ComplexType

class Parameter {
	@Accessors
	String name
	@Accessors
	PrimitiveType primitiveType
	@Accessors
	ComplexType complexType
	@Accessors
	CommunicationType communicationType
	@Accessors
	ExchangePattern exchangePattern
	@Accessors
	@JsonProperty("metaData")
	List<MetaData> metaData = newLinkedList
}
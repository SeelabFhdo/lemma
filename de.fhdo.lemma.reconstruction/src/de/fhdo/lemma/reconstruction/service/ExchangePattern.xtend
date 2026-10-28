package de.fhdo.lemma.reconstruction.service

import com.fasterxml.jackson.annotation.JsonProperty

enum ExchangePattern {
	@JsonProperty("In")
	IN,
	@JsonProperty("Out")
	OUT,
	@JsonProperty("Inout")
	INOUT
}
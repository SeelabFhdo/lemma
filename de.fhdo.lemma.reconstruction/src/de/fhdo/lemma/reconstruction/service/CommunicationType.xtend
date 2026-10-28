package de.fhdo.lemma.reconstruction.service

import com.fasterxml.jackson.annotation.JsonProperty

enum CommunicationType {
	@JsonProperty("Synchronous")
	SYNCHRONOUS,
	@JsonProperty("Asynchronous")
	ASYNCHRONOUS
}
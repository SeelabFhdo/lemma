package de.fhdo.lemma.reconstruction.operation

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Kind of a reconstructed operation node.
 *
 * A functional microservice is reconstructed as a container, infrastructure
 * such as a service registry or a gateway as an infrastructure node.
 */
enum NodeType {
	@JsonProperty("CONTAINER")
	CONTAINER,
	@JsonProperty("INFRASTRUCTURE")
	INFRASTRUCTURE
}

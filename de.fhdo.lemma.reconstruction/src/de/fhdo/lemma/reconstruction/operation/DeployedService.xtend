package de.fhdo.lemma.reconstruction.operation

import com.fasterxml.jackson.annotation.JsonProperty
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Reference to a microservice an operation node deploys.
 */
class DeployedService {
	@Accessors
	String name

	@Accessors
	@JsonProperty("qualified_name")
	String qualifiedName

	new () {
	}
}

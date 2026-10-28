package de.fhdo.lemma.reconstruction.operation

import com.fasterxml.jackson.annotation.JsonProperty
import de.fhdo.lemma.reconstruction.domain.MetaData
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Node of the reconstructed operation of a software system, read from the
 * "operation" collection.
 *
 * The deployment technology a node uses is deliberately absent: it is a
 * reference into a technology model and is chosen here rather than
 * reconstructed, see ADR-0008 of the reconstruction framework.
 */
class OperationNode {
	@Accessors
	String name

	@Accessors
	@JsonProperty("qualified_name")
	String qualifiedName

	@Accessors
	@JsonProperty("node_type")
	NodeType nodeType

	@Accessors
	@JsonProperty("operation_environment")
	String operationEnvironment

	@Accessors
	@JsonProperty("deployed_services")
	List<DeployedService> deployedServices = newLinkedList

	@Accessors
	@JsonProperty("depends_on")
	List<String> dependsOn = newLinkedList

	@Accessors
	@JsonProperty("data")
	List<MetaData> metaData = newLinkedList

	new () {
	}
}

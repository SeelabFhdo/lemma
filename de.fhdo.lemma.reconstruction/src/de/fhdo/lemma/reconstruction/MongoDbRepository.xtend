package de.fhdo.lemma.reconstruction

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.ConnectionString
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.operation.OperationNode
import java.util.List
import de.fhdo.lemma.reconstruction.service.Microservice

/**
 * Class for restoring reconstructed architecture information from a database.
 * 
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class MongoDbRepository {
	MongoClient mongoClient

	/**
	 * Std. constructor for creating an instance of the MongoDbRepository based on a hostname
	 * and port.
	 */
	new (String mongoDbHostname, int mongoDbPort) {
		val connectionString = new ConnectionString('''mongodb://«mongoDbHostname»:«mongoDbPort»''')
		mongoClient = MongoClients.create(connectionString)
	}

	/**
	 * Read reconstructed context information from the database 
	 */
	def List<Context> getReconstructedContexts() {
		val contextDatabase = mongoClient.getDatabase("mrf")
		val domainCollection = contextDatabase.getCollection("context")
		val List<Context> contexts = newLinkedList

		domainCollection.find().forEach[
			val mapper = new ObjectMapper()
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        	val context = mapper.readValue(it.toJson(), Context)
        	contexts.add(context)
		]
		contexts
	}
	
	/**
	 * Read reconstructed operation information from the database
	 */
	def List<OperationNode> getReconstructedOperationNodes() {
		val operationDatabase = mongoClient.getDatabase("mrf")
		val operationCollection = operationDatabase.getCollection("operation")
		val List<OperationNode> nodes = newLinkedList

		operationCollection.find().forEach[
			val mapper = new ObjectMapper()
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			val node = mapper.readValue(it.toJson(), OperationNode)
			nodes.add(node)
		]
		nodes
	}

	/**
	 * Read reconstructed microservice information from the database
	 */
	def List<Microservice> getReconstructedMicroservices() {
		val microserviceDatabase = mongoClient.getDatabase("mrf")
		val microserviceCollection = microserviceDatabase.getCollection("microservice")
		val List<Microservice> microservices = newLinkedList
		
		microserviceCollection.find().forEach[
			val mapper = new ObjectMapper()
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			val microservice = mapper.readValue(it.toJson(), Microservice)
			microservices.add(microservice)
		]
		microservices
	}
}
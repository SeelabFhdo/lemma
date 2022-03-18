package de.fhdo.lemma.reconstruction

import de.fhdo.lemma.reconstruction.domain.Context
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.ConnectionString
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.DeserializationFeature
import java.util.List
import de.fhdo.lemma.reconstruction.service.Microservice
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator

class MongoDbRepository {
	MongoClient mongoClient
	
	new (String mongoDbHostname, int mongoDbPort) {
		val connectionString = new ConnectionString('''mongodb://«mongoDbHostname»:«mongoDbPort»''')
		mongoClient = MongoClients.create(connectionString)
	}
	
	def List<Context> getReconstructedContexts() {
		val contextDatabase = mongoClient.getDatabase("context")
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
	
	def List<Microservice> getReconstructedMicroservices() {
		val microserviceDatabase = mongoClient.getDatabase("microservice")
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
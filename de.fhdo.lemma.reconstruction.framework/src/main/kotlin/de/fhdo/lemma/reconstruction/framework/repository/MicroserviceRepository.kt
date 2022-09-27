package de.fhdo.lemma.reconstruction.framework.repository

import de.fhdo.lemma.reconstruction.framework.modules.service.microservice.Microservice
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.litote.kmongo.save

object MicroserviceRepository {
    private val mongoClient = KMongo.createClient()
    private val dataBase = mongoClient.getDatabase("microservice")
    private val collection = dataBase.getCollection<Microservice>()

    internal fun saveMicroservice(microservice: Microservice) {
        collection.save(microservice)
    }
}


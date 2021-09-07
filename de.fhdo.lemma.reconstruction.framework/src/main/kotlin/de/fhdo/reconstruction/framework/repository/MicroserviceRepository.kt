package de.fhdo.reconstruction.framework.repository

import de.fhdo.reconstruction.framework.modules.service.microservice.ReconstructedMicroservice
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.litote.kmongo.save

object MicroserviceRepository {
    private val mongoClient = KMongo.createClient()
    private val dataBase = mongoClient.getDatabase("microservice")
    private val collection = dataBase.getCollection<ReconstructedMicroservice>()

    internal fun saveMicroservice(microservice: ReconstructedMicroservice) {
        collection.save(microservice)
    }
}


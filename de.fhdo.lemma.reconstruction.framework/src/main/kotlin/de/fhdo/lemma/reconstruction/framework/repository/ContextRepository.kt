package de.fhdo.lemma.reconstruction.framework.repository

import de.fhdo.lemma.reconstruction.framework.modules.domain.context.Context
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.litote.kmongo.save

object ContextRepository {
    private val mongoClient = KMongo.createClient()
    private val dataBase = mongoClient.getDatabase("context")
    private val collection = dataBase.getCollection<Context>()

    internal fun saveContext(context: Context) {
        collection.save(context)
    }
}




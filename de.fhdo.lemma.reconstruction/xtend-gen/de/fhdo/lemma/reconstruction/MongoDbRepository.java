package de.fhdo.lemma.reconstruction;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.service.Microservice;
import java.util.List;
import java.util.function.Consumer;
import org.bson.Document;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class MongoDbRepository {
  private MongoClient mongoClient;
  
  public MongoDbRepository(final String mongoDbHostname, final int mongoDbPort) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mongodb://");
    _builder.append(mongoDbHostname);
    _builder.append(":");
    _builder.append(mongoDbPort);
    final ConnectionString connectionString = new ConnectionString(_builder.toString());
    this.mongoClient = MongoClients.create(connectionString);
  }
  
  public List<Context> getReconstructedContexts() {
    List<Context> _xblockexpression = null;
    {
      final MongoDatabase contextDatabase = this.mongoClient.getDatabase("context");
      final MongoCollection<Document> domainCollection = contextDatabase.getCollection("context");
      final List<Context> contexts = CollectionLiterals.<Context>newLinkedList();
      final Consumer<Document> _function = (Document it) -> {
        try {
          final ObjectMapper mapper = new ObjectMapper();
          mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          final Context context = mapper.<Context>readValue(it.toJson(), Context.class);
          contexts.add(context);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      domainCollection.find().forEach(_function);
      _xblockexpression = contexts;
    }
    return _xblockexpression;
  }
  
  public List<Microservice> getReconstructedMicroservices() {
    List<Microservice> _xblockexpression = null;
    {
      final MongoDatabase microserviceDatabase = this.mongoClient.getDatabase("microservice");
      final MongoCollection<Document> microserviceCollection = microserviceDatabase.getCollection("microservice");
      final List<Microservice> microservices = CollectionLiterals.<Microservice>newLinkedList();
      final Consumer<Document> _function = (Document it) -> {
        try {
          final ObjectMapper mapper = new ObjectMapper();
          mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          final Microservice microservice = mapper.<Microservice>readValue(it.toJson(), Microservice.class);
          microservices.add(microservice);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      microserviceCollection.find().forEach(_function);
      _xblockexpression = microservices;
    }
    return _xblockexpression;
  }
}

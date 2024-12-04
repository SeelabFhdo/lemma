package de.fhdo.lemma.reconstruction;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.fhdo.lemma.reconstruction.domain.Context;
import java.util.List;
import java.util.function.Consumer;
import org.bson.Document;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Class for restoring reconstructed architecture information from a database.
 * 
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class MongoDbRepository {
  private MongoClient mongoClient;

  /**
   * Std. constructor for creating an instance of the MongoDbRepository based on a hostname
   * and port.
   */
  public MongoDbRepository(final String mongoDbHostname, final int mongoDbPort) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mongodb://");
    _builder.append(mongoDbHostname);
    _builder.append(":");
    _builder.append(mongoDbPort);
    final ConnectionString connectionString = new ConnectionString(_builder.toString());
    this.mongoClient = MongoClients.create(connectionString);
  }

  /**
   * Read reconstructed context information from the database
   */
  public List<Context> getReconstructedContexts() {
    List<Context> _xblockexpression = null;
    {
      final MongoDatabase contextDatabase = this.mongoClient.getDatabase("mrf");
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
}

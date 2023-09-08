package de.fhdo.lemma.data.avro;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.apache.avro.Schema;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Helper factory to create Avro schemas of different types and from LEMMA-specific information.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class AvroSchemaFactory {
  /**
   * Create Avro Array
   */
  public static Schema createArray(final String lemmaQualifiedName, final Schema elementType) {
    final Schema schema = Schema.createArray(elementType);
    Shared.setLemmaName(schema, lemmaQualifiedName);
    return schema;
  }

  /**
   * Split a LEMMA qualified name into the qualifying and the name part. Additionally, the
   * qualifying part is converted to an Avro-compatible namespace.
   */
  private static Pair<String, String> nameParts(final String lemmaQualifiedName) {
    final Pair<String, String> parts = Util.splitNameParts(lemmaQualifiedName);
    final String avroNamespace = Shared.toAvroNamespace(parts.getKey());
    String _value = parts.getValue();
    return Pair.<String, String>of(avroNamespace, _value);
  }

  /**
   * Create Avro Enum
   */
  public static Schema createEnum(final String lemmaQualifiedName, final String doc, final List<String> values) {
    final Pair<String, String> nameParts = AvroSchemaFactory.nameParts(lemmaQualifiedName);
    final Schema schema = Schema.createEnum(nameParts.getValue(), doc, nameParts.getKey(), values);
    Shared.setLemmaName(schema, lemmaQualifiedName);
    return schema;
  }

  /**
   * Create Avro Fixed
   */
  public static Schema createFixed(final String lemmaQualifiedName, final String doc, final int size) {
    final Pair<String, String> nameParts = AvroSchemaFactory.nameParts(lemmaQualifiedName);
    final Schema schema = Schema.createFixed(nameParts.getValue(), doc, nameParts.getKey(), size);
    Shared.setLemmaName(schema, lemmaQualifiedName);
    return schema;
  }

  /**
   * Create Avro Map
   */
  public static Schema createMap(final String lemmaQualifiedName, final Schema valueType) {
    final Schema schema = Schema.createMap(valueType);
    Shared.setLemmaName(schema, lemmaQualifiedName);
    return schema;
  }

  /**
   * Create Avro Record
   */
  public static Schema createRecord(final String lemmaQualifiedName, final String doc, final boolean isError) {
    final Pair<String, String> nameParts = AvroSchemaFactory.nameParts(lemmaQualifiedName);
    final Schema schema = Schema.createRecord(nameParts.getValue(), doc, nameParts.getKey(), isError);
    Shared.setLemmaName(schema, lemmaQualifiedName);
    return schema;
  }

  /**
   * Create Avro Union. Setting includeNullSchema to true, results in adding Avro's NULL schema
   * type to the union.
   */
  public static Schema createUnion(final String lemmaQualifiedName, final List<Schema> types, final boolean includeNullSchema) {
    Schema _xifexpression = null;
    if ((includeNullSchema && (!IterableExtensions.<Schema>exists(types, ((Function1<Schema, Boolean>) (Schema it) -> {
      Schema.Type _type = it.getType();
      return Boolean.valueOf(Objects.equal(_type, Schema.Type.NULL));
    }))))) {
      _xifexpression = Schema.createUnion(types);
    } else {
      Schema _xblockexpression = null;
      {
        final ArrayList<Schema> typesWithNull = CollectionLiterals.<Schema>newArrayList();
        typesWithNull.add(Schema.create(Schema.Type.NULL));
        typesWithNull.addAll(types);
        _xblockexpression = Schema.createUnion(typesWithNull);
      }
      _xifexpression = _xblockexpression;
    }
    final Schema schema = _xifexpression;
    Shared.setLemmaName(schema, lemmaQualifiedName);
    return schema;
  }
}

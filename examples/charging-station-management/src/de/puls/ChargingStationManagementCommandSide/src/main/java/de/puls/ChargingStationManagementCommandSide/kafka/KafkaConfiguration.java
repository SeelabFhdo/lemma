package de.puls.ChargingStationManagementCommandSide.kafka;

import de.puls.ChargingStationManagementCommandSide.kafka.gen.KafkaConfigurationGen;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration()
public class KafkaConfiguration implements KafkaConfigurationGen {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean()
    @Override
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Value(value = "${kafka.avro.schemaRegistryAddress}")
    private String avroSchemaRegistryAddress;

    @Override
    public ProducerFactory<String, GenericRecord> avroProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, avroSchemaRegistryAddress);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean()
    @Override
    public KafkaTemplate<String, GenericRecord> avroProducer() {
        return new KafkaTemplate<>(avroProducerFactory());
    }
}

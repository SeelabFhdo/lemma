package de.puls.ChargingStationManagementQuerySide.kafka;

import de.puls.ChargingStationManagementQuerySide.kafka.gen.KafkaConfigurationGen;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

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

    @Value(value = "${kafka.group.parkingAreaCreatedEvents}")
    private String avroParkingAreaCreatedEventsConsumerGroupId;

    @Override
    public ConsumerFactory<String, Object> avroParkingAreaCreatedEventsConsumerFactory() {
        KafkaAvroDeserializer deserializer = new KafkaAvroDeserializer();
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, avroParkingAreaCreatedEventsConsumerGroupId);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, avroSchemaRegistryAddress);
        deserializer.configure(configProps, false);
        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), deserializer);
    }

    @Bean()
    @Override
    public ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaCreatedEventsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(avroParkingAreaCreatedEventsConsumerFactory());
        factory.setErrorHandler(new SeekToCurrentErrorHandler());
        return factory;
    }

    @Value(value = "${kafka.group.parkingAreaUpdatedEvents}")
    private String avroParkingAreaUpdatedEventsConsumerGroupId;

    @Override
    public ConsumerFactory<String, Object> avroParkingAreaUpdatedEventsConsumerFactory() {
        KafkaAvroDeserializer deserializer = new KafkaAvroDeserializer();
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, avroParkingAreaUpdatedEventsConsumerGroupId);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, avroSchemaRegistryAddress);
        deserializer.configure(configProps, false);
        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), deserializer);
    }

    @Bean()
    @Override
    public ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaUpdatedEventsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(avroParkingAreaUpdatedEventsConsumerFactory());
        factory.setErrorHandler(new SeekToCurrentErrorHandler());
        return factory;
    }

    @Value(value = "${kafka.group.parkingAreaDeletedEvents}")
    private String avroParkingAreaDeletedEventsConsumerGroupId;

    @Override
    public ConsumerFactory<String, Object> avroParkingAreaDeletedEventsConsumerFactory() {
        KafkaAvroDeserializer deserializer = new KafkaAvroDeserializer();
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, avroParkingAreaDeletedEventsConsumerGroupId);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, avroSchemaRegistryAddress);
        deserializer.configure(configProps, false);
        return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), deserializer);
    }

    @Bean()
    @Override
    public ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaDeletedEventsKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(avroParkingAreaDeletedEventsConsumerFactory());
        factory.setErrorHandler(new SeekToCurrentErrorHandler());
        return factory;
    }
}

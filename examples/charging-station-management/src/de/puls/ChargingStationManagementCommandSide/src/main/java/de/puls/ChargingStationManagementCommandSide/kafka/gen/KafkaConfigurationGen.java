package de.puls.ChargingStationManagementCommandSide.kafka.gen;

import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

public interface KafkaConfigurationGen {

    KafkaAdmin kafkaAdmin();

    ProducerFactory<String, GenericRecord> avroProducerFactory();

    KafkaTemplate<String, GenericRecord> avroProducer();
}

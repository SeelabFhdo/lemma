package de.puls.ChargingStationManagementQuerySide.kafka.gen;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;

public interface KafkaConfigurationGen {

    KafkaAdmin kafkaAdmin();

    ConsumerFactory<String, Object> avroParkingAreaCreatedEventsConsumerFactory();

    ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaCreatedEventsKafkaListenerContainerFactory();

    ConsumerFactory<String, Object> avroParkingAreaUpdatedEventsConsumerFactory();

    ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaUpdatedEventsKafkaListenerContainerFactory();

    ConsumerFactory<String, Object> avroParkingAreaDeletedEventsConsumerFactory();

    ConcurrentKafkaListenerContainerFactory<String, Object> avroParkingAreaDeletedEventsKafkaListenerContainerFactory();
}

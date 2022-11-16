package de.puls.ChargingStationManagementQuerySide.kafka;

import de.puls.ChargingStationManagementQuerySide.domain.ParkingAreaConsumerService;
import de.puls.ChargingStationManagementQuerySide.kafka.gen.ListenersGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.stereotype.Component;

@Component()
public class Listeners implements ListenersGen {

    private ParkingAreaConsumerService parkingAreaConsumerService;

    @Autowired()
    @Override
    public void setParkingAreaConsumerService(ParkingAreaConsumerService parkingAreaConsumerService) {
        this.parkingAreaConsumerService = parkingAreaConsumerService;
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaCreatedEvents}", groupId = "${kafka.group.parkingAreaCreatedEvents}", containerFactory = "avroParkingAreaCreatedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaCreatedEventErrorHandler")
    @Override
    public void avroReceiveParkingAreaCreatedEventListener(Object object) {
        parkingAreaConsumerService.avroReceiveParkingAreaCreatedEvent(object);
    }

    @Bean()
    @Override
    public ConsumerAwareListenerErrorHandler receiveParkingAreaCreatedEventErrorHandler() {
        return (message, exception, consumer) -> parkingAreaConsumerService.receiveParkingAreaCreatedEventErrorHandler(message, exception, consumer);
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaUpdatedEvents}", groupId = "${kafka.group.parkingAreaUpdatedEvents}", containerFactory = "avroParkingAreaUpdatedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaUpdatedEventErrorHandler")
    @Override
    public void avroReceiveParkingAreaUpdatedEventListener(Object object) {
        parkingAreaConsumerService.avroReceiveParkingAreaUpdatedEvent(object);
    }

    @Bean()
    @Override
    public ConsumerAwareListenerErrorHandler receiveParkingAreaUpdatedEventErrorHandler() {
        return (message, exception, consumer) -> parkingAreaConsumerService.receiveParkingAreaUpdatedEventErrorHandler(message, exception, consumer);
    }

    @KafkaListener(topics = "${kafka.topic.parkingAreaDeletedEvents}", groupId = "${kafka.group.parkingAreaDeletedEvents}", containerFactory = "avroParkingAreaDeletedEventsKafkaListenerContainerFactory", errorHandler = "receiveParkingAreaDeletedEventErrorHandler")
    @Override
    public void avroReceiveParkingAreaDeletedEventListener(Object object) {
        parkingAreaConsumerService.avroReceiveParkingAreaDeletedEvent(object);
    }

    @Bean()
    @Override
    public ConsumerAwareListenerErrorHandler receiveParkingAreaDeletedEventErrorHandler() {
        return (message, exception, consumer) -> parkingAreaConsumerService.receiveParkingAreaDeletedEventErrorHandler(message, exception, consumer);
    }
}

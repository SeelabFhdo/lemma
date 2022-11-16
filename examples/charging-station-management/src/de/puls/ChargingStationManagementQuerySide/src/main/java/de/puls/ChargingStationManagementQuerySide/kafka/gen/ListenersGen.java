package de.puls.ChargingStationManagementQuerySide.kafka.gen;

import de.puls.ChargingStationManagementQuerySide.domain.ParkingAreaConsumerService;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

public interface ListenersGen {

    void setParkingAreaConsumerService(ParkingAreaConsumerService parkingAreaConsumerService);

    void avroReceiveParkingAreaCreatedEventListener(Object object);

    ConsumerAwareListenerErrorHandler receiveParkingAreaCreatedEventErrorHandler();

    void avroReceiveParkingAreaUpdatedEventListener(Object object);

    ConsumerAwareListenerErrorHandler receiveParkingAreaUpdatedEventErrorHandler();

    void avroReceiveParkingAreaDeletedEventListener(Object object);

    ConsumerAwareListenerErrorHandler receiveParkingAreaDeletedEventErrorHandler();
}

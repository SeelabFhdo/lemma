package de.puls.ChargingStationManagementCommandSide.kafka.gen;

import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

public interface ParkingAreaProducerServiceGen {

    void setAvroProducer(KafkaTemplate<String, GenericRecord> avroProducer);

    ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaCreatedEvent(GenericRecord genericRecord);

    ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaUpdatedEvent(GenericRecord genericRecord);

    ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaDeletedEvent(GenericRecord genericRecord);
}

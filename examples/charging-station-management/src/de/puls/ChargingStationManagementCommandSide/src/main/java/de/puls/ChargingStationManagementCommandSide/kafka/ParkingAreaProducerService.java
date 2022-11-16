package de.puls.ChargingStationManagementCommandSide.kafka;

import de.puls.ChargingStationManagementCommandSide.kafka.gen.ParkingAreaProducerServiceGen;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service()
public class ParkingAreaProducerService implements ParkingAreaProducerServiceGen {

    private KafkaTemplate<String, GenericRecord> avroProducer;

    @Autowired()
    @Override
    public void setAvroProducer(KafkaTemplate<String, GenericRecord> avroProducer) {
        this.avroProducer = avroProducer;
    }

    @Value(value = "${kafka.topic.parkingAreaCreatedEvents}")
    private String parkingAreaCreatedEventsTopic;

    @Override
    public ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaCreatedEvent(GenericRecord genericRecord) {
        return avroProducer.send(new ProducerRecord<>(parkingAreaCreatedEventsTopic, genericRecord));
    }

    @Value(value = "${kafka.topic.parkingAreaUpdatedEvents}")
    private String parkingAreaUpdatedEventsTopic;

    @Override
    public ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaUpdatedEvent(GenericRecord genericRecord) {
        return avroProducer.send(new ProducerRecord<>(parkingAreaUpdatedEventsTopic, genericRecord));
    }

    @Value(value = "${kafka.topic.parkingAreaDeletedEvents}")
    private String parkingAreaDeletedEventsTopic;

    @Override
    public ListenableFuture<SendResult<String, GenericRecord>> sendParkingAreaDeletedEvent(GenericRecord genericRecord) {
        return avroProducer.send(new ProducerRecord<>(parkingAreaDeletedEventsTopic, genericRecord));
    }
}

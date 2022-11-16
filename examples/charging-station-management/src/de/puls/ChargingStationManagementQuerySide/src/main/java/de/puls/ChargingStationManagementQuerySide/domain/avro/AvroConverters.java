package de.puls.ChargingStationManagementQuerySide.domain.avro;

import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingAreaCreatedEvent;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingAreaDeletedEvent;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingAreaUpdatedEvent;
import de.puls.ChargingStationManagementQuerySide.domain.avro.gen.AvroConvertersGen;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecordBuilder;

public class AvroConverters implements AvroConvertersGen {

    public static GenericRecordBuilder getRecordBuilder(ParkingAreaCreatedEvent parkingAreaCreatedEvent) throws IOException {
        InputStream schemaStream = MethodHandles.lookup().lookupClass().getClassLoader().getResourceAsStream("ParkingAreaCreatedEvent.avsc");
        Schema schema = new Schema.Parser().parse(schemaStream);
        GenericRecordBuilder builder = new GenericRecordBuilder(schema);
        builder.set("commonId", parkingAreaCreatedEvent.getCommonId());
        return builder;
    }

    public static ParkingAreaCreatedEvent getParkingAreaCreatedEventObjectFromRecord(GenericData.Record parkingAreaCreatedEventRecord) {
        ParkingAreaCreatedEvent parkingAreaCreatedEvent = new ParkingAreaCreatedEvent();
        return parkingAreaCreatedEvent;
    }

    public static GenericRecordBuilder getRecordBuilder(ParkingAreaUpdatedEvent parkingAreaUpdatedEvent) throws IOException {
        InputStream schemaStream = MethodHandles.lookup().lookupClass().getClassLoader().getResourceAsStream("ParkingAreaUpdatedEvent.avsc");
        Schema schema = new Schema.Parser().parse(schemaStream);
        GenericRecordBuilder builder = new GenericRecordBuilder(schema);
        builder.set("commonId", parkingAreaUpdatedEvent.getCommonId());
        return builder;
    }

    public static ParkingAreaUpdatedEvent getParkingAreaUpdatedEventObjectFromRecord(GenericData.Record parkingAreaUpdatedEventRecord) {
        ParkingAreaUpdatedEvent parkingAreaUpdatedEvent = new ParkingAreaUpdatedEvent();
        return parkingAreaUpdatedEvent;
    }

    public static GenericRecordBuilder getRecordBuilder(ParkingAreaDeletedEvent parkingAreaDeletedEvent) throws IOException {
        InputStream schemaStream = MethodHandles.lookup().lookupClass().getClassLoader().getResourceAsStream("ParkingAreaDeletedEvent.avsc");
        Schema schema = new Schema.Parser().parse(schemaStream);
        GenericRecordBuilder builder = new GenericRecordBuilder(schema);
        builder.set("parkingAreaId", parkingAreaDeletedEvent.getParkingAreaId());
        return builder;
    }

    public static ParkingAreaDeletedEvent getParkingAreaDeletedEventObjectFromRecord(GenericData.Record parkingAreaDeletedEventRecord) {
        ParkingAreaDeletedEvent parkingAreaDeletedEvent = new ParkingAreaDeletedEvent();
        return parkingAreaDeletedEvent;
    }
}

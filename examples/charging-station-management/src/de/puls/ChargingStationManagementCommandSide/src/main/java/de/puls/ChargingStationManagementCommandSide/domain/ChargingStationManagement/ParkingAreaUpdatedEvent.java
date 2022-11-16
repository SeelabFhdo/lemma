package de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddDomainEvent;
import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.gen.ParkingAreaUpdatedEventGen;

public class ParkingAreaUpdatedEvent implements DddDomainEvent, DddValueObject, ParkingAreaUpdatedEventGen {

    public ParkingAreaUpdatedEvent() {
    }

    private long commonId;

    @Override
    public long getCommonId() {
        return commonId;
    }

    private ParkingAreaInformation info;

    @Override
    public ParkingAreaInformation getInfo() {
        return info;
    }

    public ParkingAreaUpdatedEvent(long commonId, ParkingAreaInformation info) {
        this.commonId = commonId;
        this.info = info;
    }
}

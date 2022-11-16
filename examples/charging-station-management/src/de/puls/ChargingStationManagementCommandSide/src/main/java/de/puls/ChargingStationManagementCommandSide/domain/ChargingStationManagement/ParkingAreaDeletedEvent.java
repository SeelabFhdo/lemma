package de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddDomainEvent;
import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.gen.ParkingAreaDeletedEventGen;

public class ParkingAreaDeletedEvent implements DddDomainEvent, DddValueObject, ParkingAreaDeletedEventGen {

    public ParkingAreaDeletedEvent() {
    }

    private long parkingAreaId;

    @Override
    public long getParkingAreaId() {
        return parkingAreaId;
    }

    public ParkingAreaDeletedEvent(long parkingAreaId) {
        this.parkingAreaId = parkingAreaId;
    }
}

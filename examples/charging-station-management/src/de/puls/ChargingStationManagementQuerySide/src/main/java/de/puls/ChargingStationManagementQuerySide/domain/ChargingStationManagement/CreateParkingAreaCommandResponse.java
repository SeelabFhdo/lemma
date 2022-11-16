package de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.gen.CreateParkingAreaCommandResponseGen;

public class CreateParkingAreaCommandResponse implements DddValueObject, CreateParkingAreaCommandResponseGen {

    public CreateParkingAreaCommandResponse() {
    }

    private long id;

    @Override
    public long getId() {
        return id;
    }

    private String errorMessage;

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    public CreateParkingAreaCommandResponse(long id, String errorMessage) {
        this.id = id;
        this.errorMessage = errorMessage;
    }
}

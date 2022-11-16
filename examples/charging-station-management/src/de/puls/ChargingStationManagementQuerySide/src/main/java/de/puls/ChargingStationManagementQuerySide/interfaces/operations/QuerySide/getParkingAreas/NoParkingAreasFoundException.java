package de.puls.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas;

import de.puls.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.gen.NoParkingAreasFoundExceptionGen;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoParkingAreasFoundException extends RuntimeException implements NoParkingAreasFoundExceptionGen {

    protected String noParkingAreasFound;

    protected String errorMessage;

    public NoParkingAreasFoundException(String noParkingAreasFound) {
        super();
        this.noParkingAreasFound = noParkingAreasFound;
    }

    public NoParkingAreasFoundException(String noParkingAreasFound, String errorMessage) {
        super(errorMessage);
        this.noParkingAreasFound = noParkingAreasFound;
        this.errorMessage = errorMessage;
    }
}

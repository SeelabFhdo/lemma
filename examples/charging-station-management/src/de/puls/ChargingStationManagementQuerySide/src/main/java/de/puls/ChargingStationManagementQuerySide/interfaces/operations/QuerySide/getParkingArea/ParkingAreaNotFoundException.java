package de.puls.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea;

import de.puls.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.gen.ParkingAreaNotFoundExceptionGen;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParkingAreaNotFoundException extends RuntimeException implements ParkingAreaNotFoundExceptionGen {

    protected String parkingAreaNotFound;

    protected String errorMessage;

    public ParkingAreaNotFoundException(String parkingAreaNotFound) {
        super();
        this.parkingAreaNotFound = parkingAreaNotFound;
    }

    public ParkingAreaNotFoundException(String parkingAreaNotFound, String errorMessage) {
        super(errorMessage);
        this.parkingAreaNotFound = parkingAreaNotFound;
        this.errorMessage = errorMessage;
    }
}

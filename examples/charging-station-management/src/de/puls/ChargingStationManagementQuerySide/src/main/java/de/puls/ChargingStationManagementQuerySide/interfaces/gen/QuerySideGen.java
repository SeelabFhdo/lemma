package de.puls.ChargingStationManagementQuerySide.interfaces.gen;

import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.Location;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface QuerySideGen {

    ResponseEntity<ParkingAreaInformation> getParkingArea(Long id) throws ParkingAreaNotFoundException;

    ResponseEntity<List<ParkingAreaInformation>> getParkingAreas(Location northEastBound, Location southWestBound) throws NoParkingAreasFoundException;
}

package de.puls.ChargingStationManagementCommandSide.interfaces.gen;

import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.CreateParkingAreaCommandResponse;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.UpdateParkingAreaCommand;
import org.springframework.http.ResponseEntity;

public interface CommandSideGen {

    ResponseEntity<CreateParkingAreaCommandResponse> createParkingArea(CreateParkingAreaCommand command);

    void updateParkingArea(Long id, UpdateParkingAreaCommand command);

    void deleteParkingArea(Long id);
}

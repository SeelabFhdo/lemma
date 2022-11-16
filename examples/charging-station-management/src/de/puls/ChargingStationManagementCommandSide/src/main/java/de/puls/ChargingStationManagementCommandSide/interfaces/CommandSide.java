package de.puls.ChargingStationManagementCommandSide.interfaces;

import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.CreateParkingAreaCommand;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.CreateParkingAreaCommandResponse;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.UpdateParkingAreaCommand;
import de.puls.ChargingStationManagementCommandSide.interfaces.gen.CommandSideGen;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component()
@RestController()
@RequestMapping(value = {"/resources"})
public class CommandSide implements CommandSideGen {

    @ApiOperation(value = "API endpoint for creating a parking area")
    @PostMapping(value = "/parkingarea")
    @Override
    public ResponseEntity<CreateParkingAreaCommandResponse> createParkingArea(@ApiParam(value = "Command object to specify the values of the new parking area", required = true) @RequestBody() @Valid() CreateParkingAreaCommand command) {
        checkRequiredParametersOfCreateParkingArea(command);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void checkRequiredParametersOfCreateParkingArea(CreateParkingAreaCommand command) {
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    @ApiOperation(value = "API endpoint for updating a parking area")
    @PutMapping(value = "/parkingarea/{id}")
    @Override
    public void updateParkingArea(@ApiParam(value = "Identifier of the parking area to be updated", required = true) @PathVariable() Long id, @ApiParam(value = "Command object to specify the values of the updated parking area", required = true) @RequestBody() @Valid() UpdateParkingAreaCommand command) {
        checkRequiredParametersOfUpdateParkingArea(id, command);
    }

    private void checkRequiredParametersOfUpdateParkingArea(Long id, UpdateParkingAreaCommand command) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
        if (command == null)
            throw new IllegalArgumentException("Required parameter \"command\" must not be null");
    }

    @ApiOperation(value = "API endpoint for deleting a parking area")
    @DeleteMapping(value = "/parkingarea/{id}")
    @Override
    public void deleteParkingArea(@ApiParam(value = "Identifier of the parking area to be deleted", required = true) @PathVariable() Long id) {
        checkRequiredParametersOfDeleteParkingArea(id);
    }

    private void checkRequiredParametersOfDeleteParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }
}

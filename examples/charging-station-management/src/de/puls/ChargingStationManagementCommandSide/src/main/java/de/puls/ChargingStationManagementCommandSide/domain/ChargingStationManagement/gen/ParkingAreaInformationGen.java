package de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.gen;

import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.Location;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.TimePeriod;
import java.util.List;

public interface ParkingAreaInformationGen {

    long getOwnerId();

    String getName();

    String getDescription();

    Location getLocation();

    int getParkingSpaceCount();

    List<TimePeriod> getAvailability();

    boolean getActivated();

    boolean getBlocked();

    boolean getOffered();

    ChargerSpeed getChargerSpeed();

    String getPlugType();
}

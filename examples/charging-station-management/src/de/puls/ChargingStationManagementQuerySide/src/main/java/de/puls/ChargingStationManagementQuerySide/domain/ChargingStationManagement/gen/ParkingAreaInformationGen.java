package de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.gen;

import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.Location;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.TimePeriod;
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

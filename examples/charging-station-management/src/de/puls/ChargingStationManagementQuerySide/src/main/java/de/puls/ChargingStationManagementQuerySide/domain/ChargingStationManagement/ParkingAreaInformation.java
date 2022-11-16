package de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.Location;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.TimePeriod;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.gen.ParkingAreaInformationGen;
import java.util.List;

public class ParkingAreaInformation implements DddValueObject, ParkingAreaInformationGen {

    public ParkingAreaInformation() {
    }

    private long ownerId;

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    private Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    private int parkingSpaceCount;

    @Override
    public int getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    private List<TimePeriod> availability;

    @Override
    public List<TimePeriod> getAvailability() {
        return availability;
    }

    private boolean activated;

    @Override
    public boolean getActivated() {
        return activated;
    }

    private boolean blocked;

    @Override
    public boolean getBlocked() {
        return blocked;
    }

    private boolean offered;

    @Override
    public boolean getOffered() {
        return offered;
    }

    private ChargerSpeed chargerSpeed;

    @Override
    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    private String plugType;

    @Override
    public String getPlugType() {
        return plugType;
    }

    public ParkingAreaInformation(long ownerId, String name, String description, Location location, int parkingSpaceCount, List<TimePeriod> availability, boolean activated, boolean blocked, boolean offered, ChargerSpeed chargerSpeed, String plugType) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.parkingSpaceCount = parkingSpaceCount;
        this.availability = availability;
        this.activated = activated;
        this.blocked = blocked;
        this.offered = offered;
        this.chargerSpeed = chargerSpeed;
        this.plugType = plugType;
    }
}

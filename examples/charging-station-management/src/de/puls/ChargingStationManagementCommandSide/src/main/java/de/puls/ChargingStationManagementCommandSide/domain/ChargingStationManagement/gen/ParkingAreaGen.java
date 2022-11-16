package de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.gen;

import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.Location;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.TimePeriod;
import java.util.Date;
import java.util.List;

public interface ParkingAreaGen {

    Long getId();

    void setId(Long id);

    Long getCommonId();

    void setCommonId(Long commonId);

    Long getOwnerId();

    void setOwnerId(Long ownerId);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    Location getLocation();

    void setLocation(Location location);

    Integer getParkingSpaceCount();

    void setParkingSpaceCount(Integer parkingSpaceCount);

    List<TimePeriod> getAvailability();

    void setAvailability(List<TimePeriod> availability);

    ChargerSpeed getChargerSpeed();

    void setChargerSpeed(ChargerSpeed chargerSpeed);

    String getPlugType();

    void setPlugType(String plugType);

    Boolean getActivated();

    void setActivated(Boolean activated);

    Boolean getBlocked();

    void setBlocked(Boolean blocked);

    Boolean getOffered();

    void setOffered(Boolean offered);

    Date getCreatedDate();

    void setCreatedDate(Date createdDate);

    Date getLastModifiedDate();

    void setLastModifiedDate(Date lastModifiedDate);

    ParkingAreaInformation toParkingAreaInformation();
}

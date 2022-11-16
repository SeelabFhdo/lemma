package de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddAggregate;
import de.fhdo.lemma.ddd.structure.DddEntity;
import de.fhdo.lemma.ddd.structure.DddIdentifier;
import de.fhdo.lemma.ddd.structure.DddPart;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.ChargerSpeed;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.Location;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.TimePeriod;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.gen.ParkingAreaGen;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "ParkingArea")
public class ParkingArea implements DddAggregate, DddEntity, ParkingAreaGen {

    public ParkingArea() {
    }

    @DddIdentifier()
    @GeneratedValue()
    @Id()
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)
    private Long commonId;

    @Override
    public Long getCommonId() {
        return commonId;
    }

    @Override
    public void setCommonId(Long commonId) {
        this.commonId = commonId;
    }

    private Long ownerId;

    @Override
    public Long getOwnerId() {
        return ownerId;
    }

    @Override
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @DddPart()
    @Embedded()
    private Location location;

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    private Integer parkingSpaceCount;

    @Override
    public Integer getParkingSpaceCount() {
        return parkingSpaceCount;
    }

    @Override
    public void setParkingSpaceCount(Integer parkingSpaceCount) {
        this.parkingSpaceCount = parkingSpaceCount;
    }

    @DddPart()
    @ElementCollection()
    @CollectionTable()
    private List<TimePeriod> availability;

    @Override
    public List<TimePeriod> getAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(List<TimePeriod> availability) {
        this.availability = availability;
    }

    private ChargerSpeed chargerSpeed;

    @Override
    public ChargerSpeed getChargerSpeed() {
        return chargerSpeed;
    }

    @Override
    public void setChargerSpeed(ChargerSpeed chargerSpeed) {
        this.chargerSpeed = chargerSpeed;
    }

    private String plugType;

    @Override
    public String getPlugType() {
        return plugType;
    }

    @Override
    public void setPlugType(String plugType) {
        this.plugType = plugType;
    }

    private Boolean activated;

    @Override
    public Boolean getActivated() {
        return activated;
    }

    @Override
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    private Boolean blocked;

    @Override
    public Boolean getBlocked() {
        return blocked;
    }

    @Override
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    private Boolean offered;

    @Override
    public Boolean getOffered() {
        return offered;
    }

    @Override
    public void setOffered(Boolean offered) {
        this.offered = offered;
    }

    private Date createdDate;

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private Date lastModifiedDate;

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public ParkingArea(Long id, Long commonId, Long ownerId, String name, String description, Location location, Integer parkingSpaceCount, List<TimePeriod> availability, ChargerSpeed chargerSpeed, String plugType, Boolean activated, Boolean blocked, Boolean offered, Date createdDate, Date lastModifiedDate) {
        this.id = id;
        this.commonId = commonId;
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.parkingSpaceCount = parkingSpaceCount;
        this.availability = availability;
        this.chargerSpeed = chargerSpeed;
        this.plugType = plugType;
        this.activated = activated;
        this.blocked = blocked;
        this.offered = offered;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public ParkingAreaInformation toParkingAreaInformation() {
        /* FIXME If you safely want to implement this method, create an extension interface called 
ParkingAreaExt in the same folder as this class file and run the code 
generator again. Otherwise, this file and all your changes to it will probably get overwritten 
the next time the code generator is executed. */
        throw new UnsupportedOperationException("Not implemented");
    }
}

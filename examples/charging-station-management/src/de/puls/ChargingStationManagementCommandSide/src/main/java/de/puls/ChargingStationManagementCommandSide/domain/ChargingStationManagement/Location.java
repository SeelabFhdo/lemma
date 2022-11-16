package de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.ChargingStationManagementCommandSide.domain.ChargingStationManagement.gen.LocationGen;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Embeddable()
@MappedSuperclass()
public class Location implements DddValueObject, LocationGen {

    public Location() {
    }

    private Double latitude;

    @Override
    public Double getLatitude() {
        return latitude;
    }

    private Double longitude;

    @Override
    public Double getLongitude() {
        return longitude;
    }

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

package de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddRepository;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingArea;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface ParkingAreaRepository extends DddRepository, CrudRepository<ParkingArea, Long> {

    ParkingArea findByCommonId(long commonId);
}

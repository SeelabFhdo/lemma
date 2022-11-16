package de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddValueObject;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.gen.TimePeriodGen;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Embeddable()
@MappedSuperclass()
public class TimePeriod implements DddValueObject, TimePeriodGen {

    public TimePeriod() {
    }

    private Date start;

    @Override
    public Date getStart() {
        return start;
    }

    private Date end;

    @Override
    public Date getEnd() {
        return end;
    }

    public TimePeriod(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
}

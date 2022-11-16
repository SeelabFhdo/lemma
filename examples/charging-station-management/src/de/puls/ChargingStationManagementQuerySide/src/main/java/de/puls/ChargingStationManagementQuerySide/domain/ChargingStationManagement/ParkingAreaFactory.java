package de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement;

import de.fhdo.lemma.ddd.structure.DddFactory;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingArea;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.ChargingStationManagementQuerySide.domain.ChargingStationManagement.gen.ParkingAreaFactoryGen;

public class ParkingAreaFactory implements DddFactory, ParkingAreaFactoryGen {

    public ParkingAreaFactory() {
    }

    static public ParkingArea fromParkingAreaInformation(ParkingAreaInformation info) {
        /* FIXME If you safely want to implement this method, create an extension interface called 
ParkingAreaFactoryExt in the same folder as this class file and run the code 
generator again. Otherwise, this file and all your changes to it will probably get overwritten 
the next time the code generator is executed. */
        throw new UnsupportedOperationException("Not implemented");
    }
}

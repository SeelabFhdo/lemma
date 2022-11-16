package de.puls.ChargingStationManagementCommandSide;

import de.fhdo.lemma.msa.services.LemmaMicroservice;
import de.fhdo.lemma.msa.services.LemmaMicroserviceType;
import de.puls.ChargingStationManagementCommandSide.gen.ChargingStationManagementCommandSideGen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@LemmaMicroservice(type = LemmaMicroserviceType.FUNCTIONAL)
@SpringBootApplication(scanBasePackages = "de.puls.ChargingStationManagementCommandSide")
@EnableSwagger2()
public class ChargingStationManagementCommandSide implements ChargingStationManagementCommandSideGen {

    public static void main(String[] args) {
        SpringApplication.run(ChargingStationManagementCommandSide.class, args);
    }
}

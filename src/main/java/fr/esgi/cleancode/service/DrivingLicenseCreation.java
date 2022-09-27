package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenseCreation {
    private final DrivingLicensedSocialSecurityNumber socialSecurityNumber;
    private final InMemoryDatabase database;


    public DrivingLicence createDrivingLicense(UUID drivingLicenceId, String securitySocialNumber) throws Exception {
        if(socialSecurityNumber.isSocialSecurityNumberValid(securitySocialNumber) == true){
            DrivingLicence drivingLicenceToSave = DrivingLicence.builder().driverSocialSecurityNumber(securitySocialNumber).build();
            return database.save(drivingLicenceId,drivingLicenceToSave);
        }
        Exception InvalidDriverSocialSecurityNumberException = new Exception();
        throw InvalidDriverSocialSecurityNumberException;
    }
}

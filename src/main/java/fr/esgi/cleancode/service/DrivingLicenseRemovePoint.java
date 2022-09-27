package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenseRemovePoint {

    private final InMemoryDatabase database;

    public DrivingLicence removePoint(UUID drivingLicenseId, int pointToRemove) throws Exception {
        DrivingLicence driverLicense = DrivingLicence.builder().id(drivingLicenseId).build();
        if(database.findById(drivingLicenseId) == null){
            Exception InvalidDriverSocialSecurityNumberException = new Exception();
            throw InvalidDriverSocialSecurityNumberException;
        }
        if(driverLicense.getAvailablePoints() > 0 && pointToRemove > driverLicense.getAvailablePoints()){
            driverLicense.withAvailablePoints(driverLicense.getAvailablePoints() - pointToRemove);
            database.save(drivingLicenseId, driverLicense);
        }
        else if(driverLicense.getAvailablePoints() > 0 && pointToRemove < driverLicense.getAvailablePoints()){
            driverLicense.withAvailablePoints(driverLicense.getAvailablePoints() - driverLicense.getAvailablePoints());
            database.save(drivingLicenseId, driverLicense);
        }
        return driverLicense;
    }
}

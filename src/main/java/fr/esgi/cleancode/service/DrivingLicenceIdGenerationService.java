package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
public class DrivingLicenceIdGenerationService {

    //private final InMemoryDatabase database;

    public UUID generateNewDrivingLicenceId() {
        return UUID.randomUUID();
    }
    public boolean isSocialSecurityNumberValid(String drivingLicence) {
        return false;
    }

    public DrivingLicence createDrivingLicenseId(UUID drivingLicenceId, DrivingLicence drivingLicenceToSave) {
        //return database.save(drivingLicenceId,drivingLicenceToSave);
        return drivingLicenceToSave;
    }

}

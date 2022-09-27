package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

public class DrivingLicenseRemovePoint {
    private final DrivingLicenceFinderService drivingLicenceFinderService;

    private final InMemoryDatabase database;

    public DrivingLicence removePoint(DrivingLicence driverLicense, int pointToRemove){
    return  DrivingLicence.builder().build();
    }
}

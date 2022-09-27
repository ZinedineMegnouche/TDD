package fr.esgi.cleancode.service;

import fr.esgi.cleancode.model.DrivingLicence;

import java.util.UUID;

public class DrivingLicenseCreation {
    public DrivingLicence createDrivingLicense(UUID id,String socialSecurityNumber){
        return  DrivingLicence.builder().build();
    }
}

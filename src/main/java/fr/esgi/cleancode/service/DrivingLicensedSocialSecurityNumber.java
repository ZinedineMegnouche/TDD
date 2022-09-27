package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicensedSocialSecurityNumber {

    public boolean isSocialSecurityNumberValid(String socialSecurityNumber) {
        if(socialSecurityNumber == null  || socialSecurityNumber.contains("[a-zA-Z]+") || socialSecurityNumber.length() != 15){
            return false;
        }
        return true;
    }
}

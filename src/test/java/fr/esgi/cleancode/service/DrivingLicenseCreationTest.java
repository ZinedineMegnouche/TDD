package fr.esgi.cleancode.service;
import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenseCreationTest {

    @InjectMocks
    private DrivingLicenceIdGenerationService idGenerationService;
    private DrivingLicensedSocialSecurityNumber socialSecurityNumberService;
    private DrivingLicenseCreation creationService;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_create_License(){
        final var id = UUID.randomUUID();
        final var socialSecurityNumber = socialSecurityNumberService.isSocialSecurityNumberValid("");
        final  var drivingLicense = creationService.createDrivingLicense(id,"");

        when(socialSecurityNumberService.isSocialSecurityNumberValid("123456789098765")).thenReturn(true);
        when(database.save(id,drivingLicense)).thenReturn(drivingLicense);

        var actual = database.save(id,drivingLicense);

        assertThat(actual).isEqualTo(drivingLicense);


    }

    @Test
    void should_not_create_licence(){

    }

}

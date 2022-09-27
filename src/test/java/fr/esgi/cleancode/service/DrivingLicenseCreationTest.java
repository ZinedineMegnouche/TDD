package fr.esgi.cleancode.service;
import fr.esgi.cleancode.database.InMemoryDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenseCreationTest {

    @InjectMocks
    private DrivingLicenceIdGenerationService idGenerationService;


    @Mock
    private DrivingLicensedSocialSecurityNumber socialSecurityNumberService;
    @Mock
    private DrivingLicenseCreation creationService;
    @Mock
    private InMemoryDatabase database;

    @Test
    void should_create_License() throws Exception {
        final var id = idGenerationService.generateNewDrivingLicenceId();
        var isSocialSecurityNumberOK = socialSecurityNumberService.isSocialSecurityNumberValid("123456789098765");
        if(isSocialSecurityNumberOK) {
            final var drivingLicense = creationService.createDrivingLicense(id, "123456789098765");
            when(socialSecurityNumberService.isSocialSecurityNumberValid("123456789098765")).thenReturn(true);
            when(database.save(id,drivingLicense)).thenReturn(drivingLicense);

            var actual = database.save(id,drivingLicense);
            assertThat(actual).isEqualTo(drivingLicense);
        }

    }

    @Test
    void should_not_create_licence() throws Exception {
        final var id = idGenerationService.generateNewDrivingLicenceId();
        var isSocialSecurityNumberOK = socialSecurityNumberService.isSocialSecurityNumberValid("");
        if(isSocialSecurityNumberOK) {
            var drivingLicense = creationService.createDrivingLicense(id,"");

            when(socialSecurityNumberService.isSocialSecurityNumberValid("")).thenReturn(false);
            when(database.save(id,drivingLicense)).thenReturn(drivingLicense);

            var actual = database.save(id,drivingLicense);
            assertThat(actual).isEqualTo(drivingLicense);
        }
    }

}

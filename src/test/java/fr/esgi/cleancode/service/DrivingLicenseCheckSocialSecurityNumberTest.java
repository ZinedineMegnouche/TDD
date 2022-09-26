
package fr.esgi.cleancode.service;
import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenseCheckSocialSecurityNumberTest {
    @InjectMocks
    private DrivingLicenceIdGenerationService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_validate(){
        final UUID drivingLicenceId = UUID.randomUUID();
        final DrivingLicence drivingLicence = DrivingLicence.builder().id(drivingLicenceId).build();

        final String socialSecurityNumber = drivingLicence.getDriverSocialSecurityNumber();

        assertThat(service.isSocialSecurityNumberValid(socialSecurityNumber))
                .isEqualTo(false);
    }

   /* @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"test","123456789098765","123","12S"})
    void should_not_validate(String invalidSSNumber){
      //  var actual = validateMockitoUsage(DrivingLicence.builder().driverSocialSecurityNumber(invalidSSNumber).build());
        var actual = validate(DrivingLicence.builder().driverSocialSecurityNumber(invalidSSNumber).build());
        assertThat(actual).contain
    }*/

    @Test
    void should_create_drivingLicense(){
        final UUID drivingLicenceId = service.generateNewDrivingLicenceId();
        final DrivingLicence drivingLicence = DrivingLicence.builder().id(drivingLicenceId).driverSocialSecurityNumber("123456789098765").build();

        when(database.save(drivingLicenceId,drivingLicence)).thenReturn(drivingLicence);

        final DrivingLicence DL = service.createDrivingLicenseId(drivingLicenceId,drivingLicence);
        assertThat(DL).isEqualTo(drivingLicence);
    }
}

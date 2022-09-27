
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
public class DrivingLicenseRemovePointTest {


    @Mock
    private InMemoryDatabase database;
    @Mock
    private DrivingLicenseRemovePoint service;

    @Test
    void should_remove_point() throws Exception {
        final var id = UUID.randomUUID();
        database.findById(id);
        int pointRemove = 5;
        DrivingLicence drivingLicence = DrivingLicence.builder().id(id).build();
        when(service.removePoint(id,pointRemove)).thenReturn(drivingLicence);

        verify(database).findById(id);
    }

    @Test
    void should_not_remove_point(){

    }
}

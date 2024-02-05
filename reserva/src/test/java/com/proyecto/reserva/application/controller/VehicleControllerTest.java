package com.proyecto.reserva.application.controller;


import com.proyecto.reserva.application.lasting.ERole;
import com.proyecto.reserva.application.service.VehicleService;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.dto.VehicleDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

@WithMockUser
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleController vehicleController;

    @Test
    void newVehicle_shouldCallVehicleServiceAndReturnCreatedStatus() {
        // Preparación del mock
        UserDto userDto = UserDto.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@example.com")
                .role(ERole.USER)
                .enable(true)
                .build();
        VehicleDto vehicleDto = VehicleDto.builder()
                .id(1)
                .plate("ABC123")
                .model("Toyota")
                .userDto(userDto)
                .build();
        doNothing().when(vehicleService).newVehicle(vehicleDto);

        // Ejecución del método a probar
        ResponseEntity<?> response = vehicleController.newVehicle(vehicleDto);

        // Verificaciones
        verify(vehicleService).newVehicle(vehicleDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    void findAllVehicle_shouldCallVehicleServiceAndReturnFoundStatus() throws Exception {
        // Preparación del mock
        UserDto userDto = UserDto.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@example.com")
                .role(ERole.USER)
                .enable(true)
                .build();
        VehicleDto vehicle2 = VehicleDto.builder()
                .id(1)
                .plate("XYZ789")
                .model("Honda")
                // ... (agregar campos de UserDto si es necesario)
                .build();
        List<VehicleDto> expectedVehicles = List.of(vehicle2);
        when(vehicleService.findAllVehicle()).thenReturn(expectedVehicles);

        // Ejecución del método a probar
        ResponseEntity<?> response = vehicleController.findAllVehicle();

        // Verificaciones
        verify(vehicleService).findAllVehicle();
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(expectedVehicles, response.getBody());
    }
    @Test
    void editVehicle_shouldCallVehicleServiceAndReturnOkStatus() throws Exception {
        // Preparación del mock
        Integer id = 1;
        UserDto userDto = UserDto.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@example.com")
                .role(ERole.USER)
                .enable(true)
                .build();
        VehicleDto vehicleDto = VehicleDto.builder()
                .id(1)
                .plate("ABC123")
                .model("Toyota")
                .userDto(userDto)
                .build();
        doNothing().when(vehicleService).editVehicle(id, vehicleDto);

        // Ejecución del método a probar
        ResponseEntity<?> response = vehicleController.editUser(id, vehicleDto);

        // Verificaciones
        verify(vehicleService).editVehicle(id, vehicleDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}

package com.proyecto.reserva.application.controller;

import com.proyecto.reserva.application.lasting.ERole;
import com.proyecto.reserva.application.service.UserService;
import com.proyecto.reserva.domain.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WithMockUser
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Test
    public void testNewUser() throws Exception {
        UserDto userDto = UserDto.builder()  //
                .name("John Doe")
                .email("johndoe@example.com")
                .password("password123")
                .role(ERole.USER)  //
                .enable(true)
                .build();

        UserService userService = Mockito.mock(UserService.class);
        Mockito.doNothing().when(userService).newUser(userDto);

        UserController controller = new UserController(userService);

        ResponseEntity<?> response = controller.newUser(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Mockito.verify(userService).newUser(userDto);
    }
    @Test
    public void testGetUser() throws Exception {
        UserDto user1 = UserDto.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@example.com")
                .password("password123")
                .role(ERole.USER)
                .enable(true)
                .build();


        List<UserDto> users = Arrays.asList(user1); //

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.findAllUser()).thenReturn(users);

        UserController controller = new UserController(userService);

        ResponseEntity<?> response = controller.getUser(); // No se necesita el ID para este método

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(users, response.getBody());
        Mockito.verify(userService).findAllUser();
    }

    @Test
    public void testEditUser() throws Exception {
        UserDto userDto = UserDto.builder()
                .id(1)
                .name("John Doe")
                .email("johndoe@example.com")
                .password("password123")
                .role(ERole.USER)
                .enable(true)
                .build();

        UserService userService = Mockito.mock(UserService.class);
        Mockito.doNothing().when(userService).editUser(1, userDto);

        UserController controller = new UserController(userService);

        ResponseEntity<?> response = controller.editUser(1, userDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(userService).editUser(1, userDto);
    }

    @Test
    public void testRemoveUser() throws Exception {
        UserService userService = Mockito.mock(UserService.class);
        Mockito.doNothing().when(userService).removeUser(1);

        UserController controller = new UserController(userService);

        ResponseEntity<?> response = controller.removeUser(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(userService).removeUser(1);
    }

}

package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.lasting.ERole;
import com.proyecto.reserva.application.mapper.UserMapper;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.entity.User;
import com.proyecto.reserva.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper mapper;
    @InjectMocks
    private UserService userService;


    @Test
    public void testNewUser() throws Exception {
        // Given
        UserDto userDto = UserDto.builder()
                .name("John Doe")
                .email("johndoe@example.com")
                .password("password")
                .role(ERole.USER)
                .enable(true)
                .build();
        User user = new User();  // Crea un objeto User con los datos esperados

        // Cuando se llame a userMapper.toEntity(userDto), se debe devolver el objeto user
        when(mapper.toEntity(userDto)).thenReturn(user);

        // Cuando se llame a userRepository.save(user), no es necesario hacer nada
        // ya que solo estamos probando la interacción con el mock

        // When
        userService.newUser(userDto);

        // Then
        verify(mapper).toEntity(userDto);
        verify(userRepository).save(user);
    }
    @Test
    public void testFindAllUser() throws Exception {
        // Crea usuarios con datos concretos para la prueba
        List<User> users = Arrays.asList(
                User.builder().id(1).name("John Doe").email("johndoe@example.com").build(),
                User.builder().id(2).name("Jane Doe").email("janedoe@example.com").build()
        );

        // Construye los UserDto correspondientes
        List<UserDto> userDtos = Arrays.asList(
                UserDto.builder().id(1).name("John Doe").email("johndoe@example.com").build(),
                UserDto.builder().id(2).name("Jane Doe").email("janedoe@example.com").build()
        );

        // Configuración de los mocks
        when(userRepository.findAll()).thenReturn(users);
        when(mapper.toDtoList(users)).thenReturn(userDtos);

        // Ejecución del método a probar
        List<UserDto> result = userService.findAllUser();

        // Verificación de resultados
        assertEquals(userDtos, result);  // Compara la lista de DTOs esperados con los obtenidos
        verify(userRepository).findAll();
        verify(mapper).toDtoList(users);
    }

    @Test
    public void testFindUserById() throws Exception {

        Integer userId = 1;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        UserDto expectedUserDto = UserDto.builder()
                .id(userId)
                .name("John Doe")
                .email("johndoe@example.com")
                .role(ERole.USER)
                .enable(true)
                .build();
        when(mapper.toDto(user)).thenReturn(expectedUserDto);


        UserDto foundUserDto = userService.findUserById(userId);


        assertEquals(expectedUserDto, foundUserDto);
        verify(userRepository).findById(userId);
        verify(mapper).toDto(user);
    }


    @Test
    void testEditUser() throws Exception {
        // Arrange
        Integer userId = 1;
        UserDto userDto = new UserDto(1, "John Doe", "john.doe@example.com", "password123", ERole.USER, true);

        // Mock behavior
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User(/* existing user data */)));
        when(mapper.toEntity(userDto)).thenReturn(new User(/* mapped user data */));

        // Act
        userService.editUser(userId, userDto);

        // Assert
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));
        verify(mapper, times(1)).toEntity(userDto);
    }
    @Test
    public void testRemoveUser() throws Exception {
        // Datos del usuario a eliminar
        Integer userId = 1;
        User user = new User();  // Simula el usuario encontrado

        // Configuración de los mocks
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).delete(user);

        // Ejecución del método a probar
        userService.removeUser(userId);

        // Verificación de resultados
        verify(userRepository).findById(userId);
        verify(userRepository).delete(user);
    }
}

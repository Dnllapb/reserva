package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.exception.UserException;
import com.proyecto.reserva.application.lasting.EMessage;
import com.proyecto.reserva.application.mapper.UserMapper;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.entity.User;
import com.proyecto.reserva.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public record UserService(
        UserRepository userRepository,
        UserMapper mapper
) {

    public void newUser(UserDto userDto) {
        User user = mapper.toEntity(userDto);
        userRepository.save(user);
    }

    public List<UserDto> findAllUser() throws Exception {
        List <User> users = userRepository.findAll();
        if(users.isEmpty())
        {
            throw new  Exception("Usuario no encontrado");
        }
        return mapper.toDtoList(users);

    }

    public UserDto findUserById(Integer id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception( "Usuario no encontrado"));
        return mapper.toDto(user);
    }

    public void editUser(Integer id, UserDto userDto) throws Exception {
        userRepository.findById(id)
                .orElseThrow(() -> new Exception( "Usuario no encontrado"));
        User user = mapper.toEntity(userDto);
        userRepository.save(user);
    }

    public void removeUser(Integer id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception( "Usuario no encontrado"));
        userRepository.delete(user);
    }

}

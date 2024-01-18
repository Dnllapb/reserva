package com.proyecto.reserva.application.service;


import com.proyecto.reserva.application.exception.BreweryTourException;
import com.proyecto.reserva.application.lasting.EMessage;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.entity.User;
import com.proyecto.reserva.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;
  @Autowired
  public UserService(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  //Este es un constructor de tipo lista
  public List<User> getUser()
  {
    return this.userRepository.findAll();
  }
  public ResponseEntity<Object> newUser(User user) {
    Optional<User> result =  userRepository.findUserByName(user.getName());
    if (result.isPresent())
    {
      return new ResponseEntity<>
              (
                      HttpStatus.CONFLICT
              );

    }
    userRepository.save(user);
    return new ResponseEntity<>(
            HttpStatus.CREATED
    );
  }

  public UserDto findUserById(Integer id) throws BreweryTourException {
    User user = userRepository.findById(id)
            .orElseThrow(()-> new BreweryTourException(EMessage.DATA_NOT_FOUND));

    UserDto userDto = UserDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .password(user.getPassword())
            .role(user.getRole())
            .enable(user.getEnable())
            .build();
    return userDto;


  }

  public void editUser(Integer id, UserDto userDto) throws BreweryTourException {
    User user = userRepository.findById(id)
            .orElseThrow(()-> new BreweryTourException(EMessage.DATA_NOT_FOUND));

    user.setName(userDto.name());
    user.setEmail(userDto.email());
    user.setPassword(userDto.password());
    userRepository.save(user);
  }
  public void removeUser(Integer id) throws BreweryTourException {
    User user = userRepository.findById(id).orElseThrow(()-> new BreweryTourException(EMessage.DATA_NOT_FOUND));
    userRepository.delete(user);

  }
}

package com.proyecto.reserva.application.controller;

import com.proyecto.reserva.application.exception.BreweryTourException;
import com.proyecto.reserva.application.service.UserService;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.entity.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j//logger (registro de errores o informacion importante )
@RestController
@RequestMapping("/api/v1/user")
public record UserController(
  UserService userService
) {

  @PostMapping
  @SecurityRequirement(name = "bearerAuth")
  public void newUser(@RequestBody User user) {
    this.userService.newUser(user);
  }

  @GetMapping
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<?> getUser() throws BreweryTourException {
    List<User> users = userService.getUser();
    return new ResponseEntity<>(users, HttpStatus.FOUND);
  }

  @GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<?> findUserById(@PathVariable ("id") Integer id) throws BreweryTourException
  {
    UserDto user = userService.findUserById(id);
    return new ResponseEntity<>(user,HttpStatus.OK);
  }

  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<?> editUser(@PathVariable ("id") Integer id, @RequestBody UserDto userDto)  throws BreweryTourException
  {
    userService.editUser(id,userDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @SecurityRequirement(name="bearerAuth")
  public ResponseEntity <?> removeUser(@PathVariable ("id") Integer id) throws BreweryTourException
  {
    userService.removeUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}

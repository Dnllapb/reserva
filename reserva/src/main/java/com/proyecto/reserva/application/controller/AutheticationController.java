package com.proyecto.reserva.application.controller;


import com.proyecto.reserva.application.exception.BreweryTourException;
import com.proyecto.reserva.application.service.AuthenticationService;
import com.proyecto.reserva.domain.dto.AuthenticationDto;
import com.proyecto.reserva.domain.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public record AutheticationController(
  AuthenticationService authenticationService
) {

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserDto userDto) throws BreweryTourException {
    String token = authenticationService.register(userDto);
    return new ResponseEntity<>(token, HttpStatus.CREATED);
  }

  @PostMapping("/authenticate")
  public ResponseEntity<?> authenticate(@RequestBody AuthenticationDto authenticationDto) throws BreweryTourException {
    String token = authenticationService.authenticate(authenticationDto);
    return new ResponseEntity<>(token, HttpStatus.OK);
  }

}

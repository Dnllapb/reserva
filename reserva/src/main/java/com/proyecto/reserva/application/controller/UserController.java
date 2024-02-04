package com.proyecto.reserva.application.controller;
import com.proyecto.reserva.application.service.UserService;
import com.proyecto.reserva.domain.dto.UserDto;
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
  public ResponseEntity<?> newUser(@RequestBody UserDto userDto) {
    userService.newUser(userDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<?> getUser() throws Exception {
    List<UserDto> users = userService.findAllUser();
    return new ResponseEntity<>(users, HttpStatus.FOUND);
  }

@GetMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<?> findUserById(@PathVariable ("id") Integer id) throws Exception
  {
    UserDto user = userService.findUserById(id);
    return new ResponseEntity<>(user,HttpStatus.OK);
  }
  @PutMapping("/{id}")
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<?> editUser(@PathVariable ("id") Integer id, @RequestBody UserDto userDto)  throws Exception
  {
    userService.editUser(id,userDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }


  @DeleteMapping("/{id}")
  @SecurityRequirement(name="bearerAuth")
  public ResponseEntity <?> removeUser(@PathVariable ("id") Integer id) throws Exception
  {
    userService.removeUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}

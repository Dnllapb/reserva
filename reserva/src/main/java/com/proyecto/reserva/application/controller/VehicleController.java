package com.proyecto.reserva.application.controller;

import com.proyecto.reserva.application.service.VehicleService;
import com.proyecto.reserva.domain.dto.VehicleDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public record VehicleController(VehicleService vehicleService)

{
    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> newVehicle(@RequestBody VehicleDto vehicleDto)
    {
        vehicleService.newVehicle(vehicleDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> findAllVehicle() throws Exception
    {
       List<VehicleDto> vehicles = vehicleService.findAllVehicle();
       return  new ResponseEntity<>(vehicles,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name ="bearerAuth")
    public ResponseEntity<?> findVehicleById(@PathVariable ("id") Integer id) throws Exception
    {
        VehicleDto vehicleDto = vehicleService.findVehicleById(id);
        return  new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public  ResponseEntity<?> editUser(@PathVariable("id") Integer id,@RequestBody  VehicleDto vehicleDto) throws Exception
    {
        vehicleService.editVehicle(id,vehicleDto);
        return  new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    @SecurityRequirement(name="bearerAuth")
    public  ResponseEntity<?> removeVehicle(@PathVariable("id") Integer id) throws Exception
    {
        vehicleService.removerVehicle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

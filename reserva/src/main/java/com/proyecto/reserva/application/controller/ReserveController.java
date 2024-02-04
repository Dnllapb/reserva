package com.proyecto.reserva.application.controller;
import com.proyecto.reserva.application.service.ReserveService;
import com.proyecto.reserva.domain.dto.ReserveDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j//logger (registro de errores o informacion importante )
@RestController
@RequestMapping("/api/v1/reserve")
public record ReserveController(ReserveService reserveService)
{
    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> newReserve (@RequestBody ReserveDto reserveDto)
    {
        reserveService.newReserve(reserveDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @SecurityRequirement(name= "bearerAuth")
    public ResponseEntity<?> allReserves() throws Exception
    {
        List<ReserveDto> reserveDtoList = reserveService.finAllReserve();
        return new ResponseEntity<>(reserveDtoList,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?> findReserveById (@PathVariable ("id")Long id) throws Exception
    {
       ReserveDto  reserveDto = reserveService.findReserveById(id);
       return new ResponseEntity<>(reserveDto,HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?> updateReserve(@PathVariable("id") Long id,@RequestBody  ReserveDto reserveDto) throws Exception
    {
        reserveService.editReserve(id,reserveDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?>deleteReserve(@PathVariable("id") Long id) throws Exception
    {
        reserveService.removeReserve(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


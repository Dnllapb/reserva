package com.proyecto.reserva.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyecto.reserva.application.lasting.Estatus;
import com.proyecto.reserva.domain.entity.User;
//import com.proyecto.reserva.domain.entity.Vehicle;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ReserveDto(

        Integer id,
        LocalDateTime date,
        Estatus status,
        Double fee,
        Integer hourInit,

        VehicleDto vehicleDto,
        UserDto userDto

) {
}

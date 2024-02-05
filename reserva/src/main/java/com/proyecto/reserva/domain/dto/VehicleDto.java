package com.proyecto.reserva.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record VehicleDto(

Integer id,
String plate,
String model,

UserDto userDto)
{
}

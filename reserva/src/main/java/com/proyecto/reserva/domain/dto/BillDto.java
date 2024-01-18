package com.proyecto.reserva.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BillDto(

        Integer Id,
        LocalDateTime date,
        Integer hourFinal

) {
}

package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.application.lasting.Estatus;
import com.proyecto.reserva.domain.dto.ReserveDto;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.dto.VehicleDto;
import com.proyecto.reserva.domain.entity.Reserve;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T01:18:53-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class ReserveMapperImpl implements ReserveMapper {

    @Override
    public Reserve toEntity(ReserveDto dto) {
        if ( dto == null ) {
            return null;
        }

        Reserve.ReserveBuilder reserve = Reserve.builder();

        reserve.id( dto.id() );
        reserve.date( dto.date() );
        reserve.status( dto.status() );
        reserve.fee( dto.fee() );
        reserve.hourInit( dto.hourInit() );

        return reserve.build();
    }

    @Override
    public ReserveDto toDto(Reserve entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        LocalDateTime date = null;
        Estatus status = null;
        Double fee = null;
        Integer hourInit = null;

        id = entity.getId();
        date = entity.getDate();
        status = entity.getStatus();
        fee = entity.getFee();
        hourInit = entity.getHourInit();

        VehicleDto vehicleDto = null;
        UserDto userDto = null;

        ReserveDto reserveDto = new ReserveDto( id, date, status, fee, hourInit, vehicleDto, userDto );

        return reserveDto;
    }

    @Override
    public List<ReserveDto> toDoList(List<Reserve> reserveList) {
        if ( reserveList == null ) {
            return null;
        }

        List<ReserveDto> list = new ArrayList<ReserveDto>( reserveList.size() );
        for ( Reserve reserve : reserveList ) {
            list.add( toDto( reserve ) );
        }

        return list;
    }
}

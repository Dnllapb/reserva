package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.application.mapper.base.IBaseMapper;
import com.proyecto.reserva.domain.dto.ReserveDto;
import com.proyecto.reserva.domain.entity.Reserve;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ReserveMapper extends IBaseMapper {

    Reserve toEntity(ReserveDto dto);
    ReserveDto toDto(Reserve entity);

    List<ReserveDto> toDoList(List<Reserve> reserveList);
}

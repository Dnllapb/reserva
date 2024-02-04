package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.application.mapper.base.IBaseMapper;
import com.proyecto.reserva.domain.dto.VehicleDto;
import com.proyecto.reserva.domain.entity.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface VehicleMapper extends IBaseMapper {
    Vehicle toEntity(VehicleDto dto);
    VehicleDto toDto(Vehicle entity);
    List<Vehicle> toEntityList(List<Vehicle> entityList);
    List<VehicleDto> toDtoList(List <Vehicle>  entityList);

}

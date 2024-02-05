package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.dto.VehicleDto;
import com.proyecto.reserva.domain.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T18:19:30-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle toEntity(VehicleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( dto.id() );
        vehicle.setPlate( dto.plate() );
        vehicle.setModel( dto.model() );

        return vehicle;
    }

    @Override
    public VehicleDto toDto(Vehicle entity) {
        if ( entity == null ) {
            return null;
        }

        Integer id = null;
        String plate = null;
        String model = null;

        id = entity.getId();
        plate = entity.getPlate();
        model = entity.getModel();

        UserDto userDto = null;

        VehicleDto vehicleDto = new VehicleDto( id, plate, model, userDto );

        return vehicleDto;
    }

    @Override
    public List<Vehicle> toEntityList(List<Vehicle> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( entityList.size() );
        for ( Vehicle vehicle : entityList ) {
            list.add( vehicle );
        }

        return list;
    }

    @Override
    public List<VehicleDto> toDtoList(List<Vehicle> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleDto> list = new ArrayList<VehicleDto>( entityList.size() );
        for ( Vehicle vehicle : entityList ) {
            list.add( toDto( vehicle ) );
        }

        return list;
    }
}

package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.application.mapper.base.IBaseMapper;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends IBaseMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    List<User> toEntityList(List<UserDto> dtoList);

    List<UserDto> toDtoList(List<User> entityList);

}

package com.proyecto.reserva.application.mapper.base;

import org.mapstruct.factory.Mappers;


public interface IBaseMapper {
    IBaseMapper
            INSTANCE =
            Mappers.//es una clase proporcionada por MapStruct que tiene métodos para obtener instancias de mapeadores.
                    getMapper//es un método estático de la clase Mappers que toma como argumento la interfaz del mapeador (IBaseMapper.class) y devuelve una instancia de esa interfaz. Esta instancia se asigna a la variable INSTANCE
                    (IBaseMapper.class);
}


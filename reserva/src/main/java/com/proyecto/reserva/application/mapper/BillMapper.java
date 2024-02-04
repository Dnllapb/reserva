package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.application.mapper.base.IBaseMapper;
import com.proyecto.reserva.domain.dto.BillDto;
import com.proyecto.reserva.domain.entity.Bill;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface BillMapper extends IBaseMapper {
    Bill toEntity(BillDto billDto);
    BillDto toDo(Bill entity);
    List<BillDto> todoList(List<Bill> reserveList);

}


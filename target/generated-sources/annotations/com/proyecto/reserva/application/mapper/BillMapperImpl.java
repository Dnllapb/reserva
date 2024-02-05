package com.proyecto.reserva.application.mapper;

import com.proyecto.reserva.domain.dto.BillDto;
import com.proyecto.reserva.domain.entity.Bill;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-02-04T18:19:31-0500",
=======
    date = "2024-02-03T01:18:52-0500",
>>>>>>> main
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Eclipse Adoptium)"
)
@Component
public class BillMapperImpl implements BillMapper {

    @Override
    public Bill toEntity(BillDto billDto) {
        if ( billDto == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setDate( billDto.date() );
        bill.setHourFinal( billDto.hourFinal() );

        return bill;
    }

    @Override
    public BillDto toDo(Bill entity) {
        if ( entity == null ) {
            return null;
        }

        LocalDateTime date = null;
        Integer hourFinal = null;

        date = entity.getDate();
        hourFinal = entity.getHourFinal();

        Integer id = null;

        BillDto billDto = new BillDto( id, date, hourFinal );

        return billDto;
    }

    @Override
    public List<BillDto> todoList(List<Bill> reserveList) {
        if ( reserveList == null ) {
            return null;
        }

        List<BillDto> list = new ArrayList<BillDto>( reserveList.size() );
        for ( Bill bill : reserveList ) {
            list.add( toDo( bill ) );
        }

        return list;
    }
}

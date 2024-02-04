package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.mapper.ReserveMapper;
import com.proyecto.reserva.domain.dto.ReserveDto;
import com.proyecto.reserva.domain.entity.Reserve;
import com.proyecto.reserva.domain.repository.ReserveRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public record ReserveService(
        ReserveMapper mapper,
        ReserveRepository reserveRepository
)
{
    public void newReserve(ReserveDto reserveDto)
    {
        Reserve reserve = mapper.toEntity(reserveDto);//convertir un Dto a una entidad
        reserveRepository.save(reserve);
    }
    public List<ReserveDto> finAllReserve() throws Exception
    {
        List<Reserve> reserve = reserveRepository.findAll();
        if (reserve.isEmpty())
        {
            throw new Exception("Información no encontrada");
        }
        return mapper.toDoList(reserve);
    }

    public  ReserveDto findReserveById(Long id) throws Exception
    {
        Reserve reserve = reserveRepository.findById(id).orElseThrow(()-> new Exception ("Id no encontrado"));
        return mapper.toDto(reserve);
    }
    public void editReserve(Long id , ReserveDto reserveDto ) throws Exception
    {
        reserveRepository.findById(id).orElseThrow(()-> new Exception ("Información no encontrada"));
        Reserve reserve = mapper.toEntity(reserveDto);
        reserveRepository.save(reserve);
    }

    public void removeReserve(Long id) throws Exception
    {
        Reserve reserve = reserveRepository.findById(id).orElseThrow(()-> new Exception ("Información no encontrada"));
        reserveRepository.delete(reserve);
    }

}

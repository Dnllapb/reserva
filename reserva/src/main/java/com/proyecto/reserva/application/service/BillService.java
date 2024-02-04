package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.mapper.BillMapper;
import com.proyecto.reserva.domain.dto.BillDto;
import com.proyecto.reserva.domain.entity.Bill;
import com.proyecto.reserva.domain.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public record BillService
        (BillRepository billRepository, BillMapper mapper)
{
    public void newBill(BillDto billDto)
    {
        Bill bill = mapper.toEntity(billDto);
        billRepository.save(bill);
    }
    public List<BillDto> findAllBill() throws Exception
    {
        List<Bill> listBill = billRepository.findAll();
        if (listBill.isEmpty())
        {
            throw new Exception("Información de Facturas no encontrada");
        }
        return mapper.todoList(listBill);
    }

    public BillDto findBillById(Integer id) throws Exception
    {
        Bill bill = billRepository.findById(id).orElseThrow(()-> new Exception("Id no encontrado"));
        return mapper.toDo(bill);
    }
    public void editBill(Integer id, BillDto billDto) throws Exception
    {
        billRepository.findById(id).orElseThrow(()-> new  Exception("Id no encontrado"));
        Bill bill = mapper.toEntity(billDto);
        billRepository.save(bill);
    }

    public void deleteBill(Integer id) throws Exception
    {
        Bill bill = billRepository.findById(id).orElseThrow(()-> new Exception ("Id no encontrado"));
       billRepository.delete(bill);
    }
}

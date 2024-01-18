package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.exception.BreweryTourException;
import com.proyecto.reserva.domain.dto.BillDto;
import com.proyecto.reserva.domain.entity.Bill;
import com.proyecto.reserva.domain.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;


    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public void findBillById(Integer id) throws BreweryTourException
    {
        Optional <Bill> bill = billRepository.findById(id);
        if (bill.isPresent())
        {
            bill.get();
        }

    }



}

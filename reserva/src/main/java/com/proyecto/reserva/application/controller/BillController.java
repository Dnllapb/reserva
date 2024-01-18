package com.proyecto.reserva.application.controller;

import com.proyecto.reserva.application.service.BillService;
import com.proyecto.reserva.domain.entity.Bill;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/bill")
public record BillController(//representar datos inmutables
BillService billService)

{
   // @GetMapping
    //@SecurityRequirement(name = "bearerAuth")
    //public ResponseEntity<?>getBill()
    //{
        //List<Bill>  bills = billService.findBillById(id);
        //return  new ResponseEntity<>(bills, HttpStatus.OK);
   // }

}

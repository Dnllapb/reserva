package com.proyecto.reserva.application.controller;

import com.proyecto.reserva.application.service.BillService;
import com.proyecto.reserva.domain.dto.BillDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public record BillController(//representar datos inmutables
BillService billService)

{
    @PostMapping
    @SecurityRequirement(name = "bearerAuth")

    public ResponseEntity<?>newBill(@RequestBody BillDto billDto)
    {
        billService.newBill(billDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?>findAllBill() throws Exception
    {
        List<BillDto> listBill = billService.findAllBill();
        return new ResponseEntity<>(listBill, HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?> findAllById(@PathVariable ("id")Integer id) throws Exception
    {
        BillDto billDto = billService.findBillById(id);
        return new ResponseEntity<>(billDto,HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?>updateBill(@PathVariable("id")Integer id,@RequestBody BillDto billDto) throws Exception
    {
        billService.editBill(id, billDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?>deleteBill(@PathVariable("id") Integer id ) throws Exception
    {
        billService.deleteBill(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

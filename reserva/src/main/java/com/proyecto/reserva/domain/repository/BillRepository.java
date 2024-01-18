package com.proyecto.reserva.domain.repository;

import com.proyecto.reserva.domain.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository <Bill, Integer> {
}

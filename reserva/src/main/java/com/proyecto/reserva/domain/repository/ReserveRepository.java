package com.proyecto.reserva.domain.repository;

import com.proyecto.reserva.domain.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository <Reserve,Long> {
}

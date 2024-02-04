package com.proyecto.reserva.domain.repository;

import com.proyecto.reserva.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}

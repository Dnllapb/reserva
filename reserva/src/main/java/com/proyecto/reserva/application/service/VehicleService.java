package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.mapper.VehicleMapper;
import com.proyecto.reserva.domain.dto.VehicleDto;
import com.proyecto.reserva.domain.entity.Vehicle;
import com.proyecto.reserva.domain.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record VehicleService(VehicleRepository vehicleRepository, VehicleMapper mapper)
{
    public void newVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = mapper.toEntity(vehicleDto);
        vehicleRepository.save(vehicle);

    }
    public List<VehicleDto> findAllVehicle() throws Exception
    {
        List <Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty())
        {
            throw new Exception("Información no encontrada");
        }
        return mapper.toDtoList(vehicles);
    }

    public VehicleDto findVehicleById(Integer  id) throws Exception
    {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(
                ()-> new Exception ("Información no encontrada"));
        return mapper.toDto(vehicle);
    }

   public void editVehicle(Integer id, VehicleDto vehicleDto) throws Exception
   {
       vehicleRepository.findById(id).orElseThrow(()
               -> new Exception("Información no encontrada"));
       Vehicle vehicle = mapper.toEntity(vehicleDto);
       vehicleRepository.save(vehicle);
   }

   public  void removerVehicle(Integer id) throws  Exception
   {
       Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()-> new Exception("Información no encontrada"));
       vehicleRepository.delete(vehicle);
   }

}

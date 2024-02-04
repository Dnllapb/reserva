package com.proyecto.reserva.domain.repository;
import com.proyecto.reserva.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByEmail(String email);

}

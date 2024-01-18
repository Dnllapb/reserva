package com.proyecto.reserva.application.service;

import com.proyecto.reserva.application.exception.BreweryTourException;
import com.proyecto.reserva.application.lasting.EMessage;
import com.proyecto.reserva.domain.dto.AuthenticationDto;
import com.proyecto.reserva.domain.dto.UserDto;
import com.proyecto.reserva.domain.entity.User;
import com.proyecto.reserva.domain.repository.UserRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;


@Service
public record AuthenticationService(
        UserRepository userRepository,
        JwtService jwtService,
        PasswordEncoder passwordEncoder,

        AuthenticationManager authenticationManager
) {

    public String register(UserDto userDto) throws BreweryTourException {
        try {

            User user = User.builder()
                    .name(userDto.name())
                    .email(userDto.email())
                    .password(passwordEncoder.encode(userDto.password()))
                    .role(userDto.role())
                    .enable(true).build();
            userRepository.save(user);
            return jwtService.generateToken(user);
        } catch (DataIntegrityViolationException e) {
            throw new BreweryTourException(EMessage.USER_EXISTS);
        }
    }

    public String authenticate(AuthenticationDto authenticationDto) throws BreweryTourException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationDto.email(),
                        authenticationDto.password()
                )
        );

        User user = userRepository.findUserByEmail(authenticationDto.email())
                .orElseThrow(() -> new BreweryTourException(EMessage.INVALID_CREDENTIALS));
        return jwtService.generateToken(user);
    }
}

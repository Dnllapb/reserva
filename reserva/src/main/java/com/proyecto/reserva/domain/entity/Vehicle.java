package com.proyecto.reserva.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="vehicle")
public class Vehicle {

    @Id
    //SequenceGenerator= maquina que genera automaticamente numeros en orden
    //name = nombre de la maquina
    //sequenceName = letrero que se le pone a la maquina
    @SequenceGenerator(name ="vehicle_id_sequence",sequenceName = "vehicle_id_sequence")
    //GeneratedValue= el id se genera automaticamente
    //strategy = que la estrategia a utilizar para generar el numero sea mediante una secuencia
    //generetor = que quiero utulizar la maquina generadora de numeros que se llama
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_id_sequence")
    private Integer id;
    private String plate;
    private String model;
    @OneToMany
    @JoinColumn
    private User user;

}

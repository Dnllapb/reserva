package com.proyecto.reserva.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    //SequenceGenerator= maquina que genera automaticamente numeros en orden
    //name = nombre de la maquina
    //sequenceName = letrero que se le pone a la maquina
    @SequenceGenerator(name ="bill_id_sequence",sequenceName = "bill_id_sequence")
    //GeneratedValue= el id se genera automaticamente
    //strategy = que la estrategia a utilizar para generar el numero sea mediante una secuencia
    //generetor = que quiero utulizar la maquina generadora de numeros que se llama
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_id_sequence")
    private Integer id;
    private LocalDateTime date;
    private Integer hourFinal;
    private Double totalBill;

    @ManyToOne
    @JoinColumn(name ="id_user")
    private Reserve reserve;

    @ManyToOne
    @JoinColumn(name ="id_vehicle")
    private Vehicle vehicle;

}


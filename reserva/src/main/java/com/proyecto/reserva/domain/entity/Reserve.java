package com.proyecto.reserva.domain.entity;

import com.proyecto.reserva.application.lasting.Estatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="reserve")
public class Reserve {
    @Id
    //SequenceGenerator= maquina que genera automaticamente numeros en orden
    //name = nombre de la maquina
    //sequenceName = letrero que se le pone a la maquina
    @SequenceGenerator(name = "reserve_id_sequence", sequenceName = "reserve_id_sequence")
    //GeneratedValue= el id se genera automaticamente
    //strategy = que la estrategia a utilizar para generar el numero sea mediante una secuencia
    //generetor = que quiero utulizar la maquina generadora de numeros que se llama
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reserve_id_sequence")
    private Integer id;
    private LocalDateTime date;
    //Enumerated la viariable state almacenara datos de tipo string en vez de numeros
    @Enumerated(EnumType.STRING)
    private Estatus status;
    private Double fee;
    private Integer hourInit;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;


}

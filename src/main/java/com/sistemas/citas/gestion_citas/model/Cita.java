/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 *
 * @author aracelygarcia
 */

@Entity
public class Cita {
    // El id será único de tipo Long y se generará automaticamente
    @Id @GeneratedValue
    private Long id;
    //Un cliente puede tener agendadas varias citas, un servicio puede estar en varias citas
    @ManyToOne private Cliente cliente;
    @ManyToOne private Servicio servicio;
    private LocalDateTime fechaHora;
    private String estado; //Pendiente, condirmada, cancelada, atendida
    private String notas;
    private LocalDateTime fechaCancelacion;
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;

/**
 *
 * @author aracelygarcia
 */

@Entity
public class Servicio {
    // El id será único de tipo Long y se generará automaticamente
    @Id @GeneratedValue
    private Long id;
    //Asegura unicidad del código del servicio 
    @Column(unique = true) private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer duracionMinutos;
    private Integer maxConcurrentes;
    private boolean activo = true;
    
}

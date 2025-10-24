/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author aracelygarcia
 */

@Entity
public class Factura {
    // El id será único de tipo Long y se generará automaticamente
   @Id @GeneratedValue
   private Long id;
   //Una factura puede referirse a una cita.
   @OneToOne private Cita cita;
   //Asegura unicidad del número de factura 
   @Column(unique = true) private String numeroFactura;
   private BigDecimal monto;
   private LocalDateTime fechaEmision;
   private String estado; // Pagada, pendiente
    
}

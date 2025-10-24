/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 *
 * @author aracelygarcia
 */

@Entity
public class Cliente {
    // El id será único de tipo Long y se generará automaticamente
   @Id @GeneratedValue
   private Long id;
   private String nombre;
   //Asegura unicidad del email del cliente. 
   @Column(unique = true) private String email;
   private String contrasena;
   private String dpi;
   private String telefono;
   private LocalDate fechaNacimiento;
   private boolean activo = true;
    
    
}

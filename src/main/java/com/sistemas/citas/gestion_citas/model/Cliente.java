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
   
   //Constructor

    public Cliente(Long id, String nombre, String email, String contrasena, String dpi, String telefono, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.dpi = dpi;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Getters y setters 

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public String getDpi() {return dpi;}

    public void setDpi(String dpi) {this.dpi = dpi;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}

    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public boolean isActivo() {return activo;}

    public void setActivo(boolean activo) {this.activo = activo;}
    
   
}

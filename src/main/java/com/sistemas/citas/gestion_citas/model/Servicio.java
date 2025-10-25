/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

/**
 *
 * @author aracelygarcia
 */

@Entity
public class Servicio {
    //Asegura unicidad del código del servicio 
    @Column(unique = true) private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer duracionMinutos;
    private Integer maxConcurrentes;
    private boolean activo = true;
    
    //Constructor

    public Servicio(String codigo, String nombre, String descripcion, BigDecimal precio, Integer duracionMinutos, Integer maxConcurrentes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracionMinutos = duracionMinutos;
        this.maxConcurrentes = maxConcurrentes;
    }
    
    // Getters y setters

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public BigDecimal getPrecio() {return precio;}

    public void setPrecio(BigDecimal precio) {this.precio = precio;}

    public Integer getDuracionMinutos() {return duracionMinutos;}

    public void setDuracionMinutos(Integer duracionMinutos) {this.duracionMinutos = duracionMinutos;}

    public Integer getMaxConcurrentes() {return maxConcurrentes;}

    public void setMaxConcurrentes(Integer maxConcurrentes) {this.maxConcurrentes = maxConcurrentes;}

    public boolean isActivo() {return activo;}

    public void setActivo(boolean activo) {this.activo = activo;}
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.Validator;

import java.math.BigDecimal;

/**
 *
 * @author aracelygarcia
 */
public class ValidadorServicio {
    
    //Valida el registro si cumple con todos los requerimientos, si no, lanza un error y no valida la creacion del servicio
    public void validarParaCreacion(String codigo, String nombre, BigDecimal precio, 
            Integer duracionMinutos, Integer maxConcurrentes){
        //Requerimiento 1. El codigo no debe de estar vacío
        if (codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("El código del servicio es obligatorio");
        }
        //Requerimiento 2. El nombre no debe de estar vacío
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del servicio es obligatorio");
        }
        //Requerimiento 3. El precio debe ser mayor a 0
        if (precio == null || precio.compareTo(BigDecimal.ZERO)<= 0){
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
        //Requerimiento 4. Los minutos deben ser mayores a 0 
        if (duracionMinutos == null || duracionMinutos < 0){
            throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos");
        }
        //Requerimiento 5. El cupo máximo no debe superar los 10 concurrentes ni
        //tener menos de un concurrente
        if(maxConcurrentes == null || maxConcurrentes < 1 || maxConcurrentes > 10){
            throw new IllegalArgumentException("El cupo máximo debe estar entre 1 y 10");
        }   
        
    }
    
    //Valida los datos ingresados para la actualización del servicio, el código 
    //ya no es necesario ya que el servicio ya fue creado
    public void validarParaActualización(String nombre, BigDecimal precio, 
            Integer duracionMinutos, Integer maxConcurrentes){
        //Requerimiento 1. El nombre no debe de estar vacío
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del servicio es obligatorio");
        }
        //Requerimiento 2. El precio debe ser mayor a 0
        if (precio == null || precio.compareTo(BigDecimal.ZERO)<= 0){
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
        //Requerimiento 3. Los minutos deben ser mayores a 0 
        if (duracionMinutos == null || duracionMinutos < 0){
            throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos");
        }
        //Requerimiento 4. El cupo máximo no debe superar los 10 concurrentes ni
        //tener menos de un concurrente
        if(maxConcurrentes == null || maxConcurrentes < 1 || maxConcurrentes > 10){
            throw new IllegalArgumentException("El cupo máximo debe estar entre 1 y 10");
        }
    }
}

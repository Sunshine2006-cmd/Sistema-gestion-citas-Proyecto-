/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.Validator;

import java.time.LocalDate;

/**
 *
 * @author aracelygarcia
 */
public class ValidadorCliente {
    
    //Valida el registro si cumple con todos los requerimientos, si no, lanza un error y no valida al cliente
    public void validarRegistro(String nombre, String email, String dpi, 
            String contrasena, String telefono, LocalDate fechaNacimiento){
        //Requerimiento 1. El nombre no debe de estar vacío
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Colocar el nombre es obligatorio");
        //Requerimiento 2. El correo posee un formato válido
        if (!email.matches("^[\\\\w.-]+@([\\\\w-]+\\\\.)+[\\\\w-]{2,}$"))
            throw new IllegalArgumentException("Formato de email inválido");
        //Requerimiento 3. El dpi no debe estar vacío, tiene que tener al menos 8 dígitos
        if (dpi == null || dpi.length() < 8)
            throw new IllegalArgumentException("El DPI debe tener al menos 8 dígitos");
        //Requerimiento 4. La contraseña no debe estar vacía, debe de tener por 
        //lo menos 8 dígitos solo número y letras
        if (contrasena == null || contrasena.length() < 8 || 
            !contrasena.matches(".*\\d.*") || !contrasena.matches(".*[a-zA-Z].*"))
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres (letras y números)");
        //Requerimiento 5. El telefono no debe de estar vacío, debe tener al  menos 8 dígitos
        if(telefono == null || telefono.length() < 8)
            throw new IllegalArgumentException("El teléfono debe tener al menos 8 dígitos");
    }
    
}

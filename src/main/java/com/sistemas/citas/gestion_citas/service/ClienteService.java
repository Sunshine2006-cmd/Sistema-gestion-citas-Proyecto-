/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.service;

import com.sistemas.citas.gestion_citas.Repository.ClienteRepository;
import com.sistemas.citas.gestion_citas.Validator.ValidadorCliente;
import com.sistemas.citas.gestion_citas.model.Cliente;
import java.time.LocalDate;

/**
 *
 * @author aracelygarcia
 */
public class ClienteService {
    private final ClienteRepository clienteRepo;
    private final ValidadorCliente validador;

    //Constructor
    public ClienteService(ClienteRepository clienteRepo, ValidadorCliente validador) {
        this.clienteRepo = clienteRepo;
        this.validador = validador;
    }

    //Registra al cliente siempre y cuando algun dato no se encuentra ya registrado(email, dpi)
    public Cliente registrarClientes(String nombre, String email, String dpi, 
            String contrasena, String telefono, LocalDate fechaNacimiento){
        validador.validarRegistro(nombre, email, dpi, contrasena, telefono, fechaNacimiento);
        
        if (clienteRepo.findByEmail(email).isPresent()){
            throw new IllegalArgumentException("El email ya esta registrado");
        }
        if(clienteRepo.findByDpi(dpi).isPresent()){
            throw new IllegalArgumentException("El DPI ya esta registrado");
        }
        //Retorna los datos del cliente si se registró
        return clienteRepo.save(new Cliente (null, nombre, email, dpi, contrasena, telefono, fechaNacimiento));
    }
    
    //Desactiva al cliente mientras este exista, sino lanza un error
    public void desactivarCliente(Long id){
        if(!clienteRepo.deactivate(id)){
            throw new IllegalArgumentException("Cliente no encontrado: " + id);
        }
    }
    
    
}

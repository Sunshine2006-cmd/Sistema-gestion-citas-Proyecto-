/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.Repository;

import com.sistemas.citas.gestion_citas.model.Cliente;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author aracelygarcia
 */
public class ClienteRepository {
    // Se almacenarán los clientes: id(K) , Cliente (V)
    private final Map<Long, Cliente> clientes = new HashMap<>();
    // Se almacenarán los emails de los clientes: email (K), Cliente (V)
    private final Map<String, Cliente> emailIndex = new HashMap<>();
    //Se almacenarán la identificación de los clientes: dpi (K), Cliente (V)
    private final Map<String, Cliente> dpiIndex = new HashMap<>();
    //Generador de ids únicos
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    //Constructor vacío
    public ClienteRepository(){}
    
    //CREATE
    
    public Cliente save(Cliente cliente){
        //Crea id único
        Long id = idGenerator.getAndIncrement();
        //Crea nuevo cliente en base a datos del cliente sacados de la clase Cliente
        cliente = new Cliente(id, cliente.getNombre(), cliente.getEmail(),
            cliente.getDpi(), cliente.getContrasena(), cliente.getTelefono(), 
                cliente.getFechaNacimiento());
        //Guarda en hashMap clientes
        clientes.put(id, cliente);
        //Guarda en hashMap emailIndex
        emailIndex.put(cliente.getEmail(), cliente);
        //Giarda en hashMap dpiIndex
        dpiIndex.put(cliente.getDpi(), cliente);
        return cliente;
    }
    
    // READ
    
    //Muestra según el id (clientes)
    public Optional<Cliente> findById(Long id){
        return Optional.ofNullable(clientes.get(id));
    }
    //Muestra según el email(emailIndex)
    public Optional<Cliente> findByEmail(String email){
        return Optional.ofNullable(emailIndex.get(email));
    }
    //Muestra según la identificación (dpiIndex)
    public Optional<Cliente> findByDpi(String dpi){
        return Optional.ofNullable(dpiIndex.get(dpi));
    }
    
    //UPDATE (activar/desactivar o edición de datos)
    
    public boolean update(Cliente clienteActualizado){
        if(!clientes.containsKey(clienteActualizado.getId())) return false;
        
        //Actualiza índices si cambian email o DPI (opcional)
        clientes.put(clienteActualizado.getId(), clienteActualizado);
        return true;
    }
    
    //DELETE lógico
    public boolean deactivate(Long id){
        return clientes.computeIfPresent(id, (k,v) -> {
        v.setActivo(false);
        return v;
        }) != null;
    }
}

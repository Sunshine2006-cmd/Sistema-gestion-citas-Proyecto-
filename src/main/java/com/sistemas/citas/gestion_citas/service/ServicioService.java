/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.service;

import com.sistemas.citas.gestion_citas.Validator.ValidadorServicio;
import com.sistemas.citas.gestion_citas.model.Servicio;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 *
 * @author aracelygarcia
 */
public class ServicioService {
    private final Map<String, Servicio> servicios = new ConcurrentHashMap<>();
    private final ValidadorServicio validador;
    
    //Constructor
    public ServicioService(ValidadorServicio validador){
        this.validador = validador;
    }
    
    //Crear / create
    public Servicio crearServicio(String codigo, String nombre, String descripcion,
            BigDecimal precio, Integer duracionMinutos, Integer maxConcurrentes){
        // Validación de negocio
        validador.validarParaCreacion(codigo, nombre, precio, duracionMinutos, maxConcurrentes);
        
        // Validación de unicidad
        if(servicios.containsKey(codigo)){
            throw new IllegalArgumentException("El código '" + "' ya está en uso.");
        }
        
        Servicio nuevo = new Servicio(codigo, nombre, descripcion, precio, duracionMinutos,
        maxConcurrentes);
        //Guarda el servicio en el HashMap servicios
        servicios.put(codigo, nuevo);
        return nuevo;
        
    }
    
    //Editar / Update
    public Servicio actualizarServicio(String codigo, String nombre, String descripcion,
            BigDecimal precio, Integer duracionMinutos, Integer maxConcurrentes){
        Servicio existente = servicios.get(codigo);
        if (existente == null || !existente.isActivo()){
            throw new IllegalArgumentException("Servicio no encontrado o inactivo");
        }
        
        validador.validarParaActualización(nombre, precio, duracionMinutos, maxConcurrentes);
        
        existente.setNombre(nombre);
        existente.setDescripcion(descripcion);
        existente.setPrecio(precio);
        existente.setDuracionMinutos(duracionMinutos);
        existente.setMaxConcurrentes(maxConcurrentes);
        
        return existente;
    }
    
    //Desactivar/Borrar (activar desactivar)
    public boolean desactivarServicio(String codigo){
        Servicio servicio = servicios.get(codigo);
        if(servicio == null){
            return false;
        }
        servicio.setActivo(false);
        return true;
    }
    
    //Listar servicios activos
    public List<Servicio> listarServiciosActivos(){
        return servicios.values().stream().filter(Servicio::isActivo).toList();
    }
    
    //Buscar por código
    public Servicio obtenerPorCodigo(String codigo){
        Servicio servicio = servicios.get(codigo);
        if(servicio == null || !servicio.isActivo()){
            throw new IllegalArgumentException("Servicio no encontrado.");
        }
        return servicio;
    }
}

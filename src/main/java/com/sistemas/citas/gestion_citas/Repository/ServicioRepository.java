/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.citas.gestion_citas.Repository;

import com.sistemas.citas.gestion_citas.model.Servicio;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author aracelygarcia
 */
public class ServicioRepository {
    // Se almacenarán los serviciod:  Servicio (V)
    private final Map<String, Servicio> servicios = new HashMap<>();
    
    //Guardar
    
    public Servicio save(Servicio servicio){
        //Para guardar debe cumplir ciertos criterios, si no se cumplen se mestra error
        //Criterio 1
        if (servicios.containsKey(servicio.getCodigo())){
            throw new IllegalArgumentException("Este código de servicio ya existe: "+
                    servicio.getCodigo());}
        //Criterio 2
        if (servicio.getPrecio().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        //Criterio 3
        if(servicio.getDuracionMinutos() <= 0){
            throw new IllegalArgumentException("La duración debe ser mayor a 0");
        }
        //Se guarda en HashMap servicios
        servicios.put(servicio.getCodigo(), servicio);
        return servicio;
    }
    
    //Mostrar por código de servicio
    public Optional<Servicio> findByCodigo(String codigo){
        return Optional.ofNullable(servicios.get(codigo));
    }
    
    //Listar por servicios activos
    public List<Servicio> findAllActive(){
        return servicios.values().stream().filter(Servicio::isActivo).toList();
        
    }
    
    //UPDATE
    
    public boolean update(Servicio servicio){
        if(!servicios.containsKey(servicio.getCodigo())) return false;
        servicios.put(servicio.getCodigo(), servicio);
        return true;
    }
    
    //DELETE lógico
    public boolean deactivate(String codigo){
        return servicios.computeIfPresent(codigo, (k,v) -> {
            v.setActivo(false);
            return v;
        }) !=null;
    }
    
    
}

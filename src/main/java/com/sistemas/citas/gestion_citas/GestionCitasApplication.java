package com.sistemas.citas.gestion_citas;

import com.sistemas.citas.gestion_citas.Validator.ValidadorCliente;
import com.sistemas.citas.gestion_citas.Repository.ClienteRepository;
import com.sistemas.citas.gestion_citas.model.Cliente;
import com.sistemas.citas.gestion_citas.service.ClienteService;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionCitasApplication {

	public static void main(String[] args) {
		ClienteRepository repo = new ClienteRepository();
                ValidadorCliente validador = new ValidadorCliente();
                ClienteService service = new ClienteService(repo, validador);
                
                try{
                    Cliente c1 = service.registrarClientes("Ana López",
                            "ana@gmail.com", "12345678", "Pass1234", "55551234", 
                            LocalDate.of(2006, 12,24));
                    System.out.println("Cliente registrado: " + c1.getEmail());
                    
                    service.registrarClientes("Daniel Jimenez", "ana@gmail.com", 
                            "87654321", "Pass1234", "55550000", LocalDate.of(2011, 10, 3));
                }catch(IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
	}

}

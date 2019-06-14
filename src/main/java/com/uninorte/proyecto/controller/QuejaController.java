package com.uninorte.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uninorte.proyecto.controller.queja.interfaces.QuejaService;
import com.uninorte.proyecto.entities.queja.Queja;
import com.uninorte.proyecto.entities.usuario.Usuario;
import com.uninorte.proyecto.whatsapp.Whatsapp;

@CrossOrigin(origins = "https://uninorte-pqr.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class QuejaController {

	@Autowired
    QuejaService service;
    
    @GetMapping({"/quejas"})
    public List<Queja> listar(){
    	return service.listar();
        
    }
    
    @PostMapping({"/queja"})
    public Queja agregar(@RequestBody Queja q){
        return service.add(q);
    }
    
    @GetMapping(path = {"/queja/{id}"})
    public Queja detalle(@PathVariable("id")int id) {
    	return service.detalle(id);
    }
    
    @GetMapping({"/whatsapp"})
    public Map<String, Boolean> wapp(){
    	Whatsapp wapp = new Whatsapp();
    	wapp.enviar();
    	
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("whatsapp", Boolean.TRUE);
	    return response;
    }
}

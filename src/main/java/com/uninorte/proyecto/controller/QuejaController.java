package com.uninorte.proyecto.controller;

import java.util.List;

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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
    
}

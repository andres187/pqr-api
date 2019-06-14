package com.uninorte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uninorte.proyecto.controller.queja.interfaces.ComentarioService;
import com.uninorte.proyecto.entities.queja.Comentario;

@CrossOrigin(origins = "https://uninorte-pqr.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class ComentarioController {
	@Autowired
	ComentarioService service;
	
	@GetMapping({"/comentarios"})
	public List<Comentario> listar(){
		return service.listar();
	}
	
	@PostMapping({"/comentario"})
    public Comentario agregar(@RequestBody Comentario c){
        return service.add(c);
    }

}

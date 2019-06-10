package com.uninorte.proyecto.controller.queja.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uninorte.proyecto.controller.queja.interfaces.ComentarioRepositorio;
import com.uninorte.proyecto.controller.queja.interfaces.ComentarioService;
import com.uninorte.proyecto.entities.queja.Comentario;

@Service
public class ComentarioServiceIMPL implements ComentarioService{

	@Autowired
	private ComentarioRepositorio repositorio;

	@Override
	public List<Comentario> listar() {		
		return repositorio.findAll();
	}

	@Override
	public Comentario add(Comentario c) {
		return repositorio.save(c);
	}
	

}

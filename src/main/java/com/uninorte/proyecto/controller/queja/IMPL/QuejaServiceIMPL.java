package com.uninorte.proyecto.controller.queja.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uninorte.proyecto.controller.queja.interfaces.QuejaRepositorio;
import com.uninorte.proyecto.controller.queja.interfaces.QuejaService;
import com.uninorte.proyecto.entities.queja.Queja;

@Service
public class QuejaServiceIMPL implements QuejaService {
	
	@Autowired
    private QuejaRepositorio repositorio;
    

	@Override
	public List<Queja> listar() {
		return repositorio.findAll();
	}


	@Override
	public Queja add(Queja q) {
		return repositorio.save(q);
	}
	
	@Override
	public Queja detalle(int id) {
		return repositorio.findById(id);
	}
	
	
	
	
}

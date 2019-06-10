package com.uninorte.proyecto.controller.queja.interfaces;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.uninorte.proyecto.entities.queja.Comentario;

public interface ComentarioRepositorio extends Repository<Comentario, Integer>{
	List<Comentario> findAll();
	Comentario save(Comentario c);
}

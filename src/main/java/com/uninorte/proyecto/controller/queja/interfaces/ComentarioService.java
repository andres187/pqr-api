package com.uninorte.proyecto.controller.queja.interfaces;

import java.util.List;

import com.uninorte.proyecto.entities.queja.Comentario;

public interface ComentarioService {
	List<Comentario> listar();
	
	Comentario add(Comentario c);
}

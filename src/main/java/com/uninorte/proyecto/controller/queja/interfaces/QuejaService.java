package com.uninorte.proyecto.controller.queja.interfaces;

import java.util.List;


import com.uninorte.proyecto.entities.queja.Queja;

public interface QuejaService {
	List<Queja> listar();
	
	Queja add(Queja q);
	
	Queja detalle(int id);
}


package com.uninorte.proyecto.controller.queja.interfaces;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.uninorte.proyecto.entities.queja.Queja;

public interface QuejaRepositorio extends Repository<Queja, Integer>{
	List<Queja> findAll();
	Queja save(Queja p);
	Queja findById(int id);
	
}

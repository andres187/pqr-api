/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto.controller.usuario.interfaces;

import com.uninorte.proyecto.entities.usuario.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Bolivar
 */
public interface UsuarioRepositorio extends Repository<Usuario, Integer> {
    List<Usuario> findAll();
    Usuario save(Usuario u);
    
    /**
     *
     * @param usuario
     * @return
     */
    @Query("select u  from users u  where u.usuario=:usuario")
		Usuario getUserByUsuario(@Param("usuario") String usuario);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto.controller.usuario.interfaces;

import com.uninorte.proyecto.controller.usuario.LoginResponse;
import com.uninorte.proyecto.entities.usuario.Usuario;
import com.uninorte.proyecto.entities.usuario.Credencial;
import java.io.File;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Andres Bolivar
 */
public interface UsuarioService {
    
    List<Usuario> listar();
    Usuario add(Usuario u);
    void archivo();
    LoginResponse login(Credencial credencial);
            
    
}

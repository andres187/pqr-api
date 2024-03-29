/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto.controller;
import com.uninorte.proyecto.entities.usuario.Credencial;
import com.uninorte.proyecto.entities.usuario.Usuario;
import com.uninorte.proyecto.controller.usuario.LoginResponse;
import com.uninorte.proyecto.controller.usuario.interfaces.UsuarioService;
import com.uninorte.proyecto.controller.usuario.security.SecurityConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Bolivar
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping({"/usuarios"})
    public List<Usuario> listar(){
        return service.listar();
    }
    
    
    @PostMapping({"/usuarios"})
    public Usuario agregar(@RequestBody Usuario u){
        return service.add(u);
    }
    
     @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Credencial credenciales){
        LoginResponse response = service.login(credenciales);
		HttpHeaders headers = new HttpHeaders();
		headers.add(SecurityConstants.HEADER_STRING, response.getToken());
		ResponseEntity<LoginResponse> responseEnt = new ResponseEntity<>(response, headers, HttpStatus.OK);
		return responseEnt;

    }
 
    @GetMapping("/descargar")
    public Map<String, Boolean> descargar(){
        service.archivo();
        Map<String, Boolean> response = new HashMap<>();
        response.put("ruta", Boolean.TRUE);
        return response;
    }   
    
    @GetMapping("/upload")
    public Map<String, Boolean> upload(){
        service.upload();
        Map<String, Boolean> response = new HashMap<>();
        response.put("upload", Boolean.TRUE);
        return response;
    }        
    
    
}

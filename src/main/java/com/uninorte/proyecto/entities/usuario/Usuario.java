/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uninorte.proyecto.entities.usuario;

import java.io.Serializable;
import javax.persistence.*;

import com.uninorte.proyecto.entities.queja.Queja;

import java.util.List;

/**
 *
 * @author Andres Bolivar
 */
@Entity(name = "users")
@Table(name = "users")
public class Usuario implements Serializable {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String password;
    @Column
    private String usuario;
    
//    @OneToMany
//    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario", insertable = false, updatable = false)
//    private List<Queja> queja;
//    
//
//
//    public List<Queja> getPqr() {
//		return queja;
//	}
//	public void setPqr(List<Queja> queja) {
//		this.queja = queja;
//	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
}

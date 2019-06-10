
package com.uninorte.proyecto.entities.queja;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.uninorte.proyecto.entities.usuario.Usuario;

@Entity(name = "quejas")
@Table(name = "quejas")
public class Queja implements Serializable {

	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private int id_usuario;
    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario", insertable = false, updatable = false)
    private Usuario usuario;
    @OneToMany
    @JoinColumn(name="id_queja", referencedColumnName="id", insertable = false, updatable = false)
    private List<Comentario> comentarios;
    
    public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentario(List<Comentario> comentario) {
		this.comentarios = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
    
}

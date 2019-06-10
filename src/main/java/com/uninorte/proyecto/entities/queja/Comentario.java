package com.uninorte.proyecto.entities.queja;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.uninorte.proyecto.entities.usuario.Usuario;

@Entity(name = "comentarios")
@Table(name = "comentarios")
public class Comentario implements Serializable {

		@Id
	    @Column
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    @Column
	    private String comentario;
	    @Column
	    private int id_queja;
	    @Column
	    private int id_usuario;
	    @ManyToOne
	    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario", insertable = false, updatable = false)
	    private Usuario usuario;
	    
	    	    
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getComentario() {
			return comentario;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}
		public int getId_queja() {
			return id_queja;
		}
		public void setId_queja(int id_queja) {
			this.id_queja = id_queja;
		}
		public int getId_usuario() {
			return id_usuario;
		}
		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
		}

	    
	    
}

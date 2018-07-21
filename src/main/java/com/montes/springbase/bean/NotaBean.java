package com.montes.springbase.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.montes.springbase.entity.NotaEntity;

public class NotaBean {

	private int id;
	@NotNull
    @Size(min=2, max = 10)
	private String nombre;
	private String titulo;
	private String contenido;
	private Date created;
	private Date updated;

	public NotaBean() {
	}

	// Constructor para convertir una entidad a un modelo
	public NotaBean(NotaEntity nota) {
		this.id = nota.getId();
		this.nombre = nota.getNombre();
		this.titulo = nota.getTitulo();
		this.contenido = nota.getContenido();
	}

	public NotaBean(int id, String nombre, String titulo, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "NotaBean [id=" + id + ", nombre=" + nombre + ", titulo=" + titulo + ", contenido=" + contenido
				+ ", created=" + created + ", updated=" + updated + "]";
	}

}

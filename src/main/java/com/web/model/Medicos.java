package com.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicos")
public class Medicos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre; 
	@Column
	private String cedula;
	@Column
	private String correo;
	@Column
	private String telefono;
	@Column
	private boolean estado;
	
    @OneToMany(mappedBy="medico", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<MedicosEspecialidades> me;
	
	//METODO CONSTRUCTOR
	public Medicos() {
		super();
		// TODO Auto-generated constructor stub
	}

	//METODO SETTERS AND GETTERS
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


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	//METODO TO STRING 
	@Override
	public String toString() {
		return "Medicos [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo + ", telefono="
				+ telefono + ", estado=" + estado + "]";
	}
	
	
	
	

}

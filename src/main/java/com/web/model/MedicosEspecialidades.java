package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="medicos_especialidades")
public class MedicosEspecialidades {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @ManyToOne
	    @JoinColumn(name = "idmedico", nullable = false)
	    private Medicos medico;

	    @ManyToOne
	    @JoinColumn(name = "idespecialidad", nullable = false)
	    private Especialidades especialidad;

	    @Column(name = "estado", nullable = false)
	    private boolean estado;
	    
	
	
	//METODO CONSTRUCTOR 
	public MedicosEspecialidades() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//GENERAR METODOS GETTERS AND SETTERS 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medicos getMedico() {
		return medico;
	}

	public void setMedico(Medicos medico) {
		this.medico = medico;
	}

	public Especialidades getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidades especialidad) {
		this.especialidad = especialidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "MedicosEspecialidades [id=" + id + ", medico=" + medico + ", especialidad=" + especialidad + ", estado="
				+ estado + "]";
	}

	
	
	
}

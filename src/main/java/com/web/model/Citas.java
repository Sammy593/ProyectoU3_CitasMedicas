package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="citas")
public class Citas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@ManyToOne()
    @JoinColumn(name = "IDMEDICO")
	private Medicos medico;
    
	@ManyToOne()
    @JoinColumn(name = "IDPACIENTE")
	private Pacientes paciente;
	
	@ManyToOne()
    @JoinColumn(name = "IDTURNO")
	private Turnos turno;
	
	@ManyToOne()
    @JoinColumn(name = "IDESPECIALIDAD")
	private Especialidades especialidad;
	@Column
	private Boolean ESTADO;
	
	public Citas() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Medicos getMedico() {
		return medico;
	}

	public void setMedico(Medicos medico) {
		this.medico = medico;
	}

	public Pacientes getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}

	public Turnos getTurno() {
		return turno;
	}

	public void setTurno(Turnos turno) {
		this.turno = turno;
	}

	public Especialidades getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidades especialidad) {
		this.especialidad = especialidad;
	}

	public Boolean getESTADO() {
		return ESTADO;
	}

	public void setESTADO(Boolean eSTADO) {
		ESTADO = eSTADO;
	}

	@Override
	public String toString() {
		return "Citas [ID=" + ID + ", medico=" + medico + ", paciente=" + paciente + ", turno=" + turno
				+ ", especialidad=" + especialidad + ", ESTADO=" + ESTADO + "]";
	}

	

}

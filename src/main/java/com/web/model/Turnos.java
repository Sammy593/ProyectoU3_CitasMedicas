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
@Table(name="turnos")
public class Turnos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	@Column
	private String dia;
	@Column
	private String Hora;
	@Column
	private boolean estado;
	
	@OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Citas> citas;
	
	//METODO CONSTRUCTOR 
	public Turnos() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Citas> getCitas() {
		return citas;
	}

	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "Turnos [id=" + id + ", dia=" + dia + ", Hora=" + Hora + ", estado=" + estado + ", citas=" + citas + "]";
	}

	
	
}

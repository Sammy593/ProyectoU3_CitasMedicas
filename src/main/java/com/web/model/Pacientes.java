package com.web.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Pacientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String cedula;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column
	private String telefono;
	@Column
	private String sexo;
	@Column
	private String fechanacimiento;
	@Column
	private String fecharegistro;
	@Column
	private String fechamodificacion;
	
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Citas> citas;

	public Pacientes() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(String fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	public List<Citas> getCitas() {
		return citas;
	}

	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "Pacientes [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", sexo=" + sexo + ", fechanacimiento=" + fechanacimiento
				+ ", fecharegistro=" + fecharegistro + ", fechamodificacion=" + fechamodificacion + ", citas=" + citas
				+ "]";
	}


}

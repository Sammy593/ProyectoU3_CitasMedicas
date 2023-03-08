package com.web.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="especialidades")
public class Especialidades {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private Boolean estado;
	
	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Citas> citas;
	
    @OneToMany(mappedBy="especialidad", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<MedicosEspecialidades> me;
	
	public Especialidades() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Citas> getCitas() {
		return citas;
	}

	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}

	public List<MedicosEspecialidades> getMe() {
		return me;
	}

	public void setMe(List<MedicosEspecialidades> me) {
		this.me = me;
	}

	@Override
	public String toString() {
		return "Especialidades [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", citas=" + citas + ", me=" + me + "]";
	}
	
	
	
	
	
	
	
}

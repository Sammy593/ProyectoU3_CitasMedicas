package com.web.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "users")
@Table(name="usuarios")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cli;

	@Column
	private String usuario_cli;
	@Column
	private String password_cli;
	@Column
	private Boolean estado_cli;
	@Column
	private Boolean isadmin_cli;
	
	public Usuario() {
		super();
	}

	public Integer getId_cli() {
		return id_cli;
	}

	public void setId_cli(Integer id_cli) {
		this.id_cli = id_cli;
	}

	public String getUsuario_cli() {
		return usuario_cli;
	}

	public void setUsuario_cli(String usuario_cli) {
		this.usuario_cli = usuario_cli;
	}

	public String getPassword_cli() {
		return password_cli;
	}

	public void setPassword_cli(String password_cli) {
		this.password_cli = password_cli;
	}

	public Boolean getEstado_cli() {
		return estado_cli;
	}

	public void setEstado_cli(Boolean estado_cli) {
		this.estado_cli = estado_cli;
	}

	public Boolean getIsadmin_cli() {
		return isadmin_cli;
	}

	public void setIsadmin_cli(Boolean isadmin_cli) {
		this.isadmin_cli = isadmin_cli;
	}
	
}

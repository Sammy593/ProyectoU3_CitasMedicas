package com.web.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.web.dao.UsuarioDao;
import com.web.idao.UsuarioDaoImpl;
import com.web.model.Usuario;

@ManagedBean(name = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean {

	UsuarioDao usuarioDAO = new UsuarioDaoImpl();
	private String nombreUsuario;
	private String passwordUsuario;

	public String doLoggin() {
		Usuario userValidated = usuarioDAO.getAuth(this.nombreUsuario, this.passwordUsuario);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		String path = (userValidated != null) ? "index" : "login";
		if (userValidated != null) {
			sessionMap.put("userLogged", userValidated);
		}
		return path;

	}

	public List<Usuario> obtenerUsuarios() {
		return usuarioDAO.obtenerUsuarios();
	}

	public String nuevo() {

		Usuario u = new Usuario();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("u", u);
		return "user_nuevo";
	}

	public String guardar(Usuario usuario) {
		usuarioDAO.guardar(usuario);
		return "user_index";
	}

	public String editar(int id) {
		Usuario oUsuario = new Usuario();
		oUsuario = usuarioDAO.buscar(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("usuario", oUsuario);
		return "user_editar";
	}

	public String actualizar(Usuario usuario) {
		usuarioDAO.editar(usuario);
		return "user_index";
	}

	// eliminar un cliente
	public String eliminar(int id) {
		usuarioDAO.eliminar(id);
		return "user_index";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String cancelar() {
		return "usuario";
	}

}

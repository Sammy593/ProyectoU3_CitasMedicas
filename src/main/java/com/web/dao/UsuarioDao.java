package com.web.dao;

import java.util.List;


import com.web.model.Usuario;

public interface UsuarioDao {
	
	public Usuario getAuth(String nombreUsuario, String passwordUsuario);
	
	//Guardar Cliente
		public void guardar(Usuario usuario);
		
		public void editar(Usuario usuario);
		
		public Usuario buscar(int id);
		
		public List<Usuario> obtenerUsuarios();
		
		public void eliminar(int id);
		
		public void cancelar();
}
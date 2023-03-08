package com.web.idao;

import com.web.dao.UsuarioDao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.web.model.Usuario;
import com.web.model.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void trasactional() {
		if (entity.getTransaction().isActive()) {
			entity.getTransaction().commit();
		}
		entity.getTransaction().begin();
	}
	
	@Override
	public Usuario getAuth(String nombreUsuario, String passwordUsuario) {
		Usuario userValited = new Usuario();
		trasactional();
		
		Query q = entity.createQuery("SELECT u FROM users u WHERE u.usuario_cli=:nombreUsuario AND u.password_cli=:passwordUsuario",Usuario.class);
		userValited = (Usuario) q
				  .setParameter("nombreUsuario", nombreUsuario)
				  .setParameter("passwordUsuario", passwordUsuario)
				  .getSingleResult();
		// JPAUtil.shutdown();
		
		return userValited;
	}
	
	// Guardar
	@Override
	public void guardar(Usuario usuario) {
		trasactional();
		entity.persist(usuario);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}
	
	// Actualizar
	@Override
	public void editar(Usuario usuario) {
		trasactional();
		entity.merge(usuario);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}
	
	@Override
	public Usuario buscar(int id) {
		Usuario usuario = new Usuario();
		usuario = entity.find(Usuario.class, id);
		// JPAUtil.shutdown();
		return usuario;
	}
	
	// Listar usuarios
	@Override
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> listUsers = new ArrayList<>();
		Query q = entity.createQuery("SELECT u FROM users u");
		listUsers = q.getResultList();
		return listUsers;
	}
	
	// Eliminar
	@Override
	public void eliminar(int id) {
		Usuario usuario = new Usuario();
		usuario = entity.find(Usuario.class, id);
		
		try {
			trasactional();
			entity.remove(usuario);
			entity.getTransaction().commit();
		}catch(Exception e){
			System.out.print("Error");
		}
	}

	@Override
	public void cancelar() {
	}

	
}
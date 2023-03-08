package com.web.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.dao.TurnosDao;
import com.web.model.JPAUtil;
import com.web.model.Turnos;

public class TurnosDaoImpl implements TurnosDao{

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void guardarTurnos(Turnos turnos) {
		entity.getTransaction().begin();
		entity.persist(turnos);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public void editarTurnos(Turnos turnos) {
		entity.getTransaction().begin();
		entity.merge(turnos);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public Turnos buscarTurnos(int id) {
		Turnos oTurnos = new Turnos();
		oTurnos = entity.find(Turnos.class, id);
		//JPAUtil.shutdown();
		return oTurnos;
	}

	@Override
	public List<Turnos> obtenerTurnos() {
		List<Turnos> listaTurnos = new ArrayList<Turnos>();
		Query q = entity.createQuery("SELECT c from Turnos c");
		listaTurnos = q.getResultList();
		return listaTurnos;
	}

	@Override
	public void eliminarTurnos(int id) {
		Turnos c = new Turnos();
		c = entity.find(Turnos.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
		
	}
	
	@Override
	public List<Turnos> obtenerTurnosActivos() {
		List<Turnos> listaTurnos = new ArrayList<Turnos>();
		Query q = entity.createQuery("SELECT c from Turnos c WHERE c.estado = true");
		listaTurnos = q.getResultList();
		return listaTurnos;
	}

}

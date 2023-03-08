package com.web.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.dao.MedicosDao;
import com.web.model.JPAUtil;
import com.web.model.Medicos;

public class MedicosDaoImpl implements MedicosDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager(); 
	
	@Override
	public void guardarMedico(Medicos medicos) {
		entity.getTransaction().begin();
		entity.persist(medicos);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public void editarMedico(Medicos medicos) {
		entity.getTransaction().begin();
		entity.merge(medicos);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public Medicos buscarMedico(int id) {
		Medicos oMedico = new Medicos();
		oMedico = entity.find(Medicos.class, id);
		//JPAUtil.shutdown();
		return oMedico;
	}

	@Override
	public List<Medicos> obtenerMedicos() {
		List<Medicos> listaMedicos = new ArrayList<Medicos>();
		Query q = entity.createQuery("SELECT c from Medicos c");
		listaMedicos = q.getResultList();
		return listaMedicos;
	}

	@Override
	public void eliminarMedicos(int id) {
		Medicos c = new Medicos();
		c = entity.find(Medicos.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
		
	}

}

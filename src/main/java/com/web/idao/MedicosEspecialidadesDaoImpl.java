package com.web.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.dao.MedicosEspecialidadesDao;
import com.web.model.Especialidades;
import com.web.model.JPAUtil;
import com.web.model.Medicos;
import com.web.model.MedicosEspecialidades;

public class MedicosEspecialidadesDaoImpl implements MedicosEspecialidadesDao {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager(); 
	
	@Override
	public void guardarMedicoEspecialidad(MedicosEspecialidades medicosEspecialidades) {
		entity.getTransaction().begin();
		entity.persist(medicosEspecialidades);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public void editarMedicoEspecialidad(com.web.model.MedicosEspecialidades medicosEspecialidades) {
		entity.getTransaction().begin();
		entity.merge(medicosEspecialidades);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}

	@Override
	public MedicosEspecialidades buscarMedicosEspecialidad(int id) {
		MedicosEspecialidades oMedicoEspecialidad = new MedicosEspecialidades();
		oMedicoEspecialidad = entity.find(MedicosEspecialidades.class, id);
		//JPAUtil.shutdown();
		return oMedicoEspecialidad;
	}

	@Override
	public List<Object[]> obtenerMedicosEspecialidades() {
		    String query = "SELECT me.id, m.nombre, e.nombre, me.estado FROM MedicosEspecialidades me JOIN me.medico m JOIN me.especialidad e";
		    Query q = entity.createQuery(query);
		    List<Object[]> result = q.getResultList();
		    return result;
		
	}
	
	@Override
	public Medicos buscarMedico(int id) {
		Medicos oMedicos = new Medicos();
		oMedicos = entity.find(Medicos.class, id);
		return oMedicos;
	}
	
	@Override
	public Especialidades buscarEspecialidad(int id) {
		Especialidades oEspecialidades = new Especialidades();
		oEspecialidades = entity.find(Especialidades.class, id);
		return oEspecialidades;
	}

	@Override
	public void eliminarMedicosEspecialidades(int id) {
		
		MedicosEspecialidades c = new MedicosEspecialidades();
		c = entity.find(MedicosEspecialidades.class, id);
		c.setEstado(false);
		entity.getTransaction().begin();
		entity.merge(c);
		entity.getTransaction().commit();
		
	}

	

	


}

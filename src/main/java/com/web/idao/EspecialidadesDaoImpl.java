package com.web.idao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.dao.EspecialidadesDao;
import com.web.model.Especialidades;
import com.web.model.JPAUtil;

public class EspecialidadesDaoImpl implements EspecialidadesDao {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardarEspecialidad(Especialidades especialidades) {
		// TODO Auto-generated method stub
		entity.getTransaction().begin();
		entity.persist(especialidades);
		entity.getTransaction().commit();
		
	}

	@Override
	public void editarEspecialidad(Especialidades especialidades) {
		// TODO Auto-generated method stub
		entity.getTransaction().begin();
		entity.merge(especialidades);
		entity.getTransaction().commit();
	}

	@Override
	public Especialidades buscarEspecialidad(int id) {
		// TODO Auto-generated method stub
		
		Especialidades oEspecialidad = new Especialidades();
		oEspecialidad = entity.find(Especialidades.class, id);
		//JPAUtil.shutdown();
		return oEspecialidad;
		
	}

	@Override
	public List<Especialidades> obtenerEspecialidades() {
		// TODO Auto-generated method stub
		List<Especialidades> listaEspecialidades = new ArrayList<Especialidades>();
		//Sentencia JQLI
		Query q = entity.createQuery("SELECT e FROM Especialidades e");
		listaEspecialidades = q.getResultList();
		return listaEspecialidades;
		
	}

	@Override
	public void eliminarEspecialidad(int id) {
		// TODO Auto-generated method stub
		Especialidades c = new Especialidades();
		c = entity.find(Especialidades.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
	public List<Especialidades> listEspecialidades(int idMedico){
		List<Especialidades> listaEspecialidades = new ArrayList<Especialidades>();
		Especialidades especialidad = new Especialidades();
		
		Query q = entity.createNativeQuery("SELECT e.* FROM Especialidades e JOIN Medicos_especialidades c ON e.id = c.IDESPECIALIDAD WHERE c.IDMEDICO = :idMedico").setParameter( "idMedico", idMedico );
		
		List<Object[]> listItems = q.getResultList();
		
		for(Object[] item:listItems) {
			especialidad.setId((Integer) item[0]);
			especialidad.setNombre((String) item[1]);
			especialidad.setDescripcion((String) item[2]);
			especialidad.setEstado((Boolean) item[3]);
			listaEspecialidades.add(especialidad);
		}
		
		System.out.println("Lista: ****** "+listaEspecialidades);
		return listaEspecialidades;
	}
	

}

package com.web.idao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;

import com.web.dao.CitasDao;
import com.web.model.Citas;
import com.web.model.Especialidades;
import com.web.model.JPAUtil;
import com.web.model.Medicos;
import com.web.model.Pacientes;
import com.web.model.Turnos;

public class CitasDaoImpl implements CitasDao{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void guardar(Citas cita) {
		entity.getTransaction().begin();
		entity.persist(cita);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	public void editar(int id) {
		Citas c = new Citas();
		c = entity.find(Citas.class, id);
		c.setESTADO(false);
		entity.getTransaction().begin();
		entity.merge(c);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	public Citas buscarCita(int id) {
		Citas oCitas = new Citas();
		oCitas = entity.find(Citas.class, id);
		//JPAUtil.shutdown();
		return oCitas;
	}

	public Medicos buscarMedico(int id) {
		Medicos oMedicos = new Medicos();
		oMedicos = entity.find(Medicos.class, id);
		return oMedicos;
	}

	public Pacientes buscarPaciente(int id) {
		Pacientes oPacientes = new Pacientes();
		oPacientes = entity.find(Pacientes.class, id);
		return oPacientes;
	}
	
	public Turnos buscarTurno(int id) {
		Turnos oTurnos = new Turnos();
		oTurnos = entity.find(Turnos.class, id);
		return oTurnos;
	}

	public Especialidades buscarEspecialidad(int id) {
		Especialidades oEspecialidades = new Especialidades();
		oEspecialidades = entity.find(Especialidades.class, id);
		return oEspecialidades;
	}


	public List<Citas> obtenerCitas() {
		List<Citas> listaCitas = new ArrayList<Citas>();
		Query q = entity.createQuery("SELECT c FROM Citas c");
		listaCitas = q.getResultList();
		return listaCitas;
	}

	public void eliminar(int id) {
		Citas c = new Citas();
		c = entity.find(Citas.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
	
}

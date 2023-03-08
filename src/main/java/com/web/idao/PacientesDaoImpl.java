package com.web.idao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.web.dao.PacientesDao;
import com.web.model.JPAUtil;
import com.web.model.Pacientes;

public class PacientesDaoImpl implements PacientesDao{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void guardarPaciente(Pacientes pacientes) {
		entity.getTransaction().begin();
		
		LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crear un formateador de fecha y hora para el formato deseado
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
		pacientes.setFecharegistro((fechaHoraActual.format(formateador)));
		entity.persist(pacientes);
		entity.getTransaction().commit();
	}

	@Override
	public void editarPaciente(Pacientes pacientes) {
		entity.getTransaction().begin();
		
		LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crear un formateador de fecha y hora para el formato deseado
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
		pacientes.setFechamodificacion((fechaHoraActual.format(formateador)));
		entity.merge(pacientes);
		entity.getTransaction().commit();
	}

	@Override
	public Pacientes buscarPaciente(int id) {
		Pacientes oPaciente = new Pacientes();
		oPaciente = entity.find(Pacientes.class, id);
		//JPAUtil.shutdown();
		return oPaciente;
		
	}

	@Override
	public List<Pacientes> obtenerPacientes() {
		List<Pacientes> listaPacientes = new ArrayList<Pacientes>();
		//Sentencia JQLI
		Query q = entity.createQuery("SELECT p FROM Pacientes p");
		listaPacientes = q.getResultList();
		return listaPacientes;
	}

	@Override
	public void eliminarPaciente(int id) {
		Pacientes c = new Pacientes();
		c = entity.find(Pacientes.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

}

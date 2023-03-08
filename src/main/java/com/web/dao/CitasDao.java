package com.web.dao;

import java.util.List;

import com.web.model.Citas;
import com.web.model.Especialidades;
import com.web.model.Medicos;
import com.web.model.Pacientes;
import com.web.model.Turnos;

public interface CitasDao {

	//guardar citas
	public void guardar(Citas citas);
	//Editar
	public void editar(int id);
	//Buscar citas
	public Citas buscarCita(int id);
	//Buscar Medico
	public Medicos buscarMedico(int id);
	//Buscar paciente
	public Pacientes buscarPaciente(int id);
	//Buscar especialidad
	public Especialidades buscarEspecialidad(int id);
	
	public Turnos buscarTurno(int id);
	
	//Obtener todos los citass
	public List<Citas> obtenerCitas();
	//Eliminar
	public void eliminar(int id);
}

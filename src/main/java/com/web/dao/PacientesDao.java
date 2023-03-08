package com.web.dao;

import java.util.List;

import com.web.model.Pacientes;

public interface PacientesDao {
	
	
	public void guardarPaciente(Pacientes pacientes);
	
	public void editarPaciente (Pacientes pacientes);
	
	public Pacientes buscarPaciente (int id);
	
	public List<Pacientes> obtenerPacientes();
	
	public void eliminarPaciente(int id);

}

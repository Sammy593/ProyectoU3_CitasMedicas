package com.web.dao;

import java.util.List;

import com.web.model.Especialidades;

public interface EspecialidadesDao {
	
	public void guardarEspecialidad(Especialidades especialidades);
	
	public void editarEspecialidad (Especialidades especialidades);
	
	public Especialidades buscarEspecialidad (int id);
	
	public List<Especialidades> obtenerEspecialidades();
	
	public void eliminarEspecialidad(int id);
	
	
	public List<Especialidades> listEspecialidades(int idMedico);

}

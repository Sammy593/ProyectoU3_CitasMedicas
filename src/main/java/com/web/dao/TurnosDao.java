package com.web.dao;

import java.util.List;

import com.web.model.Turnos;

public interface TurnosDao {

	
	public void guardarTurnos(Turnos turnos);
	
	public void editarTurnos (Turnos turnos);
	
	public Turnos buscarTurnos (int id);
	
	public List<Turnos> obtenerTurnos();
	
	public void eliminarTurnos(int id);
	
	public List<Turnos> obtenerTurnosActivos();
}

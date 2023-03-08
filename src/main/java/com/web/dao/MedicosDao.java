package com.web.dao;

import java.util.List;

import com.web.model.Medicos;

public interface MedicosDao {

		//guardar medicos
		public void guardarMedico(Medicos medicos);
		//Editar
		public void editarMedico(Medicos medicos);
		//Buscar medicos
		public Medicos buscarMedico(int id);
		//Obtener todos los medicos
		public List<Medicos> obtenerMedicos();
		//Eliminar
		public void eliminarMedicos(int id);
	
}

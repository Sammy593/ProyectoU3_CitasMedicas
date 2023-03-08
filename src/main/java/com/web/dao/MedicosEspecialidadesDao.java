package com.web.dao;

import java.util.List;

import com.web.model.Especialidades;
import com.web.model.Medicos;
import com.web.model.MedicosEspecialidades;

public interface MedicosEspecialidadesDao {

			//guardar medicos
			public void guardarMedicoEspecialidad(MedicosEspecialidades medicosEspecialidades);
			//Editar
			public void editarMedicoEspecialidad(MedicosEspecialidades medicosEspecialidades);
			//Buscar medicos
			public MedicosEspecialidades buscarMedicosEspecialidad(int id);
			//Obtener todos los medicos
			public List<Object[]> obtenerMedicosEspecialidades();
			//Eliminar
			public void eliminarMedicosEspecialidades(int id);
			
			public Medicos buscarMedico(int id);
			
			public Especialidades buscarEspecialidad(int id);
}

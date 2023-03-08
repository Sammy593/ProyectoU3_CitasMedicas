package com.web.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.EspecialidadesDao;
import com.web.idao.EspecialidadesDaoImpl;
import com.web.model.Especialidades;


@ManagedBean(name="especialidadesManagedBean")
@RequestScoped
public class EspecialidadesManagedBean {

	EspecialidadesDao especialidadDAO = new EspecialidadesDaoImpl();
	
	//Prueba para mostrar una lista de Especialidades estática
	public List<Especialidades> obtenerEspecialidades(){
		
		return especialidadDAO.obtenerEspecialidades();
	}
	
	
	public String editar (int id) {
		//Función para editar el Especialidades
		Especialidades oEspecialidad = new Especialidades();
		oEspecialidad = especialidadDAO.buscarEspecialidad(id);
		System.out.println(oEspecialidad);
		//Crear una colección de tipo map
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Se pasan los parametros Especialidadess
		sessionMap.put("especialidades", oEspecialidad);
		return "especial_editar.xhtml";
	}
	
	public String actualizar (Especialidades especialidad) {
		especialidadDAO.editarEspecialidad(especialidad);
		
		return "especial_index.xhtml";
	}
	
	public String eliminar (int id) {
		especialidadDAO.eliminarEspecialidad(id);
		return "especial_index.xhtml";
	}
	
	public String nuevo() {
		Especialidades oEspecialidad = new Especialidades();
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Se pasan los parametros Especialidadess
		sessionMap.put("especialidades", oEspecialidad); 
		return "especial_nuevo.xhtml";
	}
	
	public String guardar(Especialidades Especialidades) {
		especialidadDAO.guardarEspecialidad(Especialidades);
		return "especial_index.xhtml";
	}
	
	
}

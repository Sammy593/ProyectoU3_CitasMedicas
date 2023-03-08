package com.web.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.PacientesDao;
import com.web.idao.PacientesDaoImpl;
import com.web.model.Pacientes;


@ManagedBean(name="pacientesManagedBean")
@RequestScoped
public class PacientesManagedBean {

	PacientesDao pacienteDAO = new PacientesDaoImpl();
	
	//Prueba para mostrar una lista de Pacientes estática
		public List<Pacientes> obtenerPacientes(){
			return pacienteDAO.obtenerPacientes();
		}
		
		
		public String editar (int id) {
			//Función para editar el Pacientes
			Pacientes opaciente = new Pacientes();
			opaciente = pacienteDAO.buscarPaciente(id);
			System.out.println(opaciente);
			//Crear una colección de tipo map
			Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			//Se pasan los parametros Pacientess
			sessionMap.put("pacientes", opaciente);
			return "paciente_editar.xhtml";
		}
		
		public String actualizar (Pacientes paciente) {
			pacienteDAO.editarPaciente(paciente);
			
			return "paciente_index.xhtml";
		}
		
		public String eliminar (int id) {
			pacienteDAO.eliminarPaciente(id);
			return "paciente_index.xhtml";
		}
		
		public String nuevo() {
			Pacientes opaciente = new Pacientes();
			Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			//Se pasan los parametros Pacientess
			sessionMap.put("pacientes", opaciente); 
			return "paciente_nuevo.xhtml";
		}
		
		public String guardar(Pacientes Pacientes) {
			pacienteDAO.guardarPaciente(Pacientes);
			return "paciente_index.xhtml";
		}
		
	
}

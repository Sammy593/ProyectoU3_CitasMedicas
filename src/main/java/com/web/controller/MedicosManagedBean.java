package com.web.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.MedicosDao;
import com.web.idao.MedicosDaoImpl;
import com.web.model.Medicos;

@ManagedBean(name="medicosManagedBean")
@RequestScoped
public class MedicosManagedBean {

	MedicosDao medicosDAO = new MedicosDaoImpl();
	
	public List<Medicos> obtenerMedicos(){
		return medicosDAO.obtenerMedicos();
	}
	
	public String editar(int id) {
		Medicos oMedicos = new Medicos();
		oMedicos = medicosDAO.buscarMedico(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("medicos", oMedicos);
		return "med_editar";
	}
	
	public String actualizar(Medicos medicos) {
		medicosDAO.editarMedico(medicos);
		return "med_index";
	}
	
	public String eliminar(int id) {
		medicosDAO.eliminarMedicos(id);
		return "med_index";
	}
	
	public String nuevo() {
		Medicos oMedicos = new Medicos();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("medicos", oMedicos);
		return "med_nuevo";
	}
	
	public String guardar(Medicos cliente) {
		medicosDAO.guardarMedico(cliente);
		return "med_index";
	}
	
	
}

package com.web.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.TurnosDao;
import com.web.idao.TurnosDaoImpl;
import com.web.model.Turnos;

@ManagedBean(name="turnosManagedBean")
@RequestScoped
public class TurnosManagedBean {

TurnosDao turnosDAO = new TurnosDaoImpl();
	
	public List<Turnos> obtenerTurnos(){
		return turnosDAO.obtenerTurnos();
	}
	
	public String editar(int id) {
		Turnos oTurnos = new Turnos();
		oTurnos = turnosDAO.buscarTurnos(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("turnos", oTurnos);
		return "turn_editar";
	}
	
	
	public String actualizar(Turnos turnos) {
		turnosDAO.editarTurnos(turnos);
		return "turn_index";
	}
	
	public void cambiarEstado(Turnos turno) {
	    if (turno.isEstado()) {
	        turno.setEstado(false);
	    } else {
	        turno.setEstado(true);
	    }
	    turnosDAO.editarTurnos(turno); // Actualiza el estado en la base de datos
	}
	
	public String eliminar(int id) {
		turnosDAO.eliminarTurnos(id);
		return "turn_index";
	}
	
	public String nuevo() {
		Turnos oTurnos = new Turnos();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("turnos", oTurnos);
		return "turn_nuevo";
	}
	
	public String guardar(Turnos turnos) {
		turnosDAO.guardarTurnos(turnos);
		return "turn_index";
	}
	
}

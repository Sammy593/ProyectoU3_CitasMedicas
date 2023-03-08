package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.web.dao.CitasDao;
import com.web.dao.EspecialidadesDao;
import com.web.dao.MedicosDao;
import com.web.dao.PacientesDao;
import com.web.dao.TurnosDao;
import com.web.idao.CitasDaoImpl;
import com.web.idao.EspecialidadesDaoImpl;
import com.web.idao.MedicosDaoImpl;
import com.web.idao.PacientesDaoImpl;
import com.web.idao.TurnosDaoImpl;
import com.web.model.Citas;
import com.web.model.Especialidades;
import com.web.model.Medicos;
import com.web.model.Pacientes;
import com.web.model.Turnos;

@ManagedBean(name="citasManagedBean")
@RequestScoped
public class CitasManagedBean {
	CitasDao citasDAO = new CitasDaoImpl();
	
	private List<SelectItem> selectItemsMedicos;
	private List<SelectItem> selectItemsPacientes;
	private List<SelectItem> selectItemsEspecialidades;
	private List<SelectItem> selectItemsTurnos;
	
	private int idMedico;
	private int idEspecialidad;
	
	
	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public List<Citas> obtenerCitas(){
		return citasDAO.obtenerCitas();
	}
	
	public String cancelar(int id) {
		citasDAO.editar(id);
		return "citas_index";
	}
	
	public String eliminar(int id) {
		citasDAO.eliminar(id);
		return "citas_index";
	}
	
	public String nuevo() {
		Citas oCitas = new Citas();
		Medicos oMedicos = new Medicos();
		Pacientes oPacientes = new Pacientes();
		Especialidades oEspecialidades = new Especialidades();
		Turnos oTurnos = new Turnos();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		System.out.println(oCitas);
		//List<SelectItem> items = this.getSelectItemsMedicos();
		sessionMap.put("citas", oCitas);
		sessionMap.put("medicos", oMedicos);
		sessionMap.put("pacientes", oPacientes);
		sessionMap.put("especialidades", oEspecialidades);
		sessionMap.put("turnos", oTurnos);
		//sessionMap.put("itemsMedicos", items);
		return "citas_nuevo";
	}
	
	public String guardar(Citas citas, Especialidades especialidad, Pacientes pacientes, Turnos turnos) {
		System.out.println(idMedico);
		System.out.println(idEspecialidad);
		Medicos oMedico = citasDAO.buscarMedico(idMedico);
		Pacientes oPaciente = citasDAO.buscarPaciente(pacientes.getId());
		Especialidades oEspecialidad = citasDAO.buscarEspecialidad(especialidad.getId());
		Turnos oTurno = citasDAO.buscarTurno(turnos.getId());
		
		citas.setMedico(oMedico);
		citas.setPaciente(oPaciente);
		citas.setEspecialidad(oEspecialidad);
		citas.setTurno(oTurno);
		citas.setESTADO(true);
		citasDAO.guardar(citas);
		
		TurnosManagedBean turnoBean = new TurnosManagedBean();
		turnoBean.cambiarEstado(oTurno);
		
		return "citas_index";
	}
	
	public List<SelectItem> getSelectItemsTurnos(){
		this.selectItemsTurnos = new ArrayList<SelectItem>();
		TurnosDao turnosDAO = new TurnosDaoImpl();
		List<Turnos> turnos = turnosDAO.obtenerTurnosActivos();
		
		selectItemsTurnos.clear();
		
		for(Turnos tur:turnos) {
			SelectItem selectItem = new SelectItem(tur.getId(), ""+tur.getDia()+" "+tur.getHora()+"");
			this.selectItemsTurnos.add(selectItem);
		}
		
		return selectItemsTurnos;
	}
	public List<SelectItem> setSelectItemsTurnos(List<SelectItem> selectItemsTurnos){
		return this.selectItemsTurnos = selectItemsTurnos;
	}
	
	public List<SelectItem> getSelectItemsMedicos(){
		this.selectItemsMedicos = new ArrayList<SelectItem>();
		MedicosDao medicosDAO = new MedicosDaoImpl();
		List<Medicos> medicos = medicosDAO.obtenerMedicos();
		
		selectItemsMedicos.clear();
		
		for(Medicos med:medicos) {
			SelectItem selectItem = new SelectItem(med.getId(), med.getNombre());
			this.selectItemsMedicos.add(selectItem);
		}
		
		return selectItemsMedicos;
	}
	public List<SelectItem> setSelectItemsMedicos(List<SelectItem> selectItemsMedicos){
		return this.selectItemsMedicos = selectItemsMedicos;
	}
	

	
	public List<SelectItem> getSelectItemsPacientes(){
		this.selectItemsPacientes = new ArrayList<SelectItem>();
		PacientesDao pacientesDAO = new PacientesDaoImpl();
		List<Pacientes> pacientes = pacientesDAO.obtenerPacientes();
		
		selectItemsPacientes.clear();
		
		for(Pacientes pac:pacientes) {
			SelectItem selectItem = new SelectItem(pac.getId(), pac.getNombre());
			this.selectItemsPacientes.add(selectItem);
		}
		
		return selectItemsPacientes;
	}
	public List<SelectItem> setSelectItemsPacientes(List<SelectItem> selectItemsPacientes){
		return this.selectItemsPacientes = selectItemsPacientes;
	}
	
	public List<SelectItem> getSelectItemsEspecialidades(){
		this.selectItemsEspecialidades = new ArrayList<SelectItem>();
		EspecialidadesDao especialidadesDAO = new EspecialidadesDaoImpl();
		System.out.println(idMedico);
		List<Especialidades> especialidades = especialidadesDAO.listEspecialidades(idMedico);
		
		selectItemsEspecialidades.clear();
		
		for(Especialidades especi:especialidades) {
			SelectItem selectItem = new SelectItem(especi.getId(), especi.getNombre());
			this.selectItemsEspecialidades.add(selectItem);
		}
		
		return selectItemsEspecialidades;
	}
	public List<SelectItem> setSelectItemsEspecialidades(List<SelectItem> selectItemsEspecialidades){
		return this.selectItemsEspecialidades = selectItemsEspecialidades;
	}
	
	

}

package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.web.dao.EspecialidadesDao;
import com.web.dao.MedicosDao;
import com.web.dao.MedicosEspecialidadesDao;
import com.web.idao.EspecialidadesDaoImpl;
import com.web.idao.MedicosDaoImpl;
import com.web.idao.MedicosEspecialidadesDaoImpl;
import com.web.model.Especialidades;
import com.web.model.Medicos;
import com.web.model.MedicosEspecialidades;

@ManagedBean(name = "medicosEspecialManagedBean")
@RequestScoped
public class MedicosEspecialManagedBean {

	MedicosEspecialidadesDao medicosespecialDAO = new MedicosEspecialidadesDaoImpl();

	private List<SelectItem> selectItemsMedicos;
	private List<SelectItem> selectItemsEspecialidades;

	public List<SelectItem> getSelectItemsMedicos() {
		this.selectItemsMedicos = new ArrayList<SelectItem>();
		MedicosDao medicosDAO = new MedicosDaoImpl();
		List<Medicos> medicos = medicosDAO.obtenerMedicos();

		selectItemsMedicos.clear();

		for (Medicos med : medicos) {
			SelectItem selectItem = new SelectItem(med.getId(), med.getNombre());
			this.selectItemsMedicos.add(selectItem);
		}

		return selectItemsMedicos;
	}
	
	public List<SelectItem> getSelectItemsEspecialidades() {
		this.selectItemsEspecialidades = new ArrayList<SelectItem>();
		EspecialidadesDao especialidadesDAO = new EspecialidadesDaoImpl();
		List<Especialidades> especialidades = especialidadesDAO.obtenerEspecialidades();

		selectItemsMedicos.clear();

		for (Especialidades esp : especialidades) {
			SelectItem selectItem = new SelectItem(esp.getId(), esp.getNombre());
			this.selectItemsMedicos.add(selectItem);
		}

		return selectItemsMedicos;
	}
	

	public List<SelectItem> setSelectItemsMedicos(List<SelectItem> selectItemsMedicos) {
		return this.selectItemsMedicos = selectItemsMedicos;
	}

	public List<Object[]> obtenerMedicos() {
		return medicosespecialDAO.obtenerMedicosEspecialidades();
	}

	public String editar(int id) {
		MedicosEspecialidades oMedicosEsp = new MedicosEspecialidades();
		oMedicosEsp = medicosespecialDAO.buscarMedicosEspecialidad(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("medicos_especialidades", oMedicosEsp);
		return "medespec_editar";
	}

	public String actualizar(MedicosEspecialidades medicosespecialidades) {
		medicosespecialDAO.editarMedicoEspecialidad(medicosespecialidades);
		return "medespec_index";
	}

	public String eliminar(int id) {
		medicosespecialDAO.eliminarMedicosEspecialidades(id);
		return "medespec_index";
	}
	
	public void cambiarEstado(MedicosEspecialidades medicoespecialidad) {
	    if (medicoespecialidad.isEstado()) {
	        medicoespecialidad.setEstado(false);
	    } else {
	        medicoespecialidad.setEstado(true);
	    }
	    medicosespecialDAO.editarMedicoEspecialidad(medicoespecialidad); // Actualiza el estado en la base de datos
	}

	public String nuevo() {
		MedicosEspecialidades oMedicosEspecial = new MedicosEspecialidades();
		Medicos oMedico = new Medicos();
		Especialidades oEspecialidad = new Especialidades();

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("medicosespecialidades", oMedicosEspecial);
		sessionMap.put("medico", oMedico);
		sessionMap.put("especialidad", oEspecialidad);
		return "medespec_nuevo";
	}

	public String guardar(MedicosEspecialidades medicosespecialidades, Medicos medico, Especialidades especialidad) {
		Medicos oMedico = medicosespecialDAO.buscarMedico(medico.getId());
		Especialidades oEspecialidad = medicosespecialDAO.buscarEspecialidad(especialidad.getId());
		medicosespecialidades.setMedico(oMedico);
		medicosespecialidades.setEspecialidad(oEspecialidad);
		medicosespecialidades.setEstado(true);
		medicosespecialDAO.guardarMedicoEspecialidad(medicosespecialidades);
		return "medespec_index";
	}

}

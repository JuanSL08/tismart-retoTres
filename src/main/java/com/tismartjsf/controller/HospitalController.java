package com.tismartjsf.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.tismartjsf.dao.CondicionDAO;
import com.tismartjsf.dao.DistritoDAO;
import com.tismartjsf.dao.GerenteDAO;
import com.tismartjsf.dao.HospitalDAO;
import com.tismartjsf.dao.SedeDAO;
import com.tismartjsf.model.Condicion;
import com.tismartjsf.model.Distrito;
import com.tismartjsf.model.Gerente;
import com.tismartjsf.model.Hospital;
import com.tismartjsf.model.Sede;

@ManagedBean(name="hospitalController")
@RequestScoped
public class HospitalController {
	
	private HospitalDAO hospitalDAO = new HospitalDAO();
	private SedeDAO sedeDAO = new SedeDAO();
	private DistritoDAO distritoDAO = new DistritoDAO();
	private GerenteDAO gerenteDAO = new GerenteDAO();
	private CondicionDAO condicionDAO = new CondicionDAO();
	
	public void buscarPersonalizado() throws IOException {
		addGenerics();
		
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listHospitalesSearch.xhtml");
	}
	
	public void buscarEdit() throws IOException {
		addGenerics();
		
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listHospitalesEdit.xhtml");
	}
	
	public void buscarDelete() throws IOException {
		addGenerics();
		
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listHospitalesDelete.xhtml");
	}
	
	public void nuevo() throws IOException {
		Hospital hospital = new Hospital();
		hospital.setSede(new Sede());
		hospital.setDistrito(new Distrito());
		hospital.setGerente(new Gerente());
		hospital.setCondicion(new Condicion());
		hospital.setFechaRegistro(new Date());
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("hospital", hospital);
		sessionMap.put("sedesLista", sedeDAO.buscarTodas());
		sessionMap.put("distritosLista", distritoDAO.buscarTodos());
		sessionMap.put("gerentesLista", gerenteDAO.buscarTodos());
		sessionMap.put("condicionesLista", condicionDAO.buscarTodas());
		
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect("nuevo.xhtml");
	}
	
	public void guardar(Hospital hospital) throws IOException {
		hospitalDAO.guardar(hospital);
		
		addGenerics();
		
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/hospitales_jsf_jpa/faces/listHospitalesSearch.xhtml");
	}
	
	public void editar(Integer id) throws IOException {
		Hospital hospital = new Hospital();
		hospital = hospitalDAO.buscar(id);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("hospital", hospital);
		sessionMap.put("sedesLista", sedeDAO.buscarTodas());
		sessionMap.put("distritosLista", distritoDAO.buscarTodos());
		sessionMap.put("gerentesLista", gerenteDAO.buscarTodos());
		sessionMap.put("condicionesLista", condicionDAO.buscarTodas());
		
		FacesContext.getCurrentInstance().getExternalContext()
						.redirect("editar.xhtml");
	}
	
	public void actualizar(Hospital hospital) throws IOException {
		hospitalDAO.editar(hospital);
		
		addGenerics();
		
		FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/hospitales_jsf_jpa/faces/listHospitalesSearch.xhtml");
	}
	
	public void eliminar(Integer id) throws IOException {
		hospitalDAO.eliminar(id);

		addGenerics();
		
		FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/hospitales_jsf_jpa/faces/listHospitalesDelete.xhtml");
	}
	
	public void buscarPorNombre(String txtNombre) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("hospitalesSearch", hospitalDAO.buscarPorNombre(txtNombre));
		int numHospitales = hospitalDAO.buscarPorNombre(txtNombre).size();
		sessionMap.put("numHospitales", numHospitales);
		System.out.println(hospitalDAO.buscarPorNombre(txtNombre));
		sessionMap.put("numberSede", 0);
	}
	
	public void buscarPorSede(int numberSede) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("hospitalesSearch", hospitalDAO.buscarPorSede(numberSede));
		int numHospitales = hospitalDAO.buscarPorSede(numberSede).size();
		sessionMap.put("numHospitales", numHospitales);
		System.out.println(hospitalDAO.buscarPorSede(numberSede));
		sessionMap.put("txtNombre", "");
	}
	
	public void addGenerics() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int numHospitales = hospitalDAO.buscarTodos().size();
		sessionMap.put("numHospitales", numHospitales);
		sessionMap.put("txtNombre", "");
		sessionMap.put("numberSede", 0);
		sessionMap.put("sedesLista", sedeDAO.buscarTodas());
		sessionMap.put("hospitalesSearch", hospitalDAO.buscarTodos());
	}
	
}

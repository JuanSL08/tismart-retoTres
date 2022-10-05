package com.tismartjsf.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.tismartjsf.dao.GerenteDAO;
import com.tismartjsf.model.Gerente;

@ManagedBean(name="gerenteBean")
@RequestScoped
public class GerenteBean {

	private GerenteDAO gerenteDAO = new GerenteDAO();
	
	public List<Gerente> buscarTodos() {
		return this.gerenteDAO.buscarTodos();
	}
	
	public String editar(Integer id) {
		Gerente gerente = new Gerente();
		gerente = this.gerenteDAO.buscar(id);
		System.out.println(gerente);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("gerente", gerente);
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Gerente gerente) {
		gerente.setFechaRegistro(new Date());
		gerenteDAO.editar(gerente);
		return "/faces/index.xhtml";
	}
	
	public String eliminar(Integer id) {
		gerenteDAO.eliminar(id);
		System.out.println("Cliente eliminado, con id: "+id);
		return "/faces/index.xhtml";
	}
	
	public String nuevo() {
		Gerente gerente = new Gerente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("gerente", gerente);
		return "/faces/nuevo.xhtml";
	}
	
	public String guardar(Gerente gerente) {
		gerente.setFechaRegistro(new Date());
		gerenteDAO.guardar(gerente);
		return "/faces/index.xhtml";
	}
}

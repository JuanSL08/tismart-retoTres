package com.tismartjsf.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.tismartjsf.model.Hospital;
import com.tismartjsf.model.JPAUtil;

public class HospitalDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

	public void guardar(Hospital hospital) {
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.INSERT_HOSPITAL");
		procedureQuery.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_ANTIGUEDAD", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_AREA", Double.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_FECHAREGISTRO", Date.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDDISTRITO", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDSEDE", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDGERENTE", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDCONDICION", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_MENSAJE", String.class, ParameterMode.OUT);
		
		entity.getTransaction().begin();
		procedureQuery.setParameter("P_NOMBRE", hospital.getNombre());
		procedureQuery.setParameter("P_ANTIGUEDAD", hospital.getAntiguedad());
		procedureQuery.setParameter("P_AREA", hospital.getArea());
		procedureQuery.setParameter("P_FECHAREGISTRO", hospital.getFechaRegistro());
		procedureQuery.setParameter("P_IDDISTRITO", hospital.getDistrito().getIdDistrito());
		procedureQuery.setParameter("P_IDSEDE", hospital.getSede().getIdSede());
		procedureQuery.setParameter("P_IDGERENTE", hospital.getGerente().getIdGerente());
		procedureQuery.setParameter("P_IDCONDICION", hospital.getCondicion().getIdCondicion());
		procedureQuery.execute();
		String mensaje = (String) procedureQuery.getOutputParameterValue("P_MENSAJE");
		System.out.println(mensaje);
		entity.getTransaction().commit();
	}

	public void editar(Hospital hospital) {
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.UPDATE_HOSPITAL");
		procedureQuery.registerStoredProcedureParameter("P_IDHOSPITAL", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_ANTIGUEDAD", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_AREA", Double.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_FECHAREGISTRO", Date.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDDISTRITO", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDSEDE", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDGERENTE", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_IDCONDICION", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_MENSAJE", String.class, ParameterMode.OUT);
		
		entity.getTransaction().begin();
		procedureQuery.setParameter("P_IDHOSPITAL", hospital.getIdHospital());
		procedureQuery.setParameter("P_NOMBRE", hospital.getNombre());
		procedureQuery.setParameter("P_ANTIGUEDAD", hospital.getAntiguedad());
		procedureQuery.setParameter("P_AREA", hospital.getArea());
		procedureQuery.setParameter("P_FECHAREGISTRO", hospital.getFechaRegistro());
		procedureQuery.setParameter("P_IDDISTRITO", hospital.getDistrito().getIdDistrito());
		procedureQuery.setParameter("P_IDSEDE", hospital.getSede().getIdSede());
		procedureQuery.setParameter("P_IDGERENTE", hospital.getGerente().getIdGerente());
		procedureQuery.setParameter("P_IDCONDICION", hospital.getCondicion().getIdCondicion());
		procedureQuery.execute();
		String mensaje = (String) procedureQuery.getOutputParameterValue("P_MENSAJE");
		System.out.println(mensaje);
		entity.getTransaction().commit();
	}

	public Hospital buscar(int id) {
		entity.getTransaction().begin();
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.HOSPITAL_FIND_BY_ID", Hospital.class);
		procedureQuery.registerStoredProcedureParameter("P_IDHOSPITAL", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_CURSOR_HOSPITAL", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.setParameter("P_IDHOSPITAL", id);
		procedureQuery.execute();
		
		List<Hospital> lista = procedureQuery.getResultList();
		Hospital hospital = lista.get(0);
		return hospital;
	}

	public void eliminar(Integer id) {
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.DELETE_HOSPITAL");
		procedureQuery.registerStoredProcedureParameter("P_IDHOSPITAL", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_MENSAJE", String.class, ParameterMode.OUT);
		
		entity.getTransaction().begin();
		procedureQuery.setParameter("P_IDHOSPITAL", id);
		procedureQuery.execute();
		String mensaje = (String) procedureQuery.getOutputParameterValue("P_MENSAJE");
		System.out.println(mensaje);
		entity.getTransaction().commit();
	}

	public List<Hospital> buscarTodos() {
		entity.getTransaction().begin();
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.HOSPITAL_FIND_ALL", Hospital.class);
		procedureQuery.registerStoredProcedureParameter("P_CURSOR_HOSPITALES", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.execute();
		
		List<Hospital> listahospitales = procedureQuery.getResultList();
		entity.getTransaction().commit();
		return listahospitales;
	}
	
	public List<Hospital> buscarPorNombre(String txtNombre) {
		entity.getTransaction().begin();
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.HOSPITAL_FIND_BY_NOMBRE", Hospital.class);
		procedureQuery.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_CURSOR_HOSPITALES_NOMBRE", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.setParameter("P_NOMBRE", txtNombre);
		procedureQuery.execute();
		
		List<Hospital> listahospitales = procedureQuery.getResultList();
		entity.getTransaction().commit();
		return listahospitales;
	}
	
	public List<Hospital> buscarPorSede(int numberSede) {
		entity.getTransaction().begin();
		StoredProcedureQuery procedureQuery = entity.createStoredProcedureQuery("PKG_CRUD_HOSPITAL.HOSPITAL_FIND_BY_SEDE", Hospital.class);
		procedureQuery.registerStoredProcedureParameter("P_IDSEDE", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("P_CURSOR_HOSPITALES_SEDE", void.class, ParameterMode.REF_CURSOR);
		procedureQuery.setParameter("P_IDSEDE", numberSede);
		procedureQuery.execute();
		
		List<Hospital> listahospitales = procedureQuery.getResultList();
		entity.getTransaction().commit();
		return listahospitales;
	}
	
}

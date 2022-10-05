package com.tismartjsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tismartjsf.model.Distrito;
import com.tismartjsf.model.JPAUtil;

public class DistritoDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public List<Distrito> buscarTodos() {
		List<Distrito> listaDistritos = new ArrayList<>();
		Query q = entity.createQuery("SELECT d FROM Distrito d");
		listaDistritos = q.getResultList();
		return listaDistritos;
	}
}

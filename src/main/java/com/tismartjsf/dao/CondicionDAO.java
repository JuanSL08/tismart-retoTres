package com.tismartjsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tismartjsf.model.Condicion;
import com.tismartjsf.model.JPAUtil;

public class CondicionDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public List<Condicion> buscarTodas() {
		List<Condicion> listaCondiciones = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Condicion c");
		listaCondiciones = q.getResultList();
		return listaCondiciones;
	}
	
}

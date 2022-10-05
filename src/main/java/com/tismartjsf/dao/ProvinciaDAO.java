package com.tismartjsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tismartjsf.model.JPAUtil;
import com.tismartjsf.model.Provincia;

public class ProvinciaDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public List<Provincia> buscarTodos() {
		List<Provincia> listaProvincias = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM Provincia p");
		listaProvincias = q.getResultList();
		return listaProvincias;
	}
	
}

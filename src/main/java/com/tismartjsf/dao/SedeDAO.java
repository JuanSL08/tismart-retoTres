package com.tismartjsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tismartjsf.model.JPAUtil;
import com.tismartjsf.model.Sede;

public class SedeDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public List<Sede> buscarTodas() {
		List<Sede> listaSedes = new ArrayList<>();
		Query q = entity.createQuery("SELECT s FROM Sede s");
		listaSedes = q.getResultList();
		return listaSedes;
	}
}

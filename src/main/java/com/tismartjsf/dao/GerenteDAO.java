package com.tismartjsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tismartjsf.model.Gerente;
import com.tismartjsf.model.JPAUtil;

public class GerenteDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

	public void guardar(Gerente gerente) {
		entity.getTransaction().begin();
		entity.persist(gerente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	public void editar(Gerente gerente) {
		entity.getTransaction().begin();
		entity.merge(gerente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	public Gerente buscar(int id) {
		Gerente gerente = new Gerente();
		gerente = entity.find(Gerente.class, id);
		//JPAUtil.shutdown();
		return gerente;
	}

	public List<Gerente> buscarTodos() {
		List<Gerente> listaGerentes = new ArrayList<>();
		Query q = entity.createQuery("SELECT g FROM Gerente g");
		listaGerentes = q.getResultList();
		//JPAUtil.shutdown();
		return listaGerentes;
	}

	public void eliminar(Integer id) {
		Gerente gerente = new Gerente();
		gerente = entity.find(Gerente.class, id);
		entity.getTransaction().begin();
		entity.remove(gerente);
		entity.getTransaction().commit();
	}
}

package com.gruppo.isc.extranet.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.TipoAvanzamento;

@Repository
public class TipoAvanzamentoRepoImp implements TipoAvanzamentoRepo
{
	@Autowired
	EntityManager em;
	
	@Override
	public List getAllTipiAvanzamento() {
		List<TipoAvanzamento> tipi = new ArrayList<TipoAvanzamento>();
		Query q = em.createQuery("select t from TipoAvanzamento t");
		tipi = q.getResultList();
		return tipi;
	}

}

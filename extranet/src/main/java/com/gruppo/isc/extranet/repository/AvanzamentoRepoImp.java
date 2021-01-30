package com.gruppo.isc.extranet.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Avanzamento;

@Repository
public class AvanzamentoRepoImp implements AvanzamentoRepo
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Avanzamento setAvanzamento(Avanzamento a)
	{
		em.persist(a);
		return a;
	}
}

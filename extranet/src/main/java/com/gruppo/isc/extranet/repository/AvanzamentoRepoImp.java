package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
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
	
	@Override
	@Transactional
	public Avanzamento modAvanzamento(Avanzamento a)
	{
		em.merge(a);
		return a;
	}
	
	@Override
	public List<Avanzamento> getAvanzamentoList()
	{
		Query q = em.createQuery("select a from Avanzamento a Order by Mese");
		return q.getResultList();
	}
}

package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.UsoRisorse;


@Repository
public class UsoRisorseRepoImp implements UsoRisorseRepo
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void setUsoRisorse(UsoRisorse u) 
	{
		em.persist(u);
	}
	
	@Override
	public List<UsoRisorse> getUsoRisorseList(int id)
	{
		Query q = em.createQuery("Select u From UsoRisorse u where Commessa.id=:id").setParameter("id", id);
		return q.getResultList();
	}
	
	@Override
	public List<UsoRisorse> getUsoRisorseList()
	{
		Query q = em.createQuery("Select u From UsoRisorse u");
		return q.getResultList();
	}
	
	@Override
	@Transactional
	public void modUsoRisorse(UsoRisorse u)
	{
		em.merge(u);
	}
	
}

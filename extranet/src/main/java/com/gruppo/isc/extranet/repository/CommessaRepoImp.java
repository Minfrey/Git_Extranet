package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Commessa;


@Repository
public class CommessaRepoImp implements CommessaRepo 
{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public int setCommessa(Commessa c)
	{
		Integer a;
		em.persist(c);
		em.flush();
		a=c.getId_commessa();		
		return a;
	}
	
	@Override
	public Commessa getCommessaId(int id)
	{
		
		return em.find(Commessa.class, id);
	}
	
	@Override
	public List<Commessa> getListaCommessa()
	{
		Query q  = em.createQuery("From Commessa");
		return q.getResultList();
	}
}

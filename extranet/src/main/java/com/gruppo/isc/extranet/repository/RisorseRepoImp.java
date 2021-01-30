package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Risorse;

@Repository
public class RisorseRepoImp implements RisorseRepo
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Risorse> getRisorseList()
	{
		Query q = em.createQuery("SELECT r FROM Risorse r");
		return q.getResultList();
	}
}

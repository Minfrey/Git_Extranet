package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Mese;




@Repository
public class MeseRepoImp implements MeseRepo 
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Mese> getMeseList()
	{
		Query q = em.createQuery("SELECT m FROM Mese m");
		return q.getResultList();
	}

}

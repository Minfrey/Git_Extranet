package com.gruppo.isc.extranet.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	
}

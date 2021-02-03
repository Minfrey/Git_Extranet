package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Anno;

@Repository
public class AnnoRepoImp implements AnnoRepo
{
	@PersistenceContext
	EntityManager em;
	
	public List<Anno> getAnno()
	{
		Query q  = em.createQuery("Select a From Anno a");
		return q.getResultList();
	}
}

package com.gruppo.isc.extranet.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.TipoUsoRisorse;



@Repository
public class TipoUsoRisorseRepoImp implements TipoUsoRisorseRepo 
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public TipoUsoRisorse getTipoUsoRisorseId(int id)
	{
		
		TipoUsoRisorse a = em.find(TipoUsoRisorse.class, id);
		return a;
	}

}

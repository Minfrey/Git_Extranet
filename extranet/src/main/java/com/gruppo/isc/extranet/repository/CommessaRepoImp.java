package com.gruppo.isc.extranet.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Anno;
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
	
	@Override
	@Transactional
	public Commessa modCommessa(Commessa c)
	{
		Commessa a = em.merge(c);
		return a;
	}
	
	@Override 
	public void fatturatoCommessa(Double fatturato, Integer id)
	{
		Commessa c  = em.find(Commessa.class, id);
		c.setFatturato((c.getFatturato()+fatturato));
		em.merge(c);
	}
	
	public void previsionefatturatoCommessa(Double fatturato, Integer id)
	{
		Commessa c  = em.find(Commessa.class, id);
		c.setFatturato_previsto((c.getFatturato_previsto()+fatturato));
		em.merge(c);
	}
	
	public void previsioneCostoCommessa(Double costo, Integer id)
	{
		Commessa c  = em.find(Commessa.class, id);
		c.setCosto_previsto(c.getCosto_previsto()+costo);
		em.merge(c);
	}
	
	public void CostoCommessa(Double costo, Integer id)
	{
		Commessa c  = em.find(Commessa.class, id);
		c.setCosto(c.getCosto()+costo);
		em.merge(c);
	}

	@Override
	public List<Anno> getAnniCommesse(int id) {
		List<Anno> anni = new ArrayList<Anno>();
		Query q = em.createQuery("select  DISTINCT a.anno from Avanzamento a where a.attivita.commessa.id_commessa =: id and a.anno.numero IN(SELECT a.anno.numero from Avanzamento a GROUP BY a.anno.numero HAVING COUNT(*)>1) ORDER BY a.anno.numero");
		q.setParameter("id", id);
		anni = q.getResultList();
		
		
		
		return anni;
	}
	
	public String chiudiPreventivo(int id)
	{
		Commessa c  = em.find(Commessa.class, id);
		c.setPrevchiuso(true);
		em.merge(c);
		return ("\"preventivo completato\"");
	}
}

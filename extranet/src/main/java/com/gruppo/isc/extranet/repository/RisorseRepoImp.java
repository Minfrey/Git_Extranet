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
	
	@Override
	public Risorse setRisorse(Risorse r)
	{
		em.persist(r); 
		return r;
	}
	
	@Override
	public Risorse modRisorse(Risorse r)
	{
		em.persist(r); 
		return r;
	}
	
	@Override
	public void schedulRisorse(String a)
	{
		java.sql.Date date=java.sql.Date.valueOf(a);
		Query q = em.createQuery("SELECT r.nome From Risorse r where r.iniziovalidita = :date and r.nome IN(SELECT r.nome from Risorse r GROUP BY r.nome HAVING COUNT(*)>1) ").setParameter("date", date);
		List<String> array = q.getResultList(); 
		for(int i=0;i<array.size();i++)
		{
			String nome = array.get(i);
			boolean attivato = true;
			Query q1 = em.createQuery("Update Risorse r Set r.attivo=:attivato where r.iniziovalidita=:data and r.nome=:nome").setParameter("data", date).setParameter("nome", nome).setParameter("attivato", attivato);
			attivato = false;
			q1.executeUpdate();
			
			Query q2 = em.createQuery("Update Risorse r Set r.attivo=:attivato where r.iniziovalidita!=:data and r.nome=:nome").setParameter("data", date).setParameter("nome", nome).setParameter("attivato", attivato);
			q2.executeUpdate();
			
			System.out.println(nome);
			// per ogni nome fai una select dove tutti quelli con data diversa da oggi vengono disattivati e tutti quelli con data uguale a oggi vengono attivati
		}
	}
}

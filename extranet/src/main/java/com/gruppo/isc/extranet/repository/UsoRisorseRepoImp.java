
package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Avanzamento;
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
		Query q = em.createQuery("Select u From UsoRisorse u where Commessa.id=:id Order by u.anno.numero, u.mese.id_mese").setParameter("id", id);
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
	
	@Override
	public List<UsoRisorse> getUsoRisorseByType(int id, int idt)
	{
		System.out.println("id commessa "+id);
		System.out.println("id tiporisorse "+idt);
		Query q = em.createQuery("SELECT u FROM UsoRisorse u WHERE  u.commessa.id_commessa= :commessa AND u.tipoUsoRisorse.id_tipo_usorisorse = :tipo Order by u.anno.numero, u.mese.id_mese");
		q.setParameter("tipo", idt);
		q.setParameter("commessa", id);
		return q.getResultList();
	}
	
	@Override
	public List<UsoRisorse> controlloInserimento(UsoRisorse a)
	{
		Query q = em.createQuery("SELECT a FROM UsoRisorse a WHERE a.commessa.id_commessa = :commessa AND a.tipoUsoRisorse.id_tipo_usorisorse= :tipo AND a.anno.id_anno = :anno AND a.mese.id_mese = :mese AND a.risorse.id_risorse = :risorse Order by a.anno.numero, a.mese.id_mese ");
		q.setParameter("commessa", a.getCommessa().getId_commessa());
		q.setParameter("tipo", a.getTipoUsoRisorse().getId_tipo_usorisorse());
		q.setParameter("anno",a.getAnno().getId_anno());
		q.setParameter("mese",a.getMese().getId_mese());
		q.setParameter("risorse", a.getRisorse().getId_risorse());
		return q.getResultList();
	}
	
	
}

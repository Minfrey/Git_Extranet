package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;

@Repository
public class AvanzamentoRepoImp implements AvanzamentoRepo
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Avanzamento setAvanzamento(Avanzamento a)
	{
		em.persist(a);
		return a;
	}
	
	@Override
	@Transactional
	public Avanzamento modAvanzamento(Avanzamento a)
	{
		em.merge(a);
		return a;
	}
	
	@Override
	public List<Avanzamento> getAvanzamentoList()
	{
		Query q = em.createQuery("select a from Avanzamento a Order by a.mese");
		return q.getResultList();
	}
	
	@Override
	public List<Object> getAvanzamentoByAttivita(int id)
	{
		Query q = em.createNativeQuery("select commessa.nome as nomecommessa,task.nome as nomeattivita ,mese.nome as mese,avanzamento.percentuale,avanzamento.valore,attivita.valore as valoretotale from avanzamento inner join attivita on fk_id_attivita=id_attivita inner join task on fk_id_task=id_task inner join mese on fk_id_mese=id_mese inner join commessa on fk_id_commessa=id_commessa where commessa.id_commessa=?").setParameter(1, id);
		return q.getResultList();
	}
	
//	@Override
//	public List<Avanzamento> getAvanzamentoByAttivita2(int id)
//	{
//		System.out.println(id);
//		Query q = em.createNativeQuery("select avanzamento.* from avanzamento inner join attivita on fk_id_attivita=id_attivita inner join task on fk_id_task=id_task inner join mese on fk_id_mese=id_mese inner join anno on fk_id_anno=id_anno inner join commessa on fk_id_commessa=id_commessa where commessa.id_commessa=?").setParameter(1, id);
//		return q.getResultList();
//	}
	
	@Override
	public List<Avanzamento> getAvanzamentoByAttivita2(int id)
	{
		System.out.println(id); //JOIN a.attivita b JOIN b.commessa c  WHERE c.id_commessa= :id 
		Query q = em.createQuery("SELECT a FROM Avanzamento a where a.attivita.commessa.id_commessa = :id").setParameter("id", id);
		return q.getResultList();
	}
	
	
}

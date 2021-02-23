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
	public List<Avanzamento> getAvanzamentoByAttivita2(int id)
	{
		System.out.println(id); //JOIN a.attivita b JOIN b.commessa c  WHERE c.id_commessa= :id 
		Query q = em.createQuery("SELECT a FROM Avanzamento a where a.attivita.commessa.id_commessa = :id").setParameter("id", id);
		return q.getResultList();
	}
	@Override
	public List<Avanzamento> getAvanzamentoByCommessaType(int id, int idt)
	{
		Query q = em.createQuery("SELECT a FROM Avanzamento a WHERE a.attivita.commessa.id_commessa = :id AND a.tipoAvanzamento.id_tipo_avanzamento= :idt ORDER BY a.attivita.id_attivita,a.anno.numero,a.mese.id_mese	").setParameter("id", id).setParameter("idt",idt);
		return q.getResultList();
	}
	
	@Override
	public Avanzamento getAvanzamentoByID(int id)
	{
		return  em.find(Avanzamento.class, id);
	}
	
	@Override
	public List<Avanzamento> controlloPercentuale(Avanzamento a)
	{
		Query q = em.createQuery("SELECT a FROM Avanzamento a WHERE a.attivita.commessa.id_commessa = :commessa AND a.tipoAvanzamento.id_tipo_avanzamento= :tipo AND a.attivita.id_attivita = :attivita ORDER BY a.percentuale,a.anno.numero,a.mese.id_mese");
		q.setParameter("commessa", a.getAttivita().getCommessa().getId_commessa());
		q.setParameter("tipo", a.getTipoAvanzamento().getId_tipo_avanzamento());
		q.setParameter("attivita", a.getAttivita().getId_attivita());
		return q.getResultList();
		
	}
	
	@Override
	public List<Avanzamento> controlloInserimento(Avanzamento a)
	{
		Query q = em.createQuery("SELECT a FROM Avanzamento a WHERE a.attivita.commessa.id_commessa = :commessa AND a.tipoAvanzamento.id_tipo_avanzamento= :tipo AND a.attivita.id_attivita = :attivita ");
		q.setParameter("commessa", a.getAttivita().getCommessa().getId_commessa());
		q.setParameter("tipo", a.getTipoAvanzamento().getId_tipo_avanzamento());
		q.setParameter("attivita", a.getAttivita().getId_attivita());
		return q.getResultList();
	}
	
	@Override
	public Avanzamento consolidav(Avanzamento a)
	{
		Avanzamento b = em.merge(a);
		return b;
	}

	
	
}

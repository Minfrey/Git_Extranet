package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Commessa;



@Repository
public class AttivitaRepoImp implements AttivitaRepo 
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
  public void setAttivita(Attivita a)
  {	
		em.persist(a);
  }
	
	@Override
  public List<Attivita> getAttivitaCommessa(int id)
  {
	  Commessa a1= em.find(Commessa.class, id);
	  System.out.println("id commessa = "+a1.getId_commessa());
	  
	  	// le query devono essere fatte sulle entita non sul database
	  	Query q =	em.createQuery("SELECT a FROM Attivita a WHERE a.commessa = :commessa").setParameter("commessa", a1);
		return q.getResultList();
  }
	
	public  List<Attivita> getAttivitaCommessaByType(int id,int idt)
	{
		  	Query q =	em.createQuery("SELECT a FROM Attivita a JOIN a.avanzamento b WHERE a.commessa.id_commessa = :commessa and b.tipoAvanzamento.id_tipo_avanzamento = :idt ").setParameter("commessa", id).setParameter("idt", idt);
			return q.getResultList();
	}
	
	@Override
	public Attivita modAttivita(Attivita a)
	{
		Attivita b =em.merge(a);
		return b;
	}
	
	 
}

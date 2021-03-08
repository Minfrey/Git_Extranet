package com.gruppo.isc.extranet.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.model.TipoAvanzamento;



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
<<<<<<< HEAD
		  	Query q =	em.createQuery("SELECT distinct a FROM Attivita a JOIN a.avanzamento b WHERE a.commessa.id_commessa = :commessa and b.tipoAvanzamento.id_tipo_avanzamento = :idt ").setParameter("commessa", id).setParameter("idt", idt);
			return q.getResultList();
=======
		Commessa a1= em.find(Commessa.class, id);
		  System.out.println("id commessa = "+a1.getId_commessa());
		  
		  	// le query devono essere fatte sulle entita non sul database
		  TipoAvanzamento a2 = em.find(TipoAvanzamento.class, idt);
		  System.out.println("id avanzamento = "+a2.getId_tipo_avanzamento());
		  
		  	Query q =	em.createQuery("SELECT DISTINCT a FROM Attivita a JOIN a.avanzamento b WHERE a.commessa = :commessa ").setParameter("commessa", a1);
			List<Attivita> a =q.getResultList();
		  	for(int i=0;i<a.size();i++)
		  	{
		  		Query q2 = em.createQuery("Select a from Avanzamento a where a.attivita = :attivita and a.tipoAvanzamento = :tipo").setParameter("attivita" , a.get(i)).setParameter("tipo", a2);
		  		List<Avanzamento> avanzamentolocale=  q2.getResultList();
		  		Set<Avanzamento> foo = new HashSet<Avanzamento>(avanzamentolocale);
		  		a.get(i).setAvanzamento(foo);
		  	}
		  	return a;
>>>>>>> branch 'main' of https://github.com/Minfrey/Git_Extranet.git
	}
	
	@Override
	public Attivita modAttivita(Attivita a)
	{
		Attivita b =em.merge(a);
		return b;
	}
	
	 
}

package com.gruppo.isc.extranet.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.model.Risorse;
import com.gruppo.isc.extranet.model.TipoAvanzamento;
import com.gruppo.isc.extranet.model.TipoUsoRisorse;
import com.gruppo.isc.extranet.model.UsoRisorse;

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
	public List<Risorse> getRisorseListActive()
	{
		Query q = em.createQuery("SELECT r FROM Risorse r where attivo=true");
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
			// per ogni nome duplicato la cui data e uguale a oggi</div> tutti i record di risorse con data diversa da oggi vengono disattivati e tutti quelli con data uguale a oggi vengono attivati
		}
	}
	
	public List<Risorse> getRisorseCommessaByType(int id, int idt)
	{
		Commessa a1= em.find(Commessa.class, id);
		  System.out.println("id commessa = "+a1.getId_commessa());
		  
		  	// le query devono essere fatte sulle entita non sul database
		  TipoUsoRisorse a2 = em.find(TipoUsoRisorse.class, idt);
		  System.out.println("id avanzamento = "+a2.getId_tipo_usorisorse());
		  
		  	Query q =	em.createQuery("SELECT Distinct a FROM Risorse a Join a.usorisorse b where b.commessa = :commessa").setParameter("commessa", a1);
			List<Risorse> a =q.getResultList();
		  	for(int i=0;i<a.size();i++)
		  	{
		  		Query q2 = em.createQuery("Select a from UsoRisorse a where a.risorse = :risorse and a.tipoUsoRisorse = :tipo and a.commessa=:commessa").setParameter("risorse" , a.get(i)).setParameter("tipo", a2).setParameter("commessa", a1);;
		  		List<UsoRisorse> avanzamentolocale=  q2.getResultList();
		  		Set<UsoRisorse> foo = new HashSet<UsoRisorse>(avanzamentolocale);
		  		a.get(i).setUsorisorse(foo);
		  	}
		  	return a;
	}
}

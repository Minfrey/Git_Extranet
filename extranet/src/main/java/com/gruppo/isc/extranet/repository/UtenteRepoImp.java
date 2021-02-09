package com.gruppo.isc.extranet.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;

@Repository
public class UtenteRepoImp implements UtenteRepo {

	
	
	@PersistenceContext
	EntityManager em;
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Utente> getAllUtenti(String descrizione) {
		Query q = em.createQuery("select u from Utente u join u.gruppo g where g.descrizione=:descrizione");
		q.setParameter("descrizione", descrizione);
		return q.getResultList();
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public Utente accesso(Utente u) {
		
		Utente utente = new Utente();
		
		Query q = em.createQuery("select u from Utente u where u.username=:user and u.password=md5(:pass)");
		q.setParameter("user", u.getUsername());
		q.setParameter("pass", u.getPassword());
		
		try {
			utente = (Utente) q.getSingleResult();			
		} catch (NoResultException e) {
			utente = null;
		}
		
		return utente;
		

	}
		
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Gruppo> getAlleGruppi() {
		Query q = em.createQuery("select g from Gruppo g");
		return q.getResultList();
	}
	

	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	@Transactional
	public boolean modificaPassword(Utente u) {
		boolean modifica = false;
		Query q = em.createQuery("update Utente u set u.password = md5(:pass), u.primo_accesso=:pa where u.id=:id");
		q.setParameter("pa", u.getPrimo_accesso());
		q.setParameter("pass", u.getPassword());
		q.setParameter("id", u.getId());
		try
		{
			if(q.executeUpdate()>0)
			{
				modifica=true;
				
			}
		}
		catch (IllegalStateException e) {
		}
		return modifica;
	}


	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	@Transactional
	public boolean disabilitaUtente(Utente u) {
		boolean disabilita = false;
		Query q = em.createQuery("update Utente u set u.stato=:stato where u.id=:id");
		q.setParameter("stato", u.getStato());
		q.setParameter("id", u.getId());
		
		try {
			if(q.executeUpdate()>0)
			{
				disabilita = true;
			}
		}
		catch (IllegalStateException e) {
		}
		return disabilita;
	}
	
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public Utente cercaUtente(Utente u) {
		Utente utente = new Utente();
		
		Query q = em.createQuery("select u from Utente u where u.username=:username");
		q.setParameter("username", u.getUsername());
		
		try {
			if(q.getSingleResult()!= null)
			{
				utente = (Utente) q.getSingleResult();
			}
			
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		return utente;
	}

	
	@Transactional
	@Override
	public boolean resetPassword(Utente u) {
		boolean reset = false;
		String password = "123";
		int stato = 1;
		int primoAccesso = 1;

		
		Query q = em.createQuery("update Utente u set u.password = md5(:pass), u.stato=:stato, u.primo_accesso =:primoaccesso where u.id=:id");
		q.setParameter("pass", password);
		q.setParameter("primoaccesso", primoAccesso);
		q.setParameter("stato", stato);
		q.setParameter("id", u.getId());	
		
		try {
			if(q.executeUpdate()>0)
			{
				reset = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return reset;
	}
		
	
	
	@Override
	@Transactional	
	public void creaUtente(Utente u){
		String password = "123";
		int stato = 1;
		int primoAccesso = 1;

			Query q = em.createNativeQuery("insert into Utente (username, password,primo_accesso,stato, fk_id_gruppo) values (?,md5(?),?,?,?) ");
			q.setParameter(1, u.getUsername());
			q.setParameter(2, password);
			q.setParameter(3, primoAccesso);
			q.setParameter(4, stato);
			q.setParameter(5, u.getGruppo().getId());	
			q.executeUpdate();
	}






}

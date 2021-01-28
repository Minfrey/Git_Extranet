package com.gruppo.isc.extranet.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;

@Repository
public class UtenteRepoImp implements UtenteRepo {

	@PersistenceContext
	EntityManager em;
	
	@PersistenceContext
	EntityManager am;
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Utente> getAllUtenti(String descrizione) {
		Query q = em.createQuery("select u from Utente u join u.gruppo g where g.descrizione=:descrizione");
		q.setParameter("descrizione", descrizione);
		return q.getResultList();
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public boolean accesso(Utente u) {
		boolean accesso = false;
		
		Query q = em.createQuery("select u from Utente u where u.username=:user and u.password=md5(:pass)");
		q.setParameter("user", u.getUsername());
		q.setParameter("pass", u.getPassword());
		
		try
		{
			if(q.getSingleResult()!=null) {
				accesso=true;
			}
		}
		catch (NoResultException e) {
		}
		
		return accesso;
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
		Query q = em.createQuery("update Utente u set u.password = md5(:pass) where u.id=:id");
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

	
	
	
	
	
	
	
	
	
	@Override
	@Transactional
	public void creaUtente(Utente u) {
		String password = "123";
		
		Query q = em.createQuery("select g from Gruppo g where g.descrizione = :descrizione");
		q.setParameter("descrizione",u.getGruppo().getDescrizione());
		
		Query q2 = em.createQuery(" insert into Utente (username, password, fk_id_gruppo) values (:user, md5(:pass), :idGruppo");
		q2.setParameter("user", u.getUsername());
		q2.setParameter("pass", password);
		q2.setParameter("idGruppo", u.getGruppo().getId());
		
		q2.executeUpdate();
		
		
	}
		
	
	
	
	@Override
	@Transactional
	public boolean disabilitaUtente(Utente u) {
		boolean disabilita = false;
		int disabilitato = 0;
		String desc = "utente";
		Query q = em.createQuery("update Utente u set u.stato=:stato where u.id=:id and u.gruppo.descrizione=:desc");
		q.setParameter("stato", disabilitato);
		q.setParameter("id", u.getId());
		q.setParameter("desc", desc);
		
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





}

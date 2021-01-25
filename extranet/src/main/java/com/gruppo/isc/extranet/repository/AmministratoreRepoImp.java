package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Amministratore;
import com.gruppo.isc.extranet.model.Utente;

@Repository
public class AmministratoreRepoImp implements AmministratoreRepo{

	@PersistenceContext
	EntityManager em;
	
	
	
	//----------------------------------------
	//Metodo per cercare glu utenti per username
	@Override
	public List<Utente> getAllUtenti() 
	{
		Query q = em.createQuery("select u from Utente u");
		return q.getResultList();
	}

	
	
	//----------------------------------------
	//Metodo per cercare gli utenti per username
	@Override
	public Utente cercaUtente(String username) 
	{
		Utente utente = null;
		TypedQuery<Utente> q = em.createNamedQuery("Amministratore.cercaUtente", Utente.class);
		q.setParameter("username", username);
		try
		{
			utente = q.getSingleResult();
		}
		catch (NoResultException e) {
			System.out.println("non funziona!");
		}
		
		return utente;
	}

	
	//-------------------------------------
	//Metodo per inserire un nuovo utente
	@Override
	@Transactional
	public Utente creaUtente(Utente u) {	
		em.persist(u);	
		return u;
	}
	
	
	//-------------------------------------
	//Metodo per disabilitare gli utenti
	@Override
	public void disabilitaUtente(Utente u) {
		em.merge(u);		
	}



	@Override
	public boolean accessoAmministratore(String username, String password) {
		
		Amministratore amministratore = null;
		boolean accesso = false;
		
			TypedQuery<Amministratore> q= em.createNamedQuery("Amministratore.accessoAmministratore",Amministratore.class);
			q.setParameter("user", username);
			q.setParameter("password", password);
			
			amministratore = q.getSingleResult();
			
		if(amministratore!=null)
		{
			accesso = true;
		}
			
		return accesso;
	}


	//*************************************************************
	//da fare
	@Override
	public boolean modificaPasswordAmministratore(String password) {
		// TODO Auto-generated method stub
		return false;
	}




}

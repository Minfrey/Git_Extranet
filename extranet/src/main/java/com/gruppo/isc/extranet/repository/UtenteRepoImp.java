package com.gruppo.isc.extranet.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Utente;

@Repository
public class UtenteRepoImp implements UtenteRepo {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	Utente u;
	
	@Override
	public List<Utente> getAllUtenti() {
		Query q = em.createQuery("select u from Utente u where u.gruppo.descrizione='utente'");
		return q.getResultList();
	}
	
	@Override
	public void creaUtente(Utente u) {
		String password = "md5(123)";
		int stato = 1;
		int primoAccesso=1;		
		int gruppo = 1;
//		Query gruppo = em.createQuery("select g from Gruppo g where g.descrizione='utente'")
		
		Query q = em.createQuery("insert into Utente u (u.username, u.password, u.stato, u.primo_accesso, u.gruppo.id) values(:user,md5(:pass),:stato,:pa, :gruppo)");
		q.setParameter("user", u.getUsername());
		q.setParameter("pass", password);
		q.setParameter("stato", stato);
		q.setParameter("pa", primoAccesso);
		q.setParameter("gruppo", gruppo);
		
		em.persist(q);
		
	}

	@Override
	public void disabilitaUtente(Utente u) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean accesso(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

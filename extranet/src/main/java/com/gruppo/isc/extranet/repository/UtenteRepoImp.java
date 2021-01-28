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
	
	
	@Override
	public List<Utente> getAllUtenti(String descrizione) {
		Query q = em.createQuery("select u from Utente u join u.gruppo g where g.descrizione=:descrizione");
		q.setParameter("descrizione", descrizione);
		return q.getResultList();
	}
	
	@Override
	@Transactional
	public void creaUtente(String username, String tipoUtente) {
		String password = "123";
		
		Gruppo g= new Gruppo();
		Query gruppo = em.createQuery("select g from Gruppo g where g.descrizione = :descrizione");
		gruppo.setParameter("descrizione", tipoUtente);
		g=(Gruppo) gruppo.getSingleResult();
		
		Query q = em.createNativeQuery("insert into Utente (username, password, fk_id_gruppo) values(?,md5(?),?)");
		q.setParameter(1,username);
		q.setParameter(2, password);
		q.setParameter(3, g.getId());
		
		q.executeUpdate();
	
	}
	
	@Override
	public boolean accesso(String username, String password) {
		boolean accesso = false;
		
		Query q = em.createQuery("select u from Utente u where u.username=:user and u.password=md5(:pass)");
		q.setParameter("user", username);
		q.setParameter("pass", password);
		
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
	
	
	@Override
	@Transactional
	public boolean modificaPassword(Utente u,String password) {
		boolean modifica = false;
		Query q = em.createQuery("update Utente u set u.password = md5(:pass) where u.id=:id");
		q.setParameter("pass", password);
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
	public List<Gruppo> getAlleGruppi() {
		Query q = em.createQuery("select g from Gruppo g");
		return q.getResultList();
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

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
	public List<Utente> getAllUtenti() {
		Query q = em.createQuery("select u from Utente u join u.gruppo g where g.descrizione='utente'");
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
	public void disabilitaUtente(Utente u) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean modificaPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

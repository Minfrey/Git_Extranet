package com.gruppo.isc.extranet.repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityExistsException;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;

public interface UtenteRepo {

	public List<Utente> getAllUtenti(String descrizione);
	
	public boolean disabilitaUtente(Utente u);
	
	public boolean creaUtente(Utente u);
	
	public Utente accesso(Utente u);
	
	public boolean modificaPassword(Utente u);
	
	public List<Gruppo> getAlleGruppi();
	
	public List<Utente> cercaUtente(String cerca);
	
	public boolean resetPassword(Utente u);
	
	public boolean confrontaPassword(Utente u);
	
	public List<Utente> cercaUtenteDiGruppo(String utente, String gruppo);
}

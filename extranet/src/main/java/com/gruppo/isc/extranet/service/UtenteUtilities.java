package com.gruppo.isc.extranet.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;

public interface UtenteUtilities {

public List<Utente> getAllUtenti(String descrizione);
	
	public boolean disabilitaUtente(Utente u);
	
	public boolean creaUtente(Utente u);
	
	public Utente accesso(Utente u);
	
	public boolean modificaPassword(Utente u);
	
	public List<Gruppo> getAlleGruppi();
	
	public Utente cercaUtente(Utente u);
	
	public boolean resetPassword(Utente u);
	
	public boolean confrontaPassword(Utente u);
	
}

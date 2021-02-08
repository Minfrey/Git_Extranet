package com.gruppo.isc.extranet.repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;

public interface UtenteRepo {

	public List<Utente> getAllUtenti(String descrizione);
	
	public boolean disabilitaUtente(Utente u);
	
	public void creaUtente(Utente u);
	
	public Utente accesso(Utente u);
	
	public boolean modificaPassword(Utente u);
	
	public List<Gruppo> getAlleGruppi();
}

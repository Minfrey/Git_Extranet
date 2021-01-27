package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Utente;

public interface UtenteRepo {

	public List<Utente> getAllUtenti();
	
	public void disabilitaUtente(Utente u);
	
	public Utente creaUtente(Utente u);
	
	public boolean accesso(String username, String password);
	
	public boolean modificaPassword(String password);
}

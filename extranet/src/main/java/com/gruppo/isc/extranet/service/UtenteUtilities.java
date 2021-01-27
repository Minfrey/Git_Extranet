package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Utente;

public interface UtenteUtilities {

public List<Utente> getAllUtenti();
	
	public void disabilitaUtente(Utente u);
	
	public Utente creaUtente(Utente u);
	
	public boolean accesso(String username, String password);
	
	public boolean modificaPassword(String password);
}

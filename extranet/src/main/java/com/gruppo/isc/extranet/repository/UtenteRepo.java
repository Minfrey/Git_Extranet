package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Utente;

public interface UtenteRepo {

	public List<Utente> getAllUtenti();
	
	public void disabilitaUtente(Utente u);
	
	public void creaUtente(String username, String tipoUtente);
	
	public boolean accesso(String username, String password);
	
	public boolean modificaPassword(String password);
}

package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;

public interface UtenteUtilities {

public List<Utente> getAllUtenti(String descrizione);
	
	public boolean disabilitaUtente(Utente u);
	
	public void creaUtente(String username , String tipoUtente);
	
	public boolean accesso(String username, String password);
	
	public boolean modificaPassword(Utente u,String password);
	
	public List<Gruppo> getAlleGruppi();
	
}

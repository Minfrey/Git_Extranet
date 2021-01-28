package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.repository.UtenteRepo;

@Service
public class UtenteService implements UtenteUtilities {

	@Autowired
	UtenteRepo ur;
	
	@Override
	public List<Utente> getAllUtenti(String descrizione) {
		return ur.getAllUtenti(descrizione);
	}

	@Override
	public void creaUtente(String username, String tipoUtente) {
		ur.creaUtente(username, tipoUtente);
	}
	
	
	@Override
	public boolean accesso(String username, String password) {
		return ur.accesso(username, password);
	}
	
	
	@Override
	public boolean disabilitaUtente(Utente u) {
		return ur.disabilitaUtente(u);
	}



	@Override
	public boolean modificaPassword(Utente u ,String password) {
		return ur.modificaPassword(u, password);
	}

	@Override
	public List<Gruppo> getAlleGruppi() {
		return ur.getAlleGruppi();
	}

}

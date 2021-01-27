package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.repository.UtenteRepo;

@Service
public class UtenteService implements UtenteUtilities {

	@Autowired
	UtenteRepo ur;
	
	@Override
	public List<Utente> getAllUtenti() {
		return ur.getAllUtenti();
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
	public void disabilitaUtente(Utente u) {
		// TODO Auto-generated method stub

	}



	@Override
	public boolean modificaPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

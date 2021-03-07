package com.gruppo.isc.extranet.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Abilitazioni;
import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.repository.UtenteRepo;

@Service
public class UtenteService implements UtenteUtilities {

	@Autowired
	UtenteRepo ur;
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Utente> getAllUtenti(String descrizione) {
		return ur.getAllUtenti(descrizione);
	}

	//*****METODO FINITO E FUNZIONANTE**********	
	@Override
	public Utente accesso(Utente u) {
		return ur.accesso(u);
	}
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Gruppo> getAlleGruppi() {
		return ur.getAlleGruppi();
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public boolean disabilitaUtente(Utente u) {
		return ur.disabilitaUtente(u);
	}
	

	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public boolean modificaPassword(Utente u) {
		return ur.modificaPassword(u );
	}



	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Utente> cercaUtente(String u) {
		return ur.cercaUtente(u);
	}

	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public boolean resetPassword(Utente u) {
		return ur.resetPassword(u);
	}

	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public boolean confrontaPassword(Utente u) {
		return ur.confrontaPassword(u);
	}

	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public List<Utente> cercaUtenteDiGruppo(String utente, String gruppo) {
		return ur.cercaUtenteDiGruppo(utente, gruppo);
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@Override
	public boolean creaUtente(Utente u) {
		return ur.creaUtente(u);
		
	}

	@Override	
	public Abilitazioni getAbilitazioniByTipoUtente(int idGruppo) {
		return ur.getAbilitazioniByTipoUtente(idGruppo);
	}


	
}

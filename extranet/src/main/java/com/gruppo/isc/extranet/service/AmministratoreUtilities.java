package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Utente;



public interface AmministratoreUtilities {

		public List<Utente> getAllUtenti();
		
		public void disabilitaUtente(Utente u);
		
		public Utente cercaUtente(String username);
		
		public Utente creaUtente(Utente u);
		
		public boolean accessoAmministratore(String username, String password);
		
		public boolean modificaPasswordAmministratore(String password);

}

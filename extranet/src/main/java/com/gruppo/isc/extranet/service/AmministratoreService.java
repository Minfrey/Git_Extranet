package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.repository.AmministratoreRepo;



@Service
public class AmministratoreService implements AmministratoreUtilities{

	@Autowired
	AmministratoreRepo ar;
	
	
	@Override
	public List<Utente> getAllUtenti() 
	{
		return ar.getAllUtenti();
	}

	@Override
	public void disabilitaUtente(Utente u) 
	{
		ar.disabilitaUtente(u);
	}

	@Override
	public Utente cercaUtente(String username) 
	{	
		return ar.cercaUtente(username);
	}

	@Override
	public Utente creaUtente(Utente u) 
	{
		if(u.getPassword()==null)
		{
			u.setPassword("123");
		}
		if(u.getPrimoAccesso()==null)
		{
			u.setPrimoAccesso("1");
		}
		if(u.getStato()==null)
		{
			u.setStato("1");
		}
		ar.creaUtente(u);
		return u;
	}
	

	@Override
	public boolean accessoAmministratore(String username, String password) 
	{
		return ar.accessoAmministratore(username, password);
	}

	@Override
	public boolean modificaPasswordAmministratore(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

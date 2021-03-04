package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Attivita;

public interface AttivitaService 
{
	public String setAttivita(Attivita a);
	
	public List<Attivita> getAttivitaCommessa(int id);
	
	public String modAttivita(Attivita a);
}

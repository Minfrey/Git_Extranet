package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Attivita;

public interface AttivitaRepo 
{
	public void setAttivita(Attivita a);
	public List<Attivita> getAttivitaCommessa(int id);
	public Attivita modAttivita(Attivita a);
}

package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Commessa;

public interface CommessaRepo
{
	public int setCommessa(Commessa c);
	
	public Commessa getCommessaId(int id);
	
	public List<Commessa> getListaCommessa();

	public Commessa modCommessa(Commessa c);
}

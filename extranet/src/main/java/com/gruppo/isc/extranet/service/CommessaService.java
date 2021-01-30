package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Commessa;

public interface CommessaService
{
	public int setCommessa(Commessa c);
	public Commessa getCommessaId(int id);
	public List<Commessa> getListaCommessa();
}

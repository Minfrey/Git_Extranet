package com.gruppo.isc.extranet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.repository.CommessaRepoImp;


@Service
public class CommessaServiceImp implements CommessaService 
{
	@Autowired
	CommessaRepoImp cr;
	
	@Override
	@Transactional
	public int setCommessa(Commessa c)
	{
		return cr.setCommessa(c);
	}
	
	@Override
	public Commessa getCommessaId(int id)
	{
		return cr.getCommessaId(id);
	}
	
	@Override
	public List<Commessa> getListaCommessa()
	{
		return cr.getListaCommessa();
	}
}

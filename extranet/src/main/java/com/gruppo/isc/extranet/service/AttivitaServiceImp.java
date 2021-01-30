package com.gruppo.isc.extranet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.repository.AttivitaRepoImp;


@Service
public class AttivitaServiceImp implements AttivitaService 
{
	@Autowired
	AttivitaRepoImp ar;
	
	@Override
	@Transactional
	public void setAttivita(Attivita a)
	{
		 ar.setAttivita(a);
	}
	
	@Override
	public List<Attivita> getAttivitaCommessa(int id)
	{
		return ar.getAttivitaCommessa(id);
	}


}

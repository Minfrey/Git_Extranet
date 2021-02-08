package com.gruppo.isc.extranet.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.repository.AttivitaRepoImp;
import com.gruppo.isc.extranet.repository.CommessaRepoImp;


@Service
public class AttivitaServiceImp implements AttivitaService 
{
	@Autowired
	AttivitaRepoImp ar;
	
	@Autowired
	CommessaRepoImp cr;
	
	@Override
	@Transactional
	public void setAttivita(Attivita a)
	{
		Commessa commessa =	cr.getCommessaId(a.getCommessa().getId_commessa());
		commessa.setValore(commessa.getValore()+a.getValore());
		cr.modCommessa(commessa);
	    ar.setAttivita(a);
	}
	
	@Override
	public List<Attivita> getAttivitaCommessa(int id)
	{
		return ar.getAttivitaCommessa(id);
	}
	
	public String modAttivita(Attivita a)
	{
		String messaggio;
		Attivita b = ar.modAttivita(a);
		if(a==b)
		{
			messaggio = "\"Attivita aggiornata\"";
		}
		else
		{
			messaggio = "\"Non e stato possibile aggiornare l'attivita\"";
		}
		return messaggio;
	}
	


}

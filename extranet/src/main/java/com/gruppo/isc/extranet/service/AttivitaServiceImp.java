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
	public String setAttivita(Attivita a)
	{
		Commessa commessa =	cr.getCommessaId(a.getCommessa().getId_commessa());
		commessa.setValore(commessa.getValore()+a.getValore());
		cr.modCommessa(commessa);
		String messaggio = "";
		boolean bool=false;
		System.out.println(a.getDescrizione());
		List<Attivita> array =ar.getAttivitaCommessa(commessa.getId_commessa());
		for(int i=0;i<array.size();i++)
		{
			if(a.getDescrizione().equals(array.get(i).getDescrizione()))
			{
				System.out.println(array.get(i).getDescrizione());
				bool = true;
				break;
			}
		}
		if(bool==true)
		{
			messaggio="\"Già esiste un'attività con questa descrizione in questa commessa\"";
		}
		else
		{
			 ar.setAttivita(a);
			 messaggio="\"Attività inserita con succeso\"";
		}
		return messaggio;
	   
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

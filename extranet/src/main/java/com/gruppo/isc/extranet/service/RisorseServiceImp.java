package com.gruppo.isc.extranet.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Risorse;
import com.gruppo.isc.extranet.repository.RisorseRepoImp;




@Service
public class RisorseServiceImp implements RisorseService 
{
	@Autowired
	RisorseRepoImp rr;
	
	@Override
	public List<Risorse> getRisorseList()
	{
		return rr.getRisorseList();
	}
	
	@Override
	public List<Risorse> getRisorseListActive()
	{
		return rr.getRisorseListActive();
	}
	
	@Override
	@Transactional
	public String setRisorse(Risorse r) 
	{
		String messaggio="";
		List<Risorse> controllo  = rr.getRisorseList();
		boolean controllonome  = true;
		for(int i=0;i<controllo.size();i++)
		{
			if(r.getNome().equals(controllo.get(i).getNome()))
			{
				controllonome=false;
						break;
			}
		}
		boolean attivo = true;
		r.setAttivo(attivo);
		if(controllonome==true)
		{
			Risorse locale = rr.setRisorse(r);
			messaggio = "\"risorsa inserita con successo\"";
		}
		else
		{
			messaggio = "\"questo tipo di risorsa è già stata inserita esegua la modifica\"";
		}
		return messaggio;
	}
	
	@Override
	@Transactional
	public String modRisorse(Risorse r)
	{
		String messaggio="";
		Date a = new Date();
		a.setHours(0);
		java.util.Date datainizio  = new java.util.Date(r.getIniziovalidita().getTime());
		System.out.println("data odierna " +a + "data passata"+ datainizio);
		System.out.println(datainizio.before(a));
		if(datainizio.before(a))
		{
			messaggio= "\"data inserita antecedente alla data odierna\"";
		}
		else
		{
			boolean attivo = false;
			r.setAttivo(attivo);
			Risorse locale = rr.modRisorse(r);
			messaggio= "\"risorsa inserita con successo\"";
		}
		return messaggio;
	}
	
	@Override
	@Transactional
	@Modifying
	public void schedulRisorse(String a)
	{
		rr.schedulRisorse(a);
	}
	
	public List<Risorse> getRisorseCommessaByType(int id, int idt)
	{
		return rr.getRisorseCommessaByType(id, idt);
	}
	
}

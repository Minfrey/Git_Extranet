package com.gruppo.isc.extranet.service;

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
		boolean attivo = false;
		r.setAttivo(attivo);
		Risorse locale = rr.setRisorse(r);
		String messaggio= "\"risorsa inserita con successo\"";
		return messaggio;
	}
	
	@Override
	@Transactional
	public String modRisorse(Risorse r)
	{
		boolean attivo = false;
		r.setAttivo(attivo);
		Risorse locale = rr.modRisorse(r);
		String messaggio= "\"risorsa inserita con successo\"";
		return messaggio;
	}
	
	@Override
	@Transactional
	@Modifying
	public void schedulRisorse(String a)
	{
		rr.schedulRisorse(a);
	}
	
	
}

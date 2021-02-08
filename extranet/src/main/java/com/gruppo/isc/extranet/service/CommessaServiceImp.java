package com.gruppo.isc.extranet.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.repository.CommessaRepoImp;


@Service
public class CommessaServiceImp implements CommessaService 
{
	private String messaggio = "";
	@Autowired
	CommessaRepoImp cr;
	
	@Override
	@Transactional
	public int setCommessa(Commessa c)
	{
	    	return  cr.setCommessa(c);
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
	
	@Override
	public String modCommessa(Commessa c)
	{
		String messaggio = ""; 
		Commessa a = cr.modCommessa(c);
		if(a==c)
		{
			messaggio = "\"Commessa aggiornata\"";
		}
		else
		{
			messaggio = "\"Non e stato possibile aggiornare la commessa\"";
		}
		return messaggio;		
	}
}

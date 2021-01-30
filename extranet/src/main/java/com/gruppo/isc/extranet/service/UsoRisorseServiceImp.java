package com.gruppo.isc.extranet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.UsoRisorse;
import com.gruppo.isc.extranet.repository.UsoRisorseRepoImp;

@Service
public class UsoRisorseServiceImp implements UsoRisorseService
{
	@Autowired
	UsoRisorseRepoImp urr;
	
	@Override
	public void setUsoRisorse(UsoRisorse u) 
	{
		Double ore = u.getOre();
		Double tariffa =u.getRisorse().getTariffa();
		Double costi = (ore*tariffa)*0.80;
	    u.setCosti(costi);
	    Double ricavi = ore*tariffa;
	    
	    u.setRicavi(ricavi);
	    
		urr.setUsoRisorse(u);
		
	}
	
}

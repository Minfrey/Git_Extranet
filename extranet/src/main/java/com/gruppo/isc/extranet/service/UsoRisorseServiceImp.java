package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gruppo.isc.extranet.model.UsoRisorse;
import com.gruppo.isc.extranet.repository.UsoRisorseRepoImp;

@Service
public class UsoRisorseServiceImp implements UsoRisorseService
{
	@Autowired
	UsoRisorseRepoImp urr;
	
	@Override
	public String setUsoRisorse(UsoRisorse u) 
	{
		String messaggio ="";
		boolean a = true;
		Double ore = u.getOre();
		Double tariffa =u.getRisorse().getTariffa();
		Double costi = (ore*tariffa)*0.80;
	    u.setCosti(costi);
	    Double ricavi = ore*tariffa;
	    u.setRicavi(ricavi);
		List<UsoRisorse> risorse = urr.getUsoRisorseList();
		for(int i=0;i<risorse.size();i++)
		{
			if(u.getMese().getId_mese().equals(risorse.get(i).getMese().getId_mese()) && 
			   u.getRisorse().getId_risorse().equals(risorse.get(i).getRisorse().getId_risorse()) &&
			   u.getTipoUsoRisorse().getId_tipo_usorisorse().equals(risorse.get(i).getTipoUsoRisorse().getId_tipo_usorisorse()) &&
			   u.getCommessa().getId_commessa().equals(risorse.get(i).getCommessa().getId_commessa()))
			{
				messaggio ="\"risorsa gia assegnata\"" ;
				a=false;
				break;
			}
			else
			{
				a=true;
			}
		}
		if(a==true)
		{
			messaggio="\"risorsa inserita con succeso\"";
			urr.setUsoRisorse(u);
		}
		
		return messaggio;
		
	}
	
	@Override
	public List<UsoRisorse> getUsoRisorseList(int id)
	{
		return urr.getUsoRisorseList(id);
	}
	@Override
	public String modUsoRisorse(UsoRisorse u)
	{
		String messaggio ="";
		boolean a = true;
		Double ore = u.getOre();
		Double tariffa =u.getRisorse().getTariffa();
		Double costi = (ore*tariffa)*0.80;
	    u.setCosti(costi);
	    Double ricavi = ore*tariffa;
	    u.setRicavi(ricavi);
	    List<UsoRisorse> risorse = urr.getUsoRisorseList();
	    for(int i=0;i<risorse.size();i++)
		{
			if(u.getMese().getId_mese().equals(risorse.get(i).getMese().getId_mese()) && 
			   u.getRisorse().getId_risorse().equals(risorse.get(i).getRisorse().getId_risorse()) &&
			   u.getTipoUsoRisorse().getId_tipo_usorisorse().equals(risorse.get(i).getTipoUsoRisorse().getId_tipo_usorisorse()))
			{
				urr.modUsoRisorse(u);
				messaggio ="\"Modifica avvenuta con successo\"" ;
				a=true;
				break;
			}
			else
			{
				a=false;
			}
		}
	    if(a==false)
	    {
	    	messaggio ="\"Modifica non possibile inserire nuovo\"" ;
	    }
	    return messaggio;
	}
	
	
	
}

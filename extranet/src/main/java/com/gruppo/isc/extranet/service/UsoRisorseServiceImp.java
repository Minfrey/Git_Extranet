package com.gruppo.isc.extranet.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	public String setUsoRisorse(UsoRisorse u) 
	{
		String messaggio ="";
		Double ore = u.getOre();
		Double tariffa =u.getRisorse().getTariffa();
		Double costi = (ore*tariffa)*0.80;
	    u.setCosti(costi);
	    Double ricavi = ore*tariffa;
	    u.setRicavi(ricavi);
	    
	    
	
		Date inizio = u.getCommessa().getInizio();
		System.out.println(inizio);
		Date fine = u.getCommessa().getFine();
		System.out.println(fine);
		Calendar inizioc = new GregorianCalendar();
		inizioc.setTime(inizio);
		Calendar finec = new GregorianCalendar();
		finec.setTime(fine);
		
		
		Integer mesei= inizioc.get(Calendar.MONTH)+1;
		System.out.println("Mese inizio "+mesei);
		Integer mesef= finec.get(Calendar.MONTH)+1;
		System.out.println("Mese fine "+mesef);
		Integer annoi = inizioc.get(Calendar.YEAR);
		System.out.println("Anno inizio "+annoi);
		Integer annof = finec.get(Calendar.YEAR);
		System.out.println("Anno fine "+annof);
		
		Integer mese = u.getMese().getId_mese(); 
		System.out.println("mese commessa "+mese);
		Integer anno = u.getAnno().getNumero();
		System.out.println("anno commessa "+anno);
		
		if(mesei<=mese &&  mesef>=mese && annoi<=anno && annof>=anno)
		{	
				messaggio="\"risorsa inserita con successo\"";
				urr.setUsoRisorse(u);			
		}
		else
		{
			messaggio = "\"data inserita fuori dal periodo della commesa\"";
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
	    
	    Date inizio = u.getCommessa().getInizio();
		System.out.println(inizio);
		Date fine = u.getCommessa().getFine();
		System.out.println(fine);
		Calendar inizioc = new GregorianCalendar();
		inizioc.setTime(inizio);
		Calendar finec = new GregorianCalendar();
		finec.setTime(fine);
		
		
		Integer mesei= inizioc.get(Calendar.MONTH)+1;
		System.out.println("Mese inizio "+mesei);
		Integer mesef= finec.get(Calendar.MONTH)+1;
		System.out.println("Mese fine "+mesef);
		Integer annoi = inizioc.get(Calendar.YEAR);
		System.out.println("Anno inizio "+annoi);
		Integer annof = finec.get(Calendar.YEAR);
		System.out.println("Anno fine "+annof);
		
		Integer mese = u.getMese().getId_mese(); 
		System.out.println("mese commessa "+mese);
		Integer anno = u.getAnno().getNumero();
		System.out.println("anno commessa "+anno);
	    
	    if(mesei<=mese &&  mesef>=mese && annoi<=anno && annof>=anno)
		{
				messaggio ="\"Modifica avvenuta con successo\"" ;
				urr.modUsoRisorse(u);
		}
	    else
	    {
	    	messaggio = "\"data inserita fuori dal periodo della commesa\"";
	    }
	    return messaggio;
	}
	
	@Override
	public List<UsoRisorse> getUsoRisorseByType(int id, int idt)
	{
		 List<UsoRisorse> lista =urr.getUsoRisorseByType(id, idt);
		System.out.println(lista.get(0).getCommessa().getNome()); 
		return lista;
	}
	
	
}

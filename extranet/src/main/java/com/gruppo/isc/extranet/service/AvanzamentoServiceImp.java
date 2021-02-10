package com.gruppo.isc.extranet.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.model.TipoAvanzamento;
import com.gruppo.isc.extranet.repository.AttivitaRepoImp;
import com.gruppo.isc.extranet.repository.AvanzamentoRepoImp;
import com.gruppo.isc.extranet.repository.CommessaRepoImp;


@Service
public class AvanzamentoServiceImp implements AvanzamentoService 
{
	@Autowired
	AvanzamentoRepoImp arr;
	
	@Override
	@Transactional
	public String setAvanzamento(Avanzamento a)
	{
		Integer percentualelocale = a.getPercentuale();
		Double valore = a.getAttivita().getValore();
		Double valoreava = (valore*percentualelocale)/100;
		a.setValore(valoreava);
		
		String messaggio="";
		
		Date inizio = a.getAttivita().getCommessa().getInizio();
		System.out.println(inizio);
		Date fine = a.getAttivita().getCommessa().getFine();
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
		
		Integer mese = a.getMese().getId_mese(); 
		System.out.println("mese commessa "+mese);
		Integer anno = a.getAnno().getNumero();
		System.out.println("anno commessa "+anno);
				
		if(mesei<=mese &&  mesef>=mese && annoi<=anno && annof>=anno)
		{	
			List<Avanzamento> percent = arr.controlloPercentuale(a);
			for(int i=0;i<percent.size();i++)	
			{
				if(percent.get(i).getAnno().getNumero()>=a.getAnno().getNumero());
					if(percent.get(i).getMese().getId_mese()<=a.getMese().getId_mese());
					
			}
			List<Avanzamento> controllo = arr.controlloInserimento(a);
					
					if(controllo.size()>0 && controllo.size()<=1)
					{
						messaggio = "\"Esiste gia un avanzamento di questo tipo in questa data\"";
					}
					else
					{
						arr.setAvanzamento(a);
						messaggio = ("\"Attivita Inserita\"");
					}
					
//					if(a.getPercentuale()<=contperc)
//					{
//						messaggio = ("\"Percentuale minore di una inserita precedentemente in questo avanzamento\"");
//					}
//					if(a.getPercentuale()>=contpercnext)
//					{
//						messaggio = ("\"Percentuale maggiore gia presente in questo avanzamento\"");
//					}
				
		}
		else
		{
			messaggio="\"Data non corretta\"";
		}
//				else
//				{
//					messaggio = ("\"Percentuale minore di una inserita precedentemente in questo avanzamento\"");
//				}
		return messaggio;
	}
	

	
	@Override
	@Transactional
	public String modAvanzamento(Avanzamento a)
	{
		String messaggio="";
		if(a.getConsolida()!=null)
			{
			//calcola valore da percentuale
			Integer percentualelocale = a.getPercentuale();
			Double valore = a.getAttivita().getValore();
			Double valoreava = (valore*percentualelocale)/100;
			a.setValore(valoreava);
			
			
			Integer contperc = 0;
			Integer contpercnext = 0;
			
			List<Avanzamento> percent = arr.controlloPercentuale(a);
			for(int i=0;i<percent.size();i++)
			{
				if(percent.get(i).getPercentuale()>contperc)
				{
					contperc=percent.get(i).getPercentuale();
					//quando l'id e lo stesso di quello da modificare allora 
					if(percent.get(i).getId_avanzamento()==a.getId_avanzamento())
					{
						contpercnext=percent.get(i+1).getPercentuale();
						break;
					}
			}
				
				
			}
			
			if(a.getPercentuale()>contperc && a.getPercentuale()<contpercnext)
			{
		
				arr.modAvanzamento(a);
				messaggio = ("\"Attivita modificata\"");
			}
			if(a.getPercentuale()<=contperc)
			{
				messaggio = ("\"Percentuale minore di una inserita precedentemente in questo avanzamento\"");
			}
			if(a.getPercentuale()>=contpercnext)
			{
				messaggio = ("\"Percentuale maggiore gia presente in questo avanzamento\"");
			}
		}
		else
		{
			messaggio = ("\"Avanzamento consolidato non e possibile modificarlo\"");
		}
		return messaggio;
	}

	
	
	public List<Avanzamento> getListAvanzamento()
	{
		return arr.getAvanzamentoList();
	}
	
//	public List<Object> getAvanzamentoByAttivita(int id)
//	{	
//		return arr.getAvanzamentoByAttivita(id);
//	}
	
	public List<Avanzamento> getAvanzamentoByAttivita2(int id)
	{	
		List<Avanzamento> a = arr.getAvanzamentoByAttivita2(id);
		System.out.println(a.get(0).getAnno().getNumero());
		return arr.getAvanzamentoByAttivita2(id);
	}
	
	public List<Avanzamento> getAvanzamentoByCommessaType(int id, int idt)
	{
		return arr.getAvanzamentoByCommessaType(id, idt);
	}
	
	
}

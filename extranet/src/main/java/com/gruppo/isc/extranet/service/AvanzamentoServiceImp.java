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
	
	@Autowired 
	CommessaRepoImp cri;
	
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
		
//		boolean bool;
//		
//		int maggiorminore = 0;
//		int minormaggiore = 100;
//		Avanzamento minoreav = new Avanzamento();
//		Avanzamento maggioreav = new Avanzamento();
		
		//controlla se la data dell'avanzamento e nei termini della commessa
		if(mesei<=mese &&  mesef>=mese && annoi<=anno && annof>=anno)
		{	
			arr.setAvanzamento(a);
			messaggio = ("\"Attivita minore Inserita\"");
			if(a.getTipoAvanzamento().getId_tipo_avanzamento()==2)
			{
				// prendo id della commessa e inserisco il valore dell'attivita nel fatturato essendo id 2 il computo dei ricavi
				// aggiungere fattura
				cri.fatturatoCommessa(a.getAttivita().getValore(), a.getAttivita().getCommessa().getId_commessa());
			}
		}
/*			List<Avanzamento> percent = arr.controlloPercentuale(a);
		for(int i=0;i<percent.size();i++)	
			{
				System.out.println("Attivita "+percent.get(i).getAttivita().getDescrizione()+" "+i);
				
				if(a.getAnno().getNumero()==percent.get(i).getAnno.getNumero())
				{
					//Se l'anno e uguale a l'anno nel dato indice e mese e percentuali passate sono minori di quelle nel dato indice
					if(a.getMese().getId_mese()<percent.get(i).getMese().getId_mese() &&  a.getPercentuale()<percent.get(i).getPercentuale()))
					{
						//in caso positivo l'avanzamento con percentuale maggiore tra quelli con percentuale e mese minori viene salvato in una variabile
						if(maggiorminore<percent.get(i).getPercentuale())
						{
							maggiorminore=percent.get(i).getPercentuale();
							maggioreav= percent.get(i);
						}
					}
					//Se l'anno e uguale a l'anno nel dato indice e mese e percentuali passate sono maggiori di quelle nel dato indice
	 				if(a.getMese().getId_mese()>percent.get(i).getMese().getId_mese() &&  a.getPercentuale()>percent.get(i).getPercentuale()))
					{
						//in caso positivo l'avanzamento con percentuale minori tra quelli con percentuale e mese maggiore viene salvato in una variabile
						if(minormaggiore>percent.get(i).getPercentuale)
						{
							minormaggiore=percent.get(i).getPercentuale();
							minoreav= percent.get(i);
						}
					}
				}
				//se anno, mese e percentuale passati sono minori di quelli nel dato indice 
				if(a.getAnno().getNumero()<percent.get(i).getAnno().getNumero() && 
				   a.getMese().getId_mese()<percent.get(i).getMese().getId_mese() &&
			       a.getPercentuale()<percent.get(i).getPercentuale())
				{
					System.out.println("percentuale corrente Mdm :"+a.getPercentuale());
					//l'avanzamento con percentuale maggiore degli avanzamenti con anno mese e percentuale minori e salvato in una variabile
					if(maggiorminore<percent.get(i).getPercentuale())
					{
						maggiorminore=percent.get(i).getPercentuale();
						maggiormin= percent.get(i);
					}
				}
				//se anno, mese e percentuale passati sono maggiori di quelli nel dato indice 
				if(a.getAnno().getNumero()>percent.get(i).getAnno().getNumero() && 
				   a.getMese().getId_mese()>percent.get(i).getMese().getId_mese() &&
				   a.getPercentuale()>percent.get(i).getPercentuale())
				{
					//l'avanzamento con percentuale minore degli avanzamenti con anno mese e percentuale maggiori e salvato in una variabile
					System.out.println("percentuale corrente mdM:"+a.getPercentuale());
					if(minormaggiore>percent.get(i).getPercentuale())
					{
						minormaggiore=percent.get(i).getPercentuale();
						minoremag= percent.get(i);
					}
				}
				
			}
			List<Avanzamento> controllo = arr.controlloInserimento(a);
					
					if(controllo.size()>0 && controllo.size()<=1)
					{
						messaggio = "\"Esiste gia un avanzamento di questo tipo in questa data\"";
					}
					else
					{
						System.out.println(maggioreav);
						if(maggioreav.getAnno()!=null)
						{
							if(
							// se anno mese e percentuale dell'avanzamento passato sono comprese tra il maggiore degli avanzamenti con anno mese e percentuale minori e tra il minore degli avanzamenti con anno mese e percentuale maggiori
									a.getAnno().getNumero()>=maggioremin.getAnno().getNumero() && a.getAnno().getNumero()<=minoremag.getAnno().getNumero() &&
									a.getMese().getId_mese()>maggioremin.getMese().getId_mese() && a.getMese().getId_mese()<minoremag.getMese().getId_mese() &&
									a.getPercentuale()>maggioremin.getPercentuale() && a.getPercentuale()<minoremag.getPercentuale())
							  )
							{
								arr.setAvanzamento(a);
								messaggio = ("\"Attivita Inserita\"");
							}
						}
						

				
		}*/	
		
	
		else
		{
			messaggio="\"Data non corretta\"";
		}

		return messaggio;
	}
	

	
	@Override
	@Transactional
	public String modAvanzamento(Avanzamento a)
	{
		String messaggio="";
		Avanzamento consolid = arr.getAvanzamentoByID(a.getId_avanzamento());
		if(consolid.getConsolida()==null)
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
						if(i+1<percent.size())
						{
							contpercnext=percent.get(i+1).getPercentuale();
							break;
						}
						else
						{
							contpercnext=(a.getPercentuale()+1);
						}
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
	
	@Transactional
	public String consolidaav(Avanzamento a)
	{
		String messaggio = "";
		Avanzamento b = arr.consolidav(a);
		if(b.getConsolida()!=null)
		{
			messaggio="\"Consolidato\"";
		}
		else
		{
			messaggio="\"Non Consolidato\"";
		}
		return messaggio;
	}
	
}

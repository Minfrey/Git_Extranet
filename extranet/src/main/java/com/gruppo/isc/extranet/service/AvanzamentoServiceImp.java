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
			Calendar alfa = new GregorianCalendar();
			alfa.set(a.getAnno().getNumero(), (a.getMese().getId_mese()-1), 15);	
			java.sql.Date javaSqlDate = new java.sql.Date(alfa.getTime().getTime());
			a.setData(javaSqlDate);
			
			System.out.println(a.getData());
				
		Integer percentualelocale = a.getPercentuale();
		Double valore = a.getAttivita().getValore();
		Double valoreava = (valore*percentualelocale)/100;
		a.setValore(valoreava);
		
		String messaggio="";
		
		java.sql.Date inizio = a.getAttivita().getCommessa().getInizio();
		System.out.println(inizio);
		java.sql.Date fine = a.getAttivita().getCommessa().getFine();
		System.out.println(fine);
		
		if(inizio.before(a.getData()) && fine.after(a.getData()))
		{
			if(arr.controlloDuplicatiInserimento(a).size()==0)
			{
				if(a.getTipoAvanzamento().getId_tipo_avanzamento()==2 || a.getTipoAvanzamento().getId_tipo_avanzamento()==3)
				{
					List controllo = arr.controlloInserimento(a);
					if(controllo.size()>=1 && a.getTipoAvanzamento().getId_tipo_avanzamento()==2)
					{
						messaggio = ("\"Sono già stati inseriti i ricavi di questa attività\"");
					}
					else if(controllo.size()>=1 && a.getTipoAvanzamento().getId_tipo_avanzamento()==3)
					{
						messaggio = ("\"È già stato inserito un preventivo per i ricavi di questa attività\"");
					}
					else
					{
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							arr.setAvanzamento(a);
							messaggio = ("\"Attivita Inserita\"");
							if(a.getTipoAvanzamento().getId_tipo_avanzamento()==2)
							{
								// prendo id della commessa e inserisco il valore dell'attivita nel fatturato essendo id 2 il computo dei ricavi
								// aggiungere fattura
								cri.fatturatoCommessa(a.getAttivita().getValore(), a.getAttivita().getCommessa().getId_commessa());
							}
					}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
					
					}
					//se esite un avanzamento dello stesso tipo con lo stesso nome della stessa commessa allora errore
				
				else
				{
					/////////////////////////////////////////
					boolean controlloprec = false;
					List<Avanzamento> percent = arr.controlloPercentuale(a);
					Avanzamento massimominimo = new Avanzamento();
					Avanzamento minimomassimo = new Avanzamento();
					for(int i=0;i<percent.size();i++)
					{
						if(a.getData().before(percent.get(i).getData())/* && a.getPercentuale()<percent.get(i).getPercentuale()*/)
						{
							if(minimomassimo.getData()==null)
							{
								minimomassimo = percent.get(i);
							}
							else if(minimomassimo.getData().after(percent.get(i).getData())/*&& minimomassimo.getPercentuale()>percent.get(i).getPercentuale()*/)
							{
								minimomassimo = percent.get(i);
							}
						}
						else if(a.getData().after(percent.get(i).getData())/* && a.getPercentuale()>percent.get(i).getPercentuale()*/)
						{
							if(massimominimo.getData()==null)
							{
								massimominimo = percent.get(i);
							}
							else if(massimominimo.getData().before(percent.get(i).getData())/*&& massimominimo.getPercentuale()<percent.get(i).getPercentuale()*/)
							{
								massimominimo = percent.get(i);
							}
						}
					}
					System.out.println("estremo inferiore "+massimominimo.getData()+" "+massimominimo.getPercentuale());
					System.out.println("inserito "+a.getData()+" "+a.getPercentuale());
					System.out.println("estremo superiore "+minimomassimo.getData()+" "+minimomassimo.getPercentuale());
					if(massimominimo.getData()==null && minimomassimo.getData()==null)
					{
						System.out.println("liberoooooooooooooooooooo");
						arr.setAvanzamento(a);
						messaggio = ("\"Attivita Inserita\"");
					}
					else if(massimominimo.getData()==null && a.getData().before(minimomassimo.getData()) && a.getPercentuale()<minimomassimo.getPercentuale() )
					{
						System.out.println("estremo inferiore nulloooooooooooo");
						arr.setAvanzamento(a);
						messaggio = ("\"Attivita Inserita\"");
					}
					else if(minimomassimo.getData()==null && a.getData().after(massimominimo.getData()) && a.getPercentuale()>massimominimo.getPercentuale())
					{
						System.out.println("estremo superiore nulloooooooooooo");
						arr.setAvanzamento(a);
						messaggio = ("\"Attivita Inserita\"");
					}
					///////////////////////////////
					else if (massimominimo.getData()!=null   
							&& massimominimo.getData().before(a.getData())  
							&& minimomassimo.getData()!=null
							&& a.getData().before(minimomassimo.getData()) 
							 && massimominimo.getPercentuale()<a.getPercentuale() 
							 && a.getPercentuale()<minimomassimo.getPercentuale())
					{
						System.out.println("nessuno e nulloooooooooo");
						arr.setAvanzamento(a);
						messaggio = ("\"Attivita Inserita\"");
					}
					else
					{
						System.out.println(massimominimo.getData().before(a.getData()));
//						System.out.println(a.getData().before(minimomassimo.getData()));
						System.out.println(massimominimo.getPercentuale()<a.getPercentuale());
//						System.out.println(a.getPercentuale()<minimomassimo.getPercentuale());
						messaggio = ("\"Errore\"");
					}
				}
			}
			else
			{
				messaggio=	("\"Attivita Duplicata\"");
			}
			
		}
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
			Calendar alfa = new GregorianCalendar();
			alfa.set(a.getAnno().getNumero(), (a.getMese().getId_mese()-1), 15);	
			java.sql.Date javaSqlDate = new java.sql.Date(alfa.getTime().getTime());
			a.setData(javaSqlDate);
			
			//calcola valore da percentuale
			Integer percentualelocale = a.getPercentuale();
			Double valore = a.getAttivita().getValore();
			Double valoreava = (valore*percentualelocale)/100;
			a.setValore(valoreava);
			
			

			/////////////////////////////////////////
			boolean controlloprec = false;
			List<Avanzamento> percent = arr.controlloPercentuale(a);
			Avanzamento massimominimo = new Avanzamento();
			Avanzamento minimomassimo = new Avanzamento();
			for(int i=0;i<percent.size();i++)
			{
				if(a.getMese().getId_mese()==percent.get(i).getMese().getId_mese() && a.getAnno().getId_anno()==percent.get(i).getAnno().getId_anno())
				{
					continue;
				}
				if(a.getData().before(percent.get(i).getData())/* && a.getPercentuale()<percent.get(i).getPercentuale()*/)
				{
					if(minimomassimo.getData()==null)
					{
						minimomassimo = percent.get(i);
					}
					else if(minimomassimo.getData().after(percent.get(i).getData())/*&& minimomassimo.getPercentuale()>percent.get(i).getPercentuale()*/)
					{
						minimomassimo = percent.get(i);
					}
				}
				else if(a.getData().after(percent.get(i).getData())/* && a.getPercentuale()>percent.get(i).getPercentuale()*/)
				{
					if(massimominimo.getData()==null)
					{
						massimominimo = percent.get(i);
					}
					else if(massimominimo.getData().before(percent.get(i).getData())/*&& massimominimo.getPercentuale()<percent.get(i).getPercentuale()*/)
					{
						massimominimo = percent.get(i);
					}
				}
			}
			System.out.println("estremo inferiore "+massimominimo.getData()+" "+massimominimo.getPercentuale());
			System.out.println("inserito "+a.getData()+" "+a.getPercentuale());
			System.out.println("estremo superiore "+minimomassimo.getData()+" "+minimomassimo.getPercentuale());
			if(massimominimo.getData()==null && minimomassimo.getData()==null)
			{
				System.out.println("liberoooooooooooooooooooo");
				arr.modAvanzamento(a);
				messaggio = ("\"Attivita Inserita\"");
			}
			else if(massimominimo.getData()==null && a.getData().before(minimomassimo.getData()) && a.getPercentuale()<minimomassimo.getPercentuale() )
			{
				System.out.println("estremo inferiore nulloooooooooooo");
				arr.modAvanzamento(a);
				messaggio = ("\"Attivita Inserita\"");
			}
			else if(minimomassimo.getData()==null && a.getData().after(massimominimo.getData()) && a.getPercentuale()>massimominimo.getPercentuale())
			{
				System.out.println("estremo superiore nulloooooooooooo");
				arr.modAvanzamento(a);
				messaggio = ("\"Attivita Inserita\"");
			}
			///////////////////////////////
			else if (massimominimo.getData().before(a.getData()) 
					&& a.getData().before(minimomassimo.getData())
					 && massimominimo.getPercentuale()<a.getPercentuale() 
					 && a.getPercentuale()<minimomassimo.getPercentuale())
			{
				System.out.println("nessuno e nulloooooooooo");
				arr.modAvanzamento(a);
				messaggio = ("\"Attivita Inserita\"");
			}
			else
			{
				System.out.println(massimominimo.getData().before(a.getData()));
				System.out.println(a.getData().before(minimomassimo.getData()));
				System.out.println(massimominimo.getPercentuale()<a.getPercentuale());
				System.out.println(a.getPercentuale()<minimomassimo.getPercentuale());
				messaggio = ("\"Errore\"");
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
		Integer numcom = a.getAttivita().getCommessa().getId_commessa();
		if(a.getTipoAvanzamento().getId_tipo_avanzamento()==3)
		{
			cri.previsionefatturatoCommessa(a.getAttivita().getValore(), numcom);
		}
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

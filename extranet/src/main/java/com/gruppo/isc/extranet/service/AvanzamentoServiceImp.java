package com.gruppo.isc.extranet.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
//		List<Avanzamento> lista = this.getListAvanzamento();
//		
//		ArrayList<Avanzamento> list = new ArrayList<Avanzamento>();
//		for(int i=0;i<lista.size();i++)
//		{
//			System.out.println(lista.get(i).getId_avanzamento());/*+""+(lista.get(i).getMese().getNome())*/
//		 list.add(lista.get(i));
//		}
//		
//		Integer totale=percentualelocale;
//		System.out.println("il totale e  fuoti dal ciclo e"+totale);
//		boolean bool = false;
//		for(int i=0;i<list.size();i++)
//		{
//			Avanzamento avanzamento = list.get(i);
//			Integer percentuale = avanzamento.getPercentuale();
//			if(a.getAttivita().getCommessa().getId_commessa().equals(avanzamento.getAttivita().getCommessa().getId_commessa()) 
//					&& a.getTipoAvanzamento().getId_tipo_avanzamento().equals(avanzamento.getTipoAvanzamento().getId_tipo_avanzamento()) 
//					&& a.getAttivita().getId_attivita().equals(avanzamento.getAttivita().getId_attivita()) 
//					&& a.getMese().getId_mese().equals(avanzamento.getMese().getId_mese())
//					&& a.getAnno().getId_anno().equals(avanzamento.getAnno().getId_anno()))
//				
//			{
//				//Attivita già inserita se vuoi eseguire la modifica premi il tasto
//				messaggio = ("\"modifica\"");
//				bool = false ;
//				break;
//			}
//			if(a.getAttivita().getCommessa().getId_commessa().equals(avanzamento.getAttivita().getCommessa().getId_commessa()) && a.getTipoAvanzamento().getId_tipo_avanzamento().equals(avanzamento.getTipoAvanzamento().getId_tipo_avanzamento()) && a.getAttivita().getId_attivita().equals(avanzamento.getAttivita().getId_attivita()))
//			{
//				
//				totale=totale+percentuale;
//				System.out.println("il totale e "+totale);
//				if(totale>100)
//				{
//					messaggio = ("\"Avanzamento superiore al 100\"");
//					bool = false;
//					break;
//				}
//				else
//				{
//					bool = true;
//				}
//			}
//			else
//			{
//				bool = true;
//			}
//			
//			
//		}
//		if(bool==true)
//		{
//			
			arr.setAvanzamento(a);
			messaggio = ("\"Attivita Inserita\"");
//		}
//		
		return messaggio;
	}
	
	@Override
	@Transactional
	public String modAvanzamento(Avanzamento a)
	{
		//calcola valore da percentuale
		Integer percentualelocale = a.getPercentuale();
		Double valore = a.getAttivita().getValore();
		Double valoreava = (valore*percentualelocale)/100;
		a.setValore(valoreava);
		String messaggio="";
		
//		//prendi lista avanzamenti
//		List<Avanzamento> lista = this.getListAvanzamento();
//		
//		//inserisci lista avanzamente in un arraylist
//		ArrayList<Avanzamento> list = new ArrayList<Avanzamento>();
//		for(int i=0;i<lista.size();i++)
//		{
//		 list.add(lista.get(i));
//		}
//		
//		//calcola inzio totale percentuale
//		Integer totale=percentualelocale;
//		System.out.println("il totale e  fuoti dal ciclo e"+totale);
//		boolean bool = false;
//		for(int i=0;i<list.size();i++)
//		{
//			Avanzamento avanzamento = list.get(i);
//			Integer percentuale = avanzamento.getPercentuale();
//			if(a.getAttivita().getCommessa().getId_commessa().equals(avanzamento.getAttivita().getCommessa().getId_commessa()) 
//					&& a.getTipoAvanzamento().getId_tipo_avanzamento().equals(avanzamento.getTipoAvanzamento().getId_tipo_avanzamento()) 
//					&& a.getAttivita().getId_attivita().equals(avanzamento.getAttivita().getId_attivita())
//					&& a.getMese().getId_mese().equals(avanzamento.getMese().getId_mese())
//					&& a.getAnno().getId_anno().equals(avanzamento.getAnno().getId_anno()))
//			{
//				a.setId_avanzamento(avanzamento.getId_avanzamento());
//				if(a.getAttivita().getCommessa().getId_commessa().equals(avanzamento.getAttivita().getCommessa().getId_commessa()) && a.getTipoAvanzamento().getId_tipo_avanzamento().equals(avanzamento.getTipoAvanzamento().getId_tipo_avanzamento()) && a.getAttivita().getId_attivita().equals(avanzamento.getAttivita().getId_attivita()))
//				{
//					
//					totale=totale+percentuale;
//					System.out.println("il totale e "+totale);
//					if(totale>100)
//					{
//						messaggio = ("\"Avanzamento superiore al 100\"");
//						bool = false;
//						break;
//					}
//					else
//					{
//						bool = true;
//					}
//				}
//				else
//				{
//					bool = true;
//				}
//				
//				
//			}
//			}
//			
//		if(bool==true)
//		{
//			
			arr.modAvanzamento(a);
			messaggio = ("\"Attivita modificata\"");
//		}
//		
		return messaggio;
	}

	
	
	public List<Avanzamento> getListAvanzamento()
	{
		return arr.getAvanzamentoList();
	}
	
	public List<Object> getAvanzamentoByAttivita(int id)
	{	
		return arr.getAvanzamentoByAttivita(id);
	}
	
	public List<Avanzamento> getAvanzamentoByAttivita2(int id)
	{	
		List<Avanzamento> a = arr.getAvanzamentoByAttivita2(id);
		System.out.println(a.get(0).getAnno());
		return arr.getAvanzamentoByAttivita2(id);
	}
	
	
}

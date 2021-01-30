package com.gruppo.isc.extranet.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Avanzamento;
import com.gruppo.isc.extranet.repository.AvanzamentoRepoImp;


@Service
public class AvanzamentoServiceImp implements AvanzamentoService 
{
	@Autowired
	AvanzamentoRepoImp arr;
	
	@Override
	@Transactional
	public Avanzamento setAvanzamento(Avanzamento a)
	{
		Integer percentuale = a.getPercentuale();
		Double valore = a.getAttivita().getValore();
		Double valoreava = (valore*percentuale)/100;
		a.setValore(valoreava);
		return arr.setAvanzamento(a);
	}
}

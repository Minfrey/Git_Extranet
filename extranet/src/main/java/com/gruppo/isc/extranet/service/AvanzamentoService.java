package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Avanzamento;

public interface AvanzamentoService 
{
	public String setAvanzamento(Avanzamento a);
	
	public String modAvanzamento(Avanzamento a);
	
	public List<Avanzamento> getListAvanzamento();
}

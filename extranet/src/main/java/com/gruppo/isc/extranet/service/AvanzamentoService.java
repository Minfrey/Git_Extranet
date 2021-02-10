package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;

public interface AvanzamentoService 
{
	public String setAvanzamento(Avanzamento a);
	
	public String modAvanzamento(Avanzamento a);
	
	public List<Avanzamento> getListAvanzamento();

	public List<Avanzamento> getAvanzamentoByAttivita2(int id);
	public List<Avanzamento> getAvanzamentoByCommessaType(int id, int idt);
}

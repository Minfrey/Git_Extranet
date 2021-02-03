package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;

public interface AvanzamentoRepo
{
	public Avanzamento setAvanzamento(Avanzamento a);
	public List<Avanzamento> getAvanzamentoList();
	public Avanzamento modAvanzamento(Avanzamento a);
	public List<Object> getAvanzamentoByAttivita(int id);
	public List<Avanzamento> getAvanzamentoByAttivita2(int id);
}

package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Avanzamento;

public interface AvanzamentoRepo
{
	public Avanzamento setAvanzamento(Avanzamento a);
	public List<Avanzamento> getAvanzamentoList();
	public Avanzamento modAvanzamento(Avanzamento a);
}

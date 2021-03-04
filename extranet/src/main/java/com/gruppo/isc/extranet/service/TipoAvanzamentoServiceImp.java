package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.repository.TipoAvanzamentoRepo;

@Service
public class TipoAvanzamentoServiceImp implements TipoAvanzamentoService {

	@Autowired
	TipoAvanzamentoRepo ta;

	@Override
	public List getAllTipiAvanzamento() {
		return ta.getAllTipiAvanzamento();
	}
	
	
	
}

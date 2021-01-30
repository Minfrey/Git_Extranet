package com.gruppo.isc.extranet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.TipoUsoRisorse;



@Service
public class TipoUsoRisorseServiceImp implements TipoUsoRisorseService 
{
	@Autowired
	TipoUsoRisorseServiceImp turr;
	
	@Override
	public TipoUsoRisorse getTipoUsoRisorseId(int id)
	{
		return turr.getTipoUsoRisorseId(id);			
	}
}

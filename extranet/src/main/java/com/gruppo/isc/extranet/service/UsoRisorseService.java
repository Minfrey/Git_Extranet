package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.gruppo.isc.extranet.model.UsoRisorse;

public interface UsoRisorseService
{
	public String setUsoRisorse(UsoRisorse u); 
	
	public List<UsoRisorse> getUsoRisorseList(int id);
	
	public String modUsoRisorse(UsoRisorse u);
	
	public List<UsoRisorse> getUsoRisorseByType(int id, int idt);
	
	public String consolidaUso(UsoRisorse u);
}

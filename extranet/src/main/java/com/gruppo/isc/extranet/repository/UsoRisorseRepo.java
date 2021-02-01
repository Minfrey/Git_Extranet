package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.UsoRisorse;

public interface UsoRisorseRepo 
{
	public void setUsoRisorse(UsoRisorse u);
	
	public List<UsoRisorse> getUsoRisorseList(int id);
	
	public void modUsoRisorse(UsoRisorse u);
	
	public List<UsoRisorse> getUsoRisorseList();
}

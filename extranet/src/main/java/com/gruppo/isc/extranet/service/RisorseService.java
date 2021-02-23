package com.gruppo.isc.extranet.service;

import java.util.List;

import com.gruppo.isc.extranet.model.Risorse;

public interface RisorseService 
{
	public List<Risorse> getRisorseList();
	public String setRisorse(Risorse r);
	public String modRisorse(Risorse r);
	public void schedulRisorse(String a);
}

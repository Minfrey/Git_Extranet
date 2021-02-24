package com.gruppo.isc.extranet.repository;

import java.util.List;

import com.gruppo.isc.extranet.model.Risorse;

public interface RisorseRepo 
{
	public List<Risorse> getRisorseList();
	public List<Risorse> getRisorseListActive();
	public Risorse setRisorse(Risorse r);
	public Risorse modRisorse(Risorse r);
	public void schedulRisorse(String a);
}

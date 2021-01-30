package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Risorse;
import com.gruppo.isc.extranet.repository.RisorseRepoImp;




@Service
public class RisorseServiceImp implements RisorseService 
{
	@Autowired
	RisorseRepoImp rr;
	
	@Override
	public List<Risorse> getRisorseList()
	{
		return rr.getRisorseList();
	}
	
	
}

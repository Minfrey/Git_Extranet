package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Anno;
import com.gruppo.isc.extranet.repository.AnnoRepoImp;
@Service
public class AnnoServiceImp implements AnnoService
{
	@Autowired
	AnnoRepoImp ari;
	
	public List<Anno> getAnno()
	{
		return ari.getAnno();
	}
}

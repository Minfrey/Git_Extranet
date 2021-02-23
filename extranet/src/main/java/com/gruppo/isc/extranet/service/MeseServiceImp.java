package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Mese;
import com.gruppo.isc.extranet.repository.MeseRepoImp;


@Service
public class MeseServiceImp implements MeseService 
{
	@Autowired
	MeseRepoImp mr;
	
	@Override
	public List<Mese> getMeseList()
	{
		return mr.getMeseList();
	}
}

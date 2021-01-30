package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gruppo.isc.extranet.model.Mese;
import com.gruppo.isc.extranet.repository.MeseRepoImp;


public interface MeseService
{
	public List<Mese> getMeseList();

}

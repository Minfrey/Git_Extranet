package com.gruppo.isc.extranet.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ProvaRepository 
{
	@PersistenceContext
	EntityManager em;
}

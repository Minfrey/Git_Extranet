package com.gruppo.isc.extranet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gruppo.isc.extranet.model.Task;


@Repository
public class TaskRepoImp implements TaskRepo
{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Task> getTaskList()
	{
		Query q = em.createQuery("SELECT t FROM Task t");
		return q.getResultList();
	}

}

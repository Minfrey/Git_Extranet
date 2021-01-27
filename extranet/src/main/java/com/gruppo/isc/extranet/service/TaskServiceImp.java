package com.gruppo.isc.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruppo.isc.extranet.model.Task;
import com.gruppo.isc.extranet.repository.TaskRepoImp;

@Service
public class TaskServiceImp implements TaskService {

	@Autowired
	TaskRepoImp tri;
	
	@Override
	public List<Task> getTaskList() 
	{
		return tri.getTaskList();
	}

}

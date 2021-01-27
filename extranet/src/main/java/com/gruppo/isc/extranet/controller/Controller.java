package com.gruppo.isc.extranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Task;
import com.gruppo.isc.extranet.service.TaskService;



@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class Controller 
{
	@Autowired
	TaskService ts;
	
	@GetMapping("task")
    public ResponseEntity<List<Task>> getTaskList()
	{
		List<Task> lista = ts.getTaskList();
		return new ResponseEntity<List<Task>>(lista,HttpStatus.OK);
	}
}

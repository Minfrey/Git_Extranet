package com.gruppo.isc.extranet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Task;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	Task ta;

	@GetMapping
	public ResponseEntity<List<Task>> getPersonaList(){
		
		List<Task> lista = new ArrayList<Task>();
		ta.setNome("app");
		lista.add(ta);

		return new ResponseEntity<List<Task>>(lista,HttpStatus.OK);
	}
}

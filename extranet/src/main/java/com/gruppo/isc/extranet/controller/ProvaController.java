package com.gruppo.isc.extranet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins =  "http://localhost:4200")
@RequestMapping("/prova")
public class ProvaController {

	
	public class PersonaController {
		
//		@Autowired
//		PersonaService ps;
		
		

		@GetMapping
		public ResponseEntity<List<String>> getPersonaList(){
			
			List<String> lista = new ArrayList<String>();
			lista.add("alessio");
			lista.add("miao");
	
			return new ResponseEntity<List<String>>(lista,HttpStatus.OK);
		}
	}
}

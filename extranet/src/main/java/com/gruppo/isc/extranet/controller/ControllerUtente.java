package com.gruppo.isc.extranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.service.UtenteService;

@RestController
@RequestMapping("utenti")
@CrossOrigin(origins =  "http://localhost:4200")
public class ControllerUtente {

	@Autowired 
	UtenteService us;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAllUtenti()
	{
		List<Utente> lista = us.getAllUtenti();
		return new ResponseEntity<List<Utente>>(lista,HttpStatus.OK);
	}
	
	@PostMapping("/crea")
	public void creaUtente(@RequestBody Utente u)
	{
		us.creaUtente(u);
	}
}

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
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.service.AmministratoreUtilities;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
@RequestMapping("/amministratore")
public class AmministratoreController {

	@Autowired
	AmministratoreUtilities au;
	
	@GetMapping
	public ResponseEntity<List<Utente>> getAllUtenti()
	{
		List<Utente> lista = au.getAllUtenti();
		return new ResponseEntity<List<Utente>>(lista,HttpStatus.OK);
	}
	
	
	@PostMapping("/creaUtente")
	public ResponseEntity<Utente> creaUtente(@RequestBody Utente u)
	{
		Utente utente = au.creaUtente(u);
		return new ResponseEntity<Utente>(utente,HttpStatus.OK);
	}

	
	
	
	@PostMapping("/accessoAmministratore")
	public ResponseEntity<Boolean> accessoAmministratore(@RequestBody String username, String password)
	{
		Boolean accesso = au.accessoAmministratore(username, password);
		return new ResponseEntity<Boolean> (accesso,HttpStatus.OK);
	}
	
	
	@PostMapping("/cercaUtente")
	public ResponseEntity<Utente> cercaUtente(@RequestBody String username)
	{
		Utente u = au.cercaUtente(username);
		return new ResponseEntity<Utente>(u,HttpStatus.OK);
	}
	
	
	
}

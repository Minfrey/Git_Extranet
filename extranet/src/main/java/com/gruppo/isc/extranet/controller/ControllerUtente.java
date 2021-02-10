package com.gruppo.isc.extranet.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Gruppo;
import com.gruppo.isc.extranet.model.Utente;
import com.gruppo.isc.extranet.service.UtenteService;

@RestController
@RequestMapping("utenti")
@CrossOrigin(origins =  "http://localhost:4200")
public class ControllerUtente {

	@Autowired 
	UtenteService us;
	
	//*****METODO FINITO E FUNZIONANTE**********
	@GetMapping
	public ResponseEntity<List<Utente>> getAllUtenti(@RequestParam String descrizione)
	{
		List<Utente> lista = us.getAllUtenti(descrizione);
		return new ResponseEntity<List<Utente>>(lista,HttpStatus.OK);
	}
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PostMapping("/accesso")
	public ResponseEntity<Utente> accessoUtenti(@RequestBody Utente u)
	{
		Utente utente = us.accesso(u);
		return new ResponseEntity<Utente>(utente, HttpStatus.OK);
	}
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PutMapping("/modificaPassword")
	public ResponseEntity<Boolean> modificaPassword(@RequestBody Utente u)
	{
		System.out.println("primo accesso = "+u.getPrimo_accesso());
		Boolean modifica = us.modificaPassword(u);
		return new ResponseEntity<Boolean>(modifica,HttpStatus.OK);
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@GetMapping("/tuttiGruppi")
	public ResponseEntity<List<Gruppo>> getAllGruppi()
	{
		List<Gruppo> lista = us.getAlleGruppi();
		return new ResponseEntity<List<Gruppo>>(lista, HttpStatus.OK);
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PutMapping("/disabilita")
	public ResponseEntity<Boolean> disabilitaUtente(@RequestBody Utente u)
	{
		Boolean disabilita = us.disabilitaUtente(u);
		return new ResponseEntity<Boolean>(disabilita, HttpStatus.OK);
	}

	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@GetMapping("/cercaUtente")
	public ResponseEntity<Utente> cercaUtente(@RequestBody Utente u)
	{
		Utente utente = us.cercaUtente(u);
		return new ResponseEntity<Utente>(utente, HttpStatus.OK);
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PutMapping("/resetPassword")
	public ResponseEntity<Boolean> resetPassword(@RequestBody Utente u)
	{
		Boolean reset = us.resetPassword(u);
		return new ResponseEntity<Boolean>(reset, HttpStatus.OK);
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PostMapping("/confrontaPassword")
	public ResponseEntity<Boolean> confrontaPassword(@RequestBody Utente u)
	{
		Boolean confronto = us.confrontaPassword(u);
		return new ResponseEntity<Boolean>(confronto, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/crea")
	public void creaUtente(@RequestBody Utente u)
	{
		us.creaUtente(u);
	}	
}

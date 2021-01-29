package com.gruppo.isc.extranet.controller;

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
	public ResponseEntity<List<Utente>> getAllUtenti(String descrizione)
	{
		List<Utente> lista = us.getAllUtenti(descrizione);
		return new ResponseEntity<List<Utente>>(lista,HttpStatus.OK);
	}
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PostMapping("/accesso")
	public ResponseEntity<Boolean> accessoUtenti(@RequestBody Utente u)
	{
		Boolean accesso = us.accesso(u);
		return new ResponseEntity<Boolean>(accesso, HttpStatus.OK);
	}
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PutMapping("/modificaPassword")
	public ResponseEntity<Boolean> modificaPassword(@RequestBody Utente u)
	{
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
	@PostMapping("/crea")
	public void creaUtente(@RequestBody Utente u)
	{
		us.creaUtente(u);
	}
	
	
	
	
	
	
	
	
}

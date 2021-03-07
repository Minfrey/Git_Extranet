package com.gruppo.isc.extranet.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Abilitazioni;
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
	@GetMapping("/{descrizione}")
	public ResponseEntity<List<Utente>> getAllUtenti(@PathVariable String descrizione)
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
	@GetMapping("/cercaUtente/{cerca}")
	public ResponseEntity<List<Utente>> cercaUtente(@PathVariable String cerca)
	{
		List<Utente> utente = us.cercaUtente(cerca);
		return new ResponseEntity<List<Utente>>(utente, HttpStatus.OK);
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
	
	
	//*****METODO FINITO E FUNZIONANTE**********
	@GetMapping("/cercaUtenteGruppo/{username}/{gruppo}")
	public ResponseEntity<List<Utente>> cercaUtenteDiGruppo (@PathVariable String username, @PathVariable String gruppo)
	{
		List<Utente> utenteCercato = us.cercaUtenteDiGruppo(username, gruppo);
		return new ResponseEntity<List<Utente>>(utenteCercato, HttpStatus.OK);
	}
	
	//*****METODO FINITO E FUNZIONANTE**********
	@PostMapping("/crea")
	public ResponseEntity<Boolean> creaUtente(@RequestBody Utente u)
	{
		Boolean creato = us.creaUtente(u);
		return new ResponseEntity<Boolean>(creato, HttpStatus.OK);
	}	
	
	@PostMapping("/abilitazioni")
	public ResponseEntity<Abilitazioni> getAbilitazioniByTipoUtente(Utente u)
	{
		Abilitazioni permessi = us.getAbilitazioniByTipoUtente(u);
		return new ResponseEntity<Abilitazioni>(permessi,HttpStatus.OK);
	}
	
	
}

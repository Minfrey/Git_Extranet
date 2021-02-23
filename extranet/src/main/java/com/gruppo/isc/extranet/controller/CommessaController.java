package com.gruppo.isc.extranet.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Anno;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.service.CommessaServiceImp;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CommessaController 
{
	@Autowired
	CommessaServiceImp cs;
	
	
	@GetMapping("commessalist")
	public ResponseEntity<List<Commessa>> getlistaCommessa()
	{
		List<Commessa> lista =cs.getListaCommessa();
		return new ResponseEntity<List<Commessa>>(lista,HttpStatus.OK);	
	}
	
	@GetMapping("commessa/{id}")
    public ResponseEntity<Commessa> getCommessaId(@PathVariable("id") int id)
	{
		
		Commessa commessa = cs.getCommessaId(id);
		return new ResponseEntity<Commessa>(commessa,HttpStatus.OK);
	}
	
	@PostMapping("setcommessa")
	public int setCommessa(@RequestBody Commessa c)
	{ 
	   return  cs.setCommessa(c);
	}
	
	@GetMapping("/anniCommesse")
	public ResponseEntity<List<Anno>> getAnniCommesse(@RequestBody Commessa c)
	{
		List<Anno> anni = cs.getAnniCommesse(c);
		return new ResponseEntity<List<Anno>>(anni, HttpStatus.OK);
	}

}

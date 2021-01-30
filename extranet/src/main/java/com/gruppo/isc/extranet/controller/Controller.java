package com.gruppo.isc.extranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.model.Mese;
import com.gruppo.isc.extranet.model.Risorse;
import com.gruppo.isc.extranet.model.Task;
import com.gruppo.isc.extranet.model.TipoUsoRisorse;
import com.gruppo.isc.extranet.model.UsoRisorse;
import com.gruppo.isc.extranet.service.AttivitaServiceImp;
import com.gruppo.isc.extranet.service.AvanzamentoServiceImp;
import com.gruppo.isc.extranet.service.CommessaServiceImp;
import com.gruppo.isc.extranet.service.MeseServiceImp;
import com.gruppo.isc.extranet.service.RisorseServiceImp;
import com.gruppo.isc.extranet.service.TaskServiceImp;
import com.gruppo.isc.extranet.service.TipoUsoRisorseServiceImp;
import com.gruppo.isc.extranet.service.UsoRisorseServiceImp;





@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class Controller 
{
	@Autowired
	TaskServiceImp ts;
	
	@Autowired
	MeseServiceImp ms;
	
	
	@Autowired
	AttivitaServiceImp as;
	
	@Autowired
	RisorseServiceImp rs;
	
	@Autowired
	UsoRisorseServiceImp urs;
	
	@Autowired
	TipoUsoRisorseServiceImp turs;
	
	@Autowired
	AvanzamentoServiceImp avs;
	
	@GetMapping("task")
    public ResponseEntity<List<Task>> getTaskList()
	{
		List<Task> lista = ts.getTaskList();
		return new ResponseEntity<List<Task>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("risorse")
    public ResponseEntity<List<Risorse>> getRisorseList()
	{
		List<Risorse> lista = rs.getRisorseList();
		return new ResponseEntity<List<Risorse>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("mese")
	public ResponseEntity<List<Mese>> getlistaMesi()
	{
		List<Mese> lista = ms.getMeseList();
		return new ResponseEntity<List<Mese>>(lista,HttpStatus.OK);
	}
	
	
	
	@GetMapping("tipousorisorse/{id}")
    public ResponseEntity<TipoUsoRisorse> getTipoUsoRisorseId(@PathVariable("id") int id)
	{
		TipoUsoRisorse tur =turs.getTipoUsoRisorseId(id);
		return new ResponseEntity<TipoUsoRisorse>(tur,HttpStatus.OK);
	}
	
	
	
	@PostMapping("assegnaattivita")
	public void setAttivita(@RequestBody Attivita a)
	{
		System.out.println(a.getTask());
		System.out.println(a.getCommessa());
		System.out.println(a.getValore());
		as.setAttivita(a);
	}
	
	@GetMapping("listaattivita/{id}")
	public List<Attivita> getAttivitaCommessa(@PathVariable("id") int id)
	{
		return as.getAttivitaCommessa(id);
	}

	@PostMapping("usorisorse")
	public void setUsoRisorse(@RequestBody UsoRisorse u)
	{ 
	    urs.setUsoRisorse(u);
	}
	
	@PostMapping("avanzamento")
	public ResponseEntity<Avanzamento> setAvanzamento(@RequestBody Avanzamento a)
	{ 
		Avanzamento avan = avs.setAvanzamento(a);
	    return new ResponseEntity<Avanzamento>(avan,HttpStatus.CREATED);
	}
}

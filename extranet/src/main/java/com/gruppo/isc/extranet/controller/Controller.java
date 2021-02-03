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
import com.gruppo.isc.extranet.model.Attivita;
import com.gruppo.isc.extranet.model.Avanzamento;
import com.gruppo.isc.extranet.model.Commessa;
import com.gruppo.isc.extranet.model.Mese;
import com.gruppo.isc.extranet.model.Risorse;
import com.gruppo.isc.extranet.model.Task;
import com.gruppo.isc.extranet.model.TipoUsoRisorse;
import com.gruppo.isc.extranet.model.UsoRisorse;
import com.gruppo.isc.extranet.service.AnnoServiceImp;
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
	AnnoServiceImp asi;
	
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
	public ResponseEntity<List<Attivita>> getAttivitaCommessa(@PathVariable("id") int id)
	{
		List<Attivita> lista = as.getAttivitaCommessa(id);
		return  new ResponseEntity<List<Attivita>>(lista,HttpStatus.OK);
	}

	@PostMapping("usorisorse")
	public String setUsoRisorse(@RequestBody UsoRisorse u)
	{ 
	    return urs.setUsoRisorse(u);
	}
	
	@GetMapping("getusorisorse/{id}")
	public ResponseEntity<List<UsoRisorse>> getUsoRisorseList(@PathVariable("id") int id)
	{
		List<UsoRisorse> lista = urs.getUsoRisorseList(id);
		return new ResponseEntity<List<UsoRisorse>>(lista,HttpStatus.OK);
	}
	
	@PutMapping("modusorisorse")
	public String modUsoRisorse(@RequestBody UsoRisorse u)
	{
		return urs.modUsoRisorse(u);
	}
	
	@GetMapping("avanzamentolist/{id}")
	public ResponseEntity<List<Avanzamento>> getAvanzamentoByCommessa(@PathVariable("id") int id)
	{
		List<Avanzamento> lista = avs.getAvanzamentoByAttivita2(id);
		return new ResponseEntity<List<Avanzamento>>(lista,HttpStatus.OK);
	}
	
	@PostMapping("avanzamento")
	public String setAvanzamento(@RequestBody Avanzamento a)
	{ 
		
	    return avs.setAvanzamento(a);
	}
	
	@PutMapping("modavanzamento")
	public String modAvanzamento(@RequestBody Avanzamento a)
	{
		return avs.modAvanzamento(a);
	}
	
	@PutMapping("modattivita")
	public String modAttivita(@RequestBody Attivita a)
	{
		String b  = as.modAttivita(a);
		return b;
	}
	
	@GetMapping("getanno")
	public ResponseEntity<List<Anno>> getAnno()
	{
		List<Anno> lista = asi.getAnno();
		return new ResponseEntity<List<Anno>>(lista,HttpStatus.OK);
	}
	
	
	
}

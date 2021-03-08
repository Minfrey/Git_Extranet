package com.gruppo.isc.extranet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.gruppo.isc.extranet.model.Mese;
import com.gruppo.isc.extranet.model.Risorse;
import com.gruppo.isc.extranet.model.TipoAvanzamento;
import com.gruppo.isc.extranet.model.TipoUsoRisorse;
import com.gruppo.isc.extranet.model.UsoRisorse;
import com.gruppo.isc.extranet.repository.TipoAvanzamentoRepo;
import com.gruppo.isc.extranet.service.AnnoServiceImp;
import com.gruppo.isc.extranet.service.AttivitaServiceImp;
import com.gruppo.isc.extranet.service.AvanzamentoServiceImp;

import com.gruppo.isc.extranet.service.MeseServiceImp;
import com.gruppo.isc.extranet.service.RisorseServiceImp;
import com.gruppo.isc.extranet.service.TipoAvanzamentoServiceImp;
import com.gruppo.isc.extranet.service.TipoUsoRisorseServiceImp;
import com.gruppo.isc.extranet.service.UsoRisorseServiceImp;





@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class Controller 
{	
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
	
	@Autowired
	TipoAvanzamentoServiceImp tas;
	
	@Scheduled(fixedRate = 60000)
	public void fixedRateSch() 
	{ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String strDate = sdf.format(date);
		System.out.println("la data è "+strDate);
		rs.schedulRisorse(strDate);
		//esegue query su risorse quando la data e uguale a quella caricata
		//tutti quelli con lo stesso nome attivi vengono disattivati 
		//e attiva quello con la data odierna che e disattivato
	}
	@PostMapping("modrisorse")
	public String modRisorse(@RequestBody Risorse r)
	{
		r.setId_risorse(null);
		return rs.modRisorse(r);
	}
	
	@PostMapping("setrisorse")
	public String setRisorse(@RequestBody Risorse r)
	{
		System.out.println("risorsa nome :"+r.getNome());
		System.out.println("risorsa tariffa :"+r.getTariffa());
		System.out.println("risorsa iniziovalididta :"+r.getIniziovalidita());
		return rs.setRisorse(r);
	}

	
	@GetMapping("risorse")
    public ResponseEntity<List<Risorse>> getRisorseList()
	{
		List<Risorse> lista = rs.getRisorseList();
		return new ResponseEntity<List<Risorse>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("risorseActive")
    public ResponseEntity<List<Risorse>> getRisorseListActive()
	{
		List<Risorse> lista = rs.getRisorseListActive();
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
	public String setAttivita(@RequestBody Attivita a)
	{
		return as.setAttivita(a);
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
	
	@GetMapping("avanzamentolist/{id}/{idt}")
	public ResponseEntity<List<Avanzamento>> getAvanzamentoByCommessa(@PathVariable("id") int id,@PathVariable("idt") int idt)
	{
		List<Avanzamento> lista = avs.getAvanzamentoByCommessaType(id,idt);
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
	
	@GetMapping("usorisorselist/{id}/{idt}")
	public ResponseEntity<List<UsoRisorse>> getUsoRisorse(@PathVariable("id") int id,@PathVariable("idt") int idt)
	{
		System.out.println("id :"+id+" idt :"+idt);
		List<UsoRisorse> lista = urs.getUsoRisorseByType(id, idt);
		return new ResponseEntity<List<UsoRisorse>>(lista,HttpStatus.OK);
	}
	
	@PutMapping("consolidaav")
	public String consolidaav(@RequestBody Avanzamento a)
	{
		return avs.consolidaav(a);
	}
	
	@PutMapping("consolidauso")
	public String consolidaUso(@RequestBody UsoRisorse a)
	{
		return urs.consolidaUso(a);
	}
	
	@GetMapping("tipiavanzamento")
	public ResponseEntity<List<TipoAvanzamento>> getAllTipoAvanzamento()
	{
		List<TipoAvanzamento> tipi = tas.getAllTipiAvanzamento();
		return new ResponseEntity<List<TipoAvanzamento>>(tipi, HttpStatus.OK) ;
	}
	
	@GetMapping("tipiattivita/{id}/{idt}")
	public ResponseEntity<List<Attivita>> getAttivitaCommessaByType(@PathVariable("id") int id,@PathVariable("idt") int idt)
	{
		List<Attivita> att = as.getAttivitaCommessaByType(id, idt);
		return new ResponseEntity<List<Attivita>>(att,HttpStatus.OK);
	}
	
	@GetMapping("tipirisorse/{id}/{idt}")
	public ResponseEntity<List<Risorse>> getRisorseCommessaByType(@PathVariable("id") int id,@PathVariable("idt") int idt)
	{
		List<Risorse> ris =  rs.getRisorseCommessaByType(id, idt);
		return new ResponseEntity<List<Risorse>>(ris,HttpStatus.OK);
	}
	
}

package com.gruppo.isc.extranet.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="avanzamento")
public class Avanzamento
{
	
	private Double valore;
	private Integer percentuale;
	
	@ManyToOne
	@JoinColumn(name="id_attivita")
	private Attivita attivita;
	
	@ManyToOne
	@JoinColumn(name="id_mese")
	private Mese mese;
	

}

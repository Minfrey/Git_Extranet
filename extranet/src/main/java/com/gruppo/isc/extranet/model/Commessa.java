package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="commessa")
public class Commessa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_commessa;
	private String nome;
	private String cliente;
	private Double valore;
	private Date inizio;
	private Date fine;
	
	@OneToMany(mappedBy = "commessa")
	private Set<Attivita> attivita;
	
	
	
}
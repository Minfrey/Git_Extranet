package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="mese")
public class Mese implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_mese;
	private String nome;
	private Integer anno;
	
	@OneToMany(mappedBy="mese")
	private Set<UsoRisorse> usorisorse;
	
	@OneToMany(mappedBy="mese")
	private Set<Avanzamento> avanzamento;
	
	
}

package com.gruppo.isc.extranet.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="anno")
public class Anno 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_anno;
	
	private Integer numero;
	
	@JsonIgnore
	@OneToMany(mappedBy="anno")
	private Set<UsoRisorse> usorisorse;
	
	@JsonIgnore
	@OneToMany(mappedBy="anno")
	private Set<Avanzamento> avanzamento;
	
	
}

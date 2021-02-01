package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "attivita")
public class Attivita implements Serializable
{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_attivita;	
	
	@ManyToOne
	@JoinColumn(name="fk_id_task",referencedColumnName = "id_task", nullable = false)
	private Task task;

	@ManyToOne
	@JoinColumn(name="fk_id_commessa",referencedColumnName = "id_commessa",nullable = false)
	private Commessa commessa;
	
	@Column(name="valore",nullable=false)
	private Double valore;
	
	@JsonIgnore
	@OneToMany(mappedBy="attivita")
	private Set<Avanzamento> avanzamento;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="attivita")
//	private Set<UsoRisorse> usoRisorse;
	
	

}
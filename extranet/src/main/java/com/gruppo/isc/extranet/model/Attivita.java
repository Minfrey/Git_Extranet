package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "attivita")
@Data
public class Attivita implements Serializable
{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_attivita;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_task", referencedColumnName = "id_task")
	private Task task;

	@ManyToOne
	@JoinColumn(name="id_commessa" , nullable=false)
	private Commessa commessa;
	
	private Double Valore;
	
	@OneToMany(mappedBy="Attivita")
	private Set<Avanzamento> avanzamento;
	

}
package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_commessa;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cliente;
	
	@Column(columnDefinition = "DOUBLE default 0",nullable=false)
	private Double valore;
	
	@Column(nullable=false)
	private Date inizio;
	
	@Column(nullable=false)
	private Date fine;
	
	@OneToMany(mappedBy = "commessa")
	private Set<Attivita> attivita;
	
	
	
}
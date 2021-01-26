package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="risorse")
public class Risorse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_risorse;
	private String nome;
	private Double tariffa;
	
	@OneToMany(mappedBy = "risorse")
	private Set<UsoRisorse> usorisorse;

}

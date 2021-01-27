package com.gruppo.isc.extranet.model;

import java.io.Serializable;
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

@Data
@Entity
@Table(name="risorse")
public class Risorse implements Serializable
{
	private static final long serialVersionUID = -3772780489311387115L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_risorse;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Double tariffa;
	
	@OneToMany(mappedBy = "risorse")
	private Set<UsoRisorse> usorisorse;
	
	
	
	
	

}

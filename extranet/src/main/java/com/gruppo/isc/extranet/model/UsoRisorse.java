package com.gruppo.isc.extranet.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usorisorse")
public class UsoRisorse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer 
	private Double ore;
	private Double ricavi;
	private Double costi;
	
	@ManyToOne
	@JoinColumn(name = "id_risorse")
	private Risorse risorse;
	
	

}

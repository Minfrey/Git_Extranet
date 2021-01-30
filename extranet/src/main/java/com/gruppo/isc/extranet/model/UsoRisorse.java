package com.gruppo.isc.extranet.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="usorisorse")
public class UsoRisorse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_usorisorse;
	
	@ManyToOne
	@JoinColumn(name="fk_id_risorse", referencedColumnName = "id_risorse",nullable=false)
	private Risorse risorse;
	
	@ManyToOne
	@JoinColumn(name="fk_id_mese", referencedColumnName ="id_mese",nullable=false)
	private Mese mese;
	
	@ManyToOne
	@JoinColumn(name="fk_id_attivita", referencedColumnName ="id_attivita",nullable=false)//nome su questa tabella ----- | referencedColumnName ="id_attivita" nome su tabella "attivita"
	private Attivita attivita;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_usorisorse", referencedColumnName ="id_tipo_usorisorse",nullable=false)
	private TipoUsoRisorse tipoUsoRisorse;
	
	@Column(nullable=false)
	private Double ore;
	
	@Column(nullable=false)
	private Double ricavi;
	
	@Column(nullable=false)
	private Double costi;
	
	

}


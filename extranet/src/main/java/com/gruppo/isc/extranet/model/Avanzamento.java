package com.gruppo.isc.extranet.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="avanzamento")
@Data
public class Avanzamento implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_avanzamento;
	
	@Column(name="valore",nullable=false)
	private Double valore;
	
	@Column(name="percentuale",nullable=false)
	private Integer percentuale;
	
	
	@ManyToOne
	@JoinColumn(name="fk_id_attivita", referencedColumnName = "id_attivita" , nullable=false)
	private Attivita attivita;
	
	@ManyToOne
	@JoinColumn(name="fk_id_mese", referencedColumnName = "id_mese" , nullable=false)
	private Mese mese;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_avanzamento", referencedColumnName = "id_tipo_avanzamento",nullable=false)
	private TipoAvanzamento tipoAvanzamento;
	
	
	

}

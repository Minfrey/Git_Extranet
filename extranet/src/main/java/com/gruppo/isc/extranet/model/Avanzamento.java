package com.gruppo.isc.extranet.model;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
	@JoinColumn(name="fk_id_mese", nullable=false)
	private Mese mese;
	
	@ManyToOne
	@JoinColumn(name="fk_id_anno", nullable=false)
	private Anno anno;

	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_avanzamento", referencedColumnName = "id_tipo_avanzamento",nullable=false)
	private TipoAvanzamento tipoAvanzamento;
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_avanzamento);
	    }
	

}

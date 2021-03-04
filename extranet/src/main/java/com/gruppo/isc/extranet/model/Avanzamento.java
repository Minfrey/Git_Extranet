package com.gruppo.isc.extranet.model;


import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
	
	@Column(name="consolida",nullable=true)
	private Date consolida;
	
	@Column(name="fattura",nullable=true)
	private String fattura;
	
	@Column(name="data",nullable=true)
	private Date data;
	
	@JsonBackReference
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
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Avanzamento other = (Avanzamento) obj;
	        return Objects.equals(id_avanzamento, other.getId_avanzamento());
	    }
	 
	 @Override
	 public String toString() {
	     return "Order [Avanzamento id=" + id_avanzamento + "]";
	 }
	
}

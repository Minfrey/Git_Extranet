package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="usorisorse")
public class UsoRisorse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_usorisorse;
	
	@JsonIgnoreProperties("usorisorse")
	@ManyToOne
	@JoinColumn(name="fk_id_risorse", referencedColumnName = "id_risorse",nullable=false)
	private Risorse risorse;
	
	@ManyToOne
	@JoinColumn(name="fk_id_mese", nullable=false)
	private Mese mese;
	
	@ManyToOne
	@JoinColumn(name="fk_id_anno", nullable=false)
	private Anno anno;
	
	
	
	@ManyToOne
	@JoinColumn(name="fk_id_commessa", referencedColumnName ="id_commessa",nullable=false)//nome su questa tabella ----- | referencedColumnName ="id_attivita" nome su tabella "attivita"
	private Commessa commessa;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_usorisorse", referencedColumnName ="id_tipo_usorisorse",nullable=false)
	private TipoUsoRisorse tipoUsoRisorse;
	
	@Column(nullable=false)
	private Double ore;
	
	@Column(nullable=false)
	private Double ricavi;
	
	@Column(nullable=false)
	private Double costi;
	
	@Column(name="consolida",nullable=true)
	private Date consolida;
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_usorisorse);
	    }
	 
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        UsoRisorse other = (UsoRisorse) obj;
	        return Objects.equals(id_usorisorse, other.getId_usorisorse());
	    }
	 
	 @Override
	 public String toString() {
	     return "Order [Usorisorse id=" + id_usorisorse + "]";
	 }
	

}


package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@Column(columnDefinition = "DOUBLE default 0",nullable=false)
	private Double fatturato;
	
	@Column(columnDefinition = "DOUBLE default 0",nullable=false)
	private Double fatturato_previsto;
	
	@Column(columnDefinition = "DOUBLE default 0",nullable=false)
	private Double costo;
	
	@Column(columnDefinition = "DOUBLE default 0",nullable=false)
	private Double costo_previsto;
	
	@Column(nullable=false)
	private Date inizio;
	
	@Column(nullable=false)
	private Date fine;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commessa")
	private Set<Attivita> attivita;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commessa")
	private Set<UsoRisorse> UsoRisorse;
	
	@Override
    public int hashCode() {
        return Objects.hashCode(id_commessa);
    }
 @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Commessa other = (Commessa) obj;
        return Objects.equals(id_commessa, other.getId_commessa());
    }
	
 @Override
 public String toString() {
     return "Order [Commessa id=" + id_commessa + "]";
 }

}
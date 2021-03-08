package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Data
@Entity
@Table(name = "attivita")
public class Attivita implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -872074613552119416L;




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_attivita;	
	
	

	@ManyToOne
	@JoinColumn(name="fk_id_commessa",referencedColumnName = "id_commessa",nullable = false)
	private Commessa commessa;
	
	@Column(name="valore",nullable=false)
	private Double valore;
	
	@Column(name="descrizione",nullable=false)
	private String descrizione;
	
	@JsonIgnoreProperties("attivita")
	@OneToMany(mappedBy="attivita")
	private Set<Avanzamento> avanzamento = new HashSet<>();
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_attivita);
	    }
	 
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Attivita other = (Attivita) obj;
	        return Objects.equals(id_attivita, other.getId_attivita());
	    }
//	@JsonIgnore
//	@OneToMany(mappedBy="attivita")
//	private Set<UsoRisorse> usoRisorse;
	 @Override
	 public String toString() {
	     return "Order [Attivita id=" + id_attivita + "]";
	 }
	

}
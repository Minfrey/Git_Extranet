package com.gruppo.isc.extranet.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="mese")
public class Mese implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mese;
	
	@Column(nullable=false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="mese")
	private Set<UsoRisorse> usorisorse;
	
	@JsonIgnore
	@OneToMany(mappedBy="mese")
	private Set<Avanzamento> avanzamento;
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_mese);
	    }
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Mese other = (Mese) obj;
	        return Objects.equals(id_mese, other.getId_mese());
	    }
	 
	 @Override
	 public String toString() {
	     return "Order [Mese id=" + id_mese + "]";
	 }
}

package com.gruppo.isc.extranet.model;

import java.io.Serializable;
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

@Data
@Entity
@Table(name="risorse")
public class Risorse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_risorse;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Double tariffa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "risorse")
	private Set<UsoRisorse> usorisorse;
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_risorse);
	    }
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Risorse other = (Risorse) obj;
	        return Objects.equals(id_risorse, other.getId_risorse());
	    }
	 
	 @Override
	 public String toString() {
	     return "Order [Risorse id=" + id_risorse + "]";
	 }
	

}

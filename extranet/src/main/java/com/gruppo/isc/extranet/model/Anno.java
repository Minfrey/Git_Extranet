package com.gruppo.isc.extranet.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="anno")
public class Anno 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_anno;
	
	@Column(nullable=false)
	private Integer numero;
	
	@JsonIgnore
	@OneToMany(mappedBy="anno")
	private Set<UsoRisorse> usorisorse;
	
	@JsonIgnore
	@OneToMany(mappedBy="anno")
	private Set<Avanzamento> avanzamento;
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_anno);
	    }
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Anno other = (Anno) obj;
	        return Objects.equals(id_anno, other.getId_anno());
	    }
	 @Override
	 public String toString() {
	     return "Order [Anno id=" + id_anno + "]";
	 }
}

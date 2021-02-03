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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_task;
	
	@JsonIgnore
	@OneToMany(mappedBy = "task")
	private Set<Attivita> attivita; 
	
	@Column(nullable=false)
	private String nome;
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(id_task);
	    }
	 
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Task other = (Task) obj;
	        return Objects.equals(id_task, other.getId_task());
	    }
	 
	 @Override
	 public String toString() {
	     return "Order [Task id=" + id_task + "]";
	 }
	
}

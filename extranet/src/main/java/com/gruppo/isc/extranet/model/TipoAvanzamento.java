package com.gruppo.isc.extranet.model;

import java.io.Serializable;
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
@Table(name="tipo_avanzamento")
public class TipoAvanzamento implements Serializable
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_avanzamento;
	
	@Column(nullable=false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoAvanzamento")
	private Set<Avanzamento> avanzamento;
	

}

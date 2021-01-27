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

import com.sun.istack.NotNull;

import lombok.Data;
@Data
@Entity
@Table(name="tipousorisorse")
public class TipoUsoRisorse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_tipo_usorisorse")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy = "tipoUsoRisorse") //tipoUsoRisorse si trova nella classe UsoRisorse
	private Set<UsoRisorse> usoRisorse;

}

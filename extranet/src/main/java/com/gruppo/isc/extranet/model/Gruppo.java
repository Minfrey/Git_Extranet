package com.gruppo.isc.extranet.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Entity
@Table(name="gruppo")
@Data
public class Gruppo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gruppo", nullable = false)
	private int id;
	
	@Column(name = "descrizione" , nullable = false)
	private String descrizione;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gruppo")
	@JsonBackReference
	private Set<Utente> utente = new HashSet<>();

}

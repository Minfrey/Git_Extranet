package com.gruppo.isc.extranet.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.el.parser.AstFalse;

import lombok.Data;

@Entity
@Table(name="abilitazioni")
@Data
public class Abilitazioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_abilitazioni", nullable = false)
	@JsonIgnore
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_gruppo", nullable = false, referencedColumnName = "id_gruppo")
	private Gruppo gruppo;
	
	@Column(name = "gestioneUtenti" , nullable = false)
	private int gestioneUtenti;
	
	@Column(name = "gestioneCommesse" , nullable = false)
	private int gestioneCommesse;
	
	@Column(name = "visualizzazione" , nullable = false)
	private int visualizzazione;

}

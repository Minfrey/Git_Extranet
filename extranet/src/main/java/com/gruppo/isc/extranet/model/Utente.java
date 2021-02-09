package com.gruppo.isc.extranet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="utente")
@Data
public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6544359484876967725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente", nullable = false)
	private int id;

	@Column(name = "username", nullable = false , unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "stato", nullable = false )
	private int stato;
	
	
	@Column(name = "primo_accesso" , nullable = false )
	private int primo_accesso;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_gruppo", nullable = false, referencedColumnName = "id_gruppo")
	private Gruppo gruppo;
}

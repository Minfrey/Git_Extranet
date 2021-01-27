package com.gruppo.isc.extranet.model;

import java.beans.JavaBean;
import java.io.Serializable;

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
@JavaBean
public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6544359484876967725L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "stato")
	private int stato;
	
	@Column(name = "primo_accesso")
	private int primo_accesso;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_gruppo", referencedColumnName = "id_gruppo")
	private Gruppo gruppo;
}

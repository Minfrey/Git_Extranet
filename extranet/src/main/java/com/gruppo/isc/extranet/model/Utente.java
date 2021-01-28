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

import com.sun.istack.NotNull;

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

	@Column(name = "stato", nullable = false , columnDefinition = "int default '1'")
	private int stato;
	
	
	@Column(name = "primo_accesso" , nullable = false ,columnDefinition = "int default '1'")
	private int primo_accesso;
	

	@ManyToOne
	@JoinColumn(name = "fk_id_gruppo", nullable = false, referencedColumnName = "id_gruppo")
	private Gruppo gruppo;
}

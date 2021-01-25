package com.gruppo.isc.extranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "amministratore")
@Data
@NamedQueries({
	@NamedQuery(name = "Amministratore.accessoAmministratore", query = "SELECT a FROM Amministratore a where a.username=:user and a.password=:password"),
	@NamedQuery(name = "Amministratore.cercaUtente" , query = "select u from Utente u where u.username =: username"),
})
public class Amministratore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_amministratore")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	
}

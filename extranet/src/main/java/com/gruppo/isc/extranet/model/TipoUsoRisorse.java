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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo_usorisorse;
	
	@Column(nullable=false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoUsoRisorse") //tipoUsoRisorse si trova nella classe UsoRisorse
	private Set<UsoRisorse> usoRisorse;

	@Override
    public int hashCode() {
        return Objects.hashCode(id_tipo_usorisorse);
    }
 @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TipoUsoRisorse other = (TipoUsoRisorse) obj;
        return Objects.equals(id_tipo_usorisorse, other.getId_tipo_usorisorse());
    }
 
 @Override
 public String toString() {
     return "Order [tipousorisorse=" + nome  + ", id=" + id_tipo_usorisorse + "]";
 }
}

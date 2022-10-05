package com.tismartjsf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Provincia")
public class Provincia {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProvincia;
	@Column
	private String descProvincia;
	@Column
	private Date fechaRegistro;
	//@OneToMany(targetEntity = Distrito.class)
	//private List<Distrito> distritos = new ArrayList<>();
	
	public Integer getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getDescProvincia() {
		return descProvincia;
	}
	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", descProvincia=" + descProvincia + ", fechaRegistro="
				+ fechaRegistro + "]";
	}
	
}
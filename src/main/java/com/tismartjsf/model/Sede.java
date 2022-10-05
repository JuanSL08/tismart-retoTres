package com.tismartjsf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sede")
public class Sede {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSede;
	@Column
	private String descSede;
	@Column
	private Date fechaRegistro;
	
	public Integer getIdSede() {
		return idSede;
	}
	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}
	public String getDescSede() {
		return descSede;
	}
	public void setDescSede(String descSede) {
		this.descSede = descSede;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Override
	public String toString() {
		return "Sede [idSede=" + idSede + ", descSede=" + descSede + ", fechaRegistro=" + fechaRegistro + "]";
	}

}
package com.tismartjsf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Condicion")
public class Condicion {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCondicion;
	@Column
	private String descCondicion;
	@Column
	private Date fechaRegistro;
	
	public Integer getIdCondicion() {
		return idCondicion;
	}
	public void setIdCondicion(Integer idCondicion) {
		this.idCondicion = idCondicion;
	}
	public String getDescCondicion() {
		return descCondicion;
	}
	public void setDescCondicion(String descCondicion) {
		this.descCondicion = descCondicion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Override
	public String toString() {
		return "Condicion [idCondicion=" + idCondicion + ", descCondicion=" + descCondicion + ", fechaRegistro="
				+ fechaRegistro + "]";
	}
	
}
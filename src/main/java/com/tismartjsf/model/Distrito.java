package com.tismartjsf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Distrito")
public class Distrito {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDistrito;
	@Column
	private String descDistrito;
	@Column
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name="idProvincia", referencedColumnName = "idProvincia")
	private Provincia provincia;

	public Integer getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getDescDistrito() {
		return descDistrito;
	}

	public void setDescDistrito(String descDistrito) {
		this.descDistrito = descDistrito;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Distrito [idDistrito=" + idDistrito + ", descDistrito=" + descDistrito + ", fechaRegistro="
				+ fechaRegistro + ", provincia=" + provincia + "]";
	}
	
}

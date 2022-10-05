package com.tismartjsf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Hospital")
public class Hospital {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idHospital;
	@Column
	private String nombre;
	@Column
	private Integer antiguedad;
	@Column
	private Double area;
	@Column
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name="idDistrito", referencedColumnName = "idDistrito")
	private Distrito distrito;
	
	@OneToOne
	@JoinColumn(name = "idSede", referencedColumnName = "idSede")
	private Sede sede;
	
	@OneToOne
	@JoinColumn(name = "idGerente", referencedColumnName = "idGerente")
	private Gerente gerente;
	
	@OneToOne
	@JoinColumn(name = "idCondicion", referencedColumnName = "idCondicion")
	private Condicion condicion;

	public Integer getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public Condicion getCondicion() {
		return condicion;
	}
	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}
	
	@Override
	public String toString() {
		return "Hospital [idHospital=" + idHospital + ", nombre=" + nombre + ", antiguedad=" + antiguedad + ", area="
				+ area + ", fechaRegistro=" + fechaRegistro + ", distrito=" + distrito + ", sede=" + sede + ", gerente="
				+ gerente + ", condicion=" + condicion + "]";
	}
	
}
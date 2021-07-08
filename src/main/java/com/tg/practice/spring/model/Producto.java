package com.tg.practice.spring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 150, nullable = false)
	private String codigo;

	@Column(length = 150)
	private String descripcion;

	@Column(nullable = false)
	private Short productosPorPaquete;

	@Column(nullable = false)
	private Boolean inferior;

	@Embedded
	private Medida medida;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private TipoProducto tipoProducto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Familia familia;

	@ManyToMany(mappedBy = "productos")
	Set<Maquina> maquinas;
	
	public Producto(String _codigo, String _descripcion) {
		this.codigo = _codigo;
		this.descripcion = _descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Short getProductosPorPaquete() {
		return productosPorPaquete;
	}

	public void setProductosPorPaquete(Short productosPorPaquete) {
		this.productosPorPaquete = productosPorPaquete;
	}

	public Boolean getInferior() {
		return inferior;
	}

	public void setInferior(Boolean inferior) {
		this.inferior = inferior;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	
}

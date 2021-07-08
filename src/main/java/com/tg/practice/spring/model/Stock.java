package com.tg.practice.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(value = StockPK.class)
public class Stock {

	@Id
	private Long id;

	@Id
	private Long token;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaStock;

	@Column(nullable = false)
	private Long cantidad;

	@Column(length = 150)
	private String nota;

	@OneToOne
	private Producto producto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public Date getFechaStock() {
		return fechaStock;
	}

	public void setFechaStock(Date fechaStock) {
		this.fechaStock = fechaStock;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}

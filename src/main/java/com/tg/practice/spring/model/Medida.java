package com.tg.practice.spring.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Medida {

	@Column
	private double largo;

	@Column
	private Double ancho;

	@Column
	private Double altura;

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

}

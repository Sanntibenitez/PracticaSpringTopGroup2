package com.tg.practice.spring.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Categoria {
	@ManyToOne
	SubFamilia subFamilia;

	public SubFamilia getSubFamilia() {
		return subFamilia;
	}

	public void setSubFamilia(SubFamilia subFamilia) {
		this.subFamilia = subFamilia;
	}
}

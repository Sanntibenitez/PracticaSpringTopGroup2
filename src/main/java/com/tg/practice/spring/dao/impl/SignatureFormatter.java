package com.tg.practice.spring.dao.impl;

import java.util.Locale;

import com.tg.practice.spring.service.MessageFormatter;

public class SignatureFormatter implements MessageFormatter {

	private String signature;

	public SignatureFormatter(String _signature) {
		this.signature = _signature;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String format(String texto, Object[] objects, Locale locale) {

		String mensaje = "";

		for (Object obj : objects) {
			mensaje = mensaje + obj.toString();
		}

		return texto + " - " + this.signature + mensaje.length();
		//Un mensaje dado – ZZXY12
	}

}

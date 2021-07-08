package com.tg.practice.spring;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tg.practice.spring.dao.impl.ControlStockServiceBean;
import com.tg.practice.spring.dao.impl.SignatureFormatter;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		ControlStockServiceBean controlStock = contexto.getBean("controlStockServiceBean",
				ControlStockServiceBean.class);

		SignatureFormatter formatter = contexto.getBean("signatureFormatter", SignatureFormatter.class);

		System.out.println("Signature archivo: " + formatter.getSignature());
		System.out.println("Cantidad maxima impresion: " + controlStock.getCantidadMaximaImpresion());

		controlStock.imprimirStocks(new Locale("en"));
		controlStock.imprimirStocks(new Locale("es"));

		contexto.close();
	}
}

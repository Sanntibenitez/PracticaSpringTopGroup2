package com.tg.practice.spring.mocks;

import java.util.ArrayList;
import java.util.List;

import com.tg.practice.spring.model.Producto;
import com.tg.practice.spring.model.Stock;

public class StockMocks {

	List<Stock> stocks = new ArrayList<Stock>();

	public StockMocks() {

		Stock sugus = new Stock();
		sugus.setCantidad(800l);
		sugus.setProducto(new Producto("ACCGE8", "Sugus"));

		Stock pico = new Stock();
		pico.setCantidad(365l);
		pico.setProducto(new Producto("ACCGE13", "Pico dulce"));

		stocks.add(sugus);
		stocks.add(pico);
	}

	public List<Stock> getStocks() {
		return stocks;
	}

}

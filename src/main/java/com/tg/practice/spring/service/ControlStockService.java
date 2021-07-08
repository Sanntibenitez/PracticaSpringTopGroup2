package com.tg.practice.spring.service;

import java.util.List;
import java.util.Locale;

import com.tg.practice.spring.model.Pedido;

public interface ControlStockService {
	
	public void actualizarStock(Long idProducto,Long cantidad);
	
	public List<Pedido> findPedidosConSock();
	
	public void imprimirStocks(Locale locale);
}

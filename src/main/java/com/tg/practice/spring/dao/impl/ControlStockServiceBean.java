package com.tg.practice.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.scheduling.annotation.Scheduled;

import com.tg.practice.spring.model.Pedido;
import com.tg.practice.spring.model.Stock;
import com.tg.practice.spring.service.ControlStockService;
import com.tg.practice.spring.service.MessageFormatter;

public class ControlStockServiceBean implements ControlStockService {

	private Long cantidadMaximaImpresion;
	private List<MessageFormatter> cadenaDeFormatters = new ArrayList<MessageFormatter>();
	private PedidoDaoBean pedidoDao;
	private StockMailSender mailSender;
	
	@Scheduled(cron="0 6 * * MON-FRI")
	public List<Pedido> findPedidosConStock(){
		
		List<Pedido> lista = pedidoDao.getPedidosConStock();
		
		String mensaje = "";
		
		for(Pedido p : lista) {
			
			mensaje += ("Producto: " + p.getProducto().getDescripcion() + "\n");
			mensaje += ("Cantidad: " + Long.toString(p.getCantidad()) + "\n");
			mensaje += ("Nro Guia: " + Long.toString(p.getNroGuia()) + "\n");
			mensaje += "-------------------" + "\n";
			
		}
		
		this.mailSender.enviarMsg("remitente", "contraseña", "sanntibenitez@gmail.com", mensaje);
		
		return null;
	}

	public Long getCantidadMaximaImpresion() {
		return cantidadMaximaImpresion;
	}

	public void setCantidadMaximaImpresion(Long cantidadMaximaImpresion) {
		this.cantidadMaximaImpresion = cantidadMaximaImpresion;
	}

	public void actualizarStock(Long cantidad) {
	}

	public List<Pedido> findPedidosConSock() {
		return null;
	}

	public void imprimirStocks(Locale locale) {
		List<Stock> stocks = new StockDaoBean().getStocks(locale);

		for (Stock stock : stocks) {

			LanguageFormatter _languageFormatter = (LanguageFormatter) cadenaDeFormatters.get(0);
			SignatureFormatter _signatureFormatter = (SignatureFormatter) cadenaDeFormatters.get(1);

			String msg = _languageFormatter.format("texto",
					new Object[] { stock.getProducto().getDescripcion(), stock.getCantidad() }, locale);

			System.out.println(_signatureFormatter.format(msg,
					new Object[] { stock.getProducto().getDescripcion(), stock.getCantidad() }, locale));
		}
	}

	public List<MessageFormatter> getCadenaDeFormatters() {
		return cadenaDeFormatters;
	}

	public void setCadenaDeFormatters(List<MessageFormatter> cadenaDeFormatters) {
		this.cadenaDeFormatters = cadenaDeFormatters;
	}

	public void actualizarStock(Long idProducto, Long cantidad) {
		// TODO Auto-generated method stub
		
	}

}

package com.tg.practice.spring.dao.impl;

import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.transaction.annotation.Transactional;

import com.tg.practice.spring.dao.StockDao;
import com.tg.practice.spring.model.Stock;

@SuppressWarnings("unchecked")
public class StockDaoBean implements StockDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	public List<Stock> getStocks(Locale idioma) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Stock.class, "f");
		List<Stock> res = criteria.list();
		return res;
	}

	@Transactional(readOnly = false)
	public void actualizarStock(Long idProducto, Long cantidad) {
		Session session = sessionFactory.getCurrentSession();
		Stock stock = (Stock) session.get(Stock.class, idProducto);
		stock.setCantidad(cantidad);
		session.update(stock);
	}

}

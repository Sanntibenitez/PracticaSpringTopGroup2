package com.tg.practice.spring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.tg.practice.spring.model.Pedido;
import com.tg.practice.spring.dao.PedidoDao;

@SuppressWarnings("unchecked")
public class PedidoDaoBean implements PedidoDao {
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Pedido> getPedidos() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Pedido.class);
		List<Pedido> res = criteria.list();
		return res;
	}
	
	@Transactional
	public List<Pedido> getPedidosConStock(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Pedido.class, "pedido");
		criteria.createAlias("pedido.producto","producto");
		criteria.createAlias("producto.stock", "stock");
		criteria.add(Restrictions.geProperty("stock.cantidad", "pedido.cantidad"));
		List<Pedido> res = criteria.list();
		return res;
	}
}

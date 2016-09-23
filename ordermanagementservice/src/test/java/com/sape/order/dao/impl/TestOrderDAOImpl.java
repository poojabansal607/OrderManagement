package com.sape.order.dao.impl;

import javax.persistence.Entity;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sape.order.dao.TestOrderDAO;

import java.lang.reflect.Field;

public class TestOrderDAOImpl extends HibernateDaoSupport implements
		TestOrderDAO {
	public void create(Object entity) {
		if (entity != null) {
			getSession().saveOrUpdate(entity);
		}
	}
}

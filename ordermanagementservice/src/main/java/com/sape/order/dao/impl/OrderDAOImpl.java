package com.sape.order.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.MetricRegistry;
import com.metrics.service.OpenTsdbMetric;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sape.order.dao.OrderDAO;
import com.sape.order.model.EquityOrder;
import com.sape.util.OpenTsDbUtil;

/**
 * @author Nilaksh Bajpai
 */
public class OrderDAOImpl extends HibernateDaoSupport implements OrderDAO {

    public MetricRegistry metricRegistry;
    OpenTsDbUtil util;

    public OrderDAOImpl() {
        metricRegistry = new MetricRegistry();
        util = new OpenTsDbUtil(metricRegistry, "http://delvmlciin01.sapient.com:4242/");
        util.start();
        
    }


    /**
     * @see com.sape.order.dao.OrderDAO#createOrder(EquityOrder)
     */
    public EquityOrder createOrder(EquityOrder order) {
        final long start = System.currentTimeMillis();
        getSession().saveOrUpdate(order);
        final long end = System.currentTimeMillis();
        String metricName = "order.create." + order.getOrderType();
        metricRegistry.timer(metricName).update(end - start, TimeUnit.MILLISECONDS);
        return order;
    }

    /**
     * @see com.sape.order.dao.OrderDAO#fetchAllOrders()
     */
    public List<EquityOrder> fetchAllOrders() {
        final long start = System.currentTimeMillis();
        Query query = getSession().createQuery("from EquityOrder");
        List<EquityOrder> list = query.list();
        for (EquityOrder order : list) {
            System.out.println("order from db=" + order.getOrderId());
            System.out.println("order from db =" + order.getOrderType());
        }
        final long end = System.currentTimeMillis();
        String metricName = "order.fetchAll";
        metricRegistry.timer(metricName).update(end - start, TimeUnit.MILLISECONDS);
        metricRegistry.counter(metricName+".count").inc(list.size());
        return list;
    }

    @Override
    public Integer fetchOrderCount() {
         return (Integer) getSession().createCriteria(EquityOrder.class).setProjection(Projections.rowCount()).uniqueResult();
    }

    public MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }

    public void setMetricRegistry(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

}

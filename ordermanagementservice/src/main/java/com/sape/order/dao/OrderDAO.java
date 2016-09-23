package com.sape.order.dao;

import java.util.List;

import com.sape.order.model.EquityOrder;

public interface OrderDAO {

	EquityOrder createOrder(EquityOrder order);

	public List<EquityOrder> fetchAllOrders();

	public Integer fetchOrderCount();
}

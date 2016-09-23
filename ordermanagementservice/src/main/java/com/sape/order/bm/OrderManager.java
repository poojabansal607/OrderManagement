package com.sape.order.bm;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sape.order.dao.OrderDAO;
import com.sape.order.exceptions.EquityOrderException;
import com.sape.order.exceptions.NotAllowed;
import com.sape.order.model.EquityOrder;

/**
 * OrderManager is a service for managing orders. 
 * 
 * @author Nilaksh Bajpai
 */

public interface OrderManager {

	/**
	 * Creates an {@link EquityOrder} if none of the business rules are
	 * violated. 
	 * 
	 * @param order
	 * @return
	 * @throws NotAllowed
	 *             if user is not authorized
	 * @throws EquityOrderException
	 *             if a business rule is violated.
	 */
	EquityOrder createOrder(EquityOrder order) throws NotAllowed,
			EquityOrderException;

	

	/**
	 * Fetches all the orders
	 * 
	 * @return List
	 */
	public List<EquityOrder> fetchAllOrders();

	/**
	 * Fetches all the orders
	 *
	 * @return Integer
	 */
	public Integer fetchOrderCount();

	public String getEnvironment();

}

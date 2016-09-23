package com.sape.order.bm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sape.order.bm.OrderManager;
import com.sape.order.dao.OrderDAO;
import com.sape.order.enums.OrderStatusEnum;
import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.exceptions.EquityOrderException;
import com.sape.order.exceptions.InvalidQuantityEntered;
import com.sape.order.exceptions.LimitPriceBlankForLimitOrder;
import com.sape.order.exceptions.LimitPriceBlankForStopLimitOrder;
import com.sape.order.exceptions.LimitPriceNotBlankForStopOrder;
import com.sape.order.exceptions.NotAllowed;
import com.sape.order.exceptions.PriceNotBlankForMarketOrder;
import com.sape.order.exceptions.ResultNotFound;
import com.sape.order.exceptions.StopPriceBlankForStopLimitOrder;
import com.sape.order.exceptions.StopPriceBlankForStopOrder;
import com.sape.order.exceptions.StopPriceNotBlankForLimitOrder;
import com.sape.order.model.EquityOrder;

/**
 * OrderManagerImpl is an implementation of {@link OrderManager}.
 * 
 * @author Nilaksh Bajpai
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class OrderManagerImpl implements OrderManager {

	@Value("${APPLICATION_ENVIRONMENT}")
	private String environment;

	private OrderDAO dao;

	/**
	 * @see com.sape.order.bm.OrderManager#createOrder(com.sape.order.vo.EquityOrder,
	 *      com.sape.order.vo.User)
	 */
	public EquityOrder createOrder(EquityOrder order) throws NotAllowed,
			EquityOrderException {
		validateOrder(order);
		order.setOrderStatus(OrderStatusEnum.New);
		EquityOrder createdOrder = dao.createOrder(order);
		return createdOrder;
	}

	/**
	 * Fetches all the orders
	 * 
	 * @return List
	 */
	public List<EquityOrder> fetchAllOrders() {
		return dao.fetchAllOrders();
	}

	@Override
	public Integer fetchOrderCount() {
		return dao.fetchOrderCount();
	}

	/**
	 * Validates {@link EquityOrder} for correctness.
	 * 
	 * @param order
	 * @throws EquityOrderException
	 */
	private void validateOrder(EquityOrder order) throws EquityOrderException {
		OrderTypeEnum orderType = order.getOrderType();
		Long stopPrice = order.getStopPrice();
		Long limitPrice = order.getLimitPrice();

		switch (orderType) {
		case Market: {
			if (stopPrice != null || limitPrice != null)
				throw new PriceNotBlankForMarketOrder();
			break;
		}
		case Limit: {
			if (limitPrice == null)
				throw new LimitPriceBlankForLimitOrder(); 
			if (stopPrice != null)
				throw new StopPriceNotBlankForLimitOrder();

			break;
		}
		case Stop: {
			if (stopPrice == null)
				throw new StopPriceBlankForStopOrder();
			if (limitPrice != null)
				throw new LimitPriceNotBlankForStopOrder();
			break;
		}
		case StopLimit: {
			if (stopPrice == null)
				throw new StopPriceBlankForStopLimitOrder();
			if (limitPrice == null)
				throw new LimitPriceBlankForStopLimitOrder();
			break;
		}
		default:
			throw new IllegalStateException("Order Type must be set!");
		}

		if (order.getQuantity() < 1L)
			throw new InvalidQuantityEntered();
	}

	
	
	public void setOrderDao(OrderDAO orderDao) {
		this.dao = orderDao;

	}
	public String getEnvironment() {
		return environment;
	}
}

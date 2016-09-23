package com.sape.order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.sape.order.bm.OrderManager;
import com.sape.order.bm.impl.OrderManagerImpl;
import com.sape.order.dao.DataAccessTestDelegate;
import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.exceptions.EquityOrderException;
import com.sape.order.exceptions.InvalidQuantityEntered;
import com.sape.order.exceptions.LimitPriceBlankForLimitOrder;
import com.sape.order.exceptions.LimitPriceBlankForStopLimitOrder;
import com.sape.order.exceptions.LimitPriceNotBlankForStopOrder;
import com.sape.order.exceptions.NotAllowed;
import com.sape.order.exceptions.PriceNotBlankForMarketOrder;
import com.sape.order.exceptions.StopPriceBlankForStopLimitOrder;
import com.sape.order.exceptions.StopPriceBlankForStopOrder;
import com.sape.order.exceptions.StopPriceNotBlankForLimitOrder;
import com.sape.order.model.EquityOrder;

public class PMWhileSavingCreateOrderShould {

	private OrderManagerImpl manager;

	private EquityOrder order;

	
	private DataAccessTestDelegate daoDelegate;

	public PMWhileSavingCreateOrderShould() {
		daoDelegate = new DataAccessTestDelegate();
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		daoDelegate.setup();
		prepareEquityOrderForSave();
		manager = new OrderManagerImpl();
		manager.setOrderDao(daoDelegate.getOrderDao());
	}

	private void prepareEquityOrderForSave() {
		order = new EquityOrder();
		order.setQuantity(1L);
	}

	@After
	public void tearDown() throws Exception {
		daoDelegate.teardown();
	}

	@Test(expected = PriceNotBlankForMarketOrder.class)
	public void notBeAbleToEnterStopPriceIfMarketOrder()
			throws EquityOrderException, NotAllowed {
		Long stopPrice = 20L;
		order.setOrderType(OrderTypeEnum.Market);
		order.setStopPrice(stopPrice);
		manager.createOrder(order);
	}

	@Test(expected = PriceNotBlankForMarketOrder.class)
	public void notBeAbleToEnterLimitPriceIfMarketOrder()
			throws EquityOrderException, NotAllowed {
		Long limitPrice = 20L;
		order.setOrderType(OrderTypeEnum.Market);
		order.setLimitPrice(limitPrice);
		manager.createOrder(order);
	}

	@Test(expected = LimitPriceBlankForLimitOrder.class)
	public void notBeAbleToLeaveLimitPriceBlankIfLimitOrder()
			throws EquityOrderException, NotAllowed {
		Long limitPrice = null;
		order.setOrderType(OrderTypeEnum.Limit);
		order.setLimitPrice(limitPrice);
		manager.createOrder(order);
	}

	@Test(expected = StopPriceNotBlankForLimitOrder.class)
	public void notBeAbleToEnterStopPriceIfLimitOrder()
			throws EquityOrderException, NotAllowed {
		Long stopPrice = 20L;
		Long limitPrice = 20L;
		order.setOrderType(OrderTypeEnum.Limit);
		order.setLimitPrice(limitPrice);
		order.setStopPrice(stopPrice);
		manager.createOrder(order);
	}

	@Test(expected = StopPriceBlankForStopOrder.class)
	public void notBeAbleToLeaveStopPriceBlankIfStopOrder()
			throws EquityOrderException, NotAllowed {
		Long stopPrice = null;
		order.setOrderType(OrderTypeEnum.Stop);
		order.setStopPrice(stopPrice);
		manager.createOrder(order);
	}

	@Test(expected = LimitPriceNotBlankForStopOrder.class)
	public void notBeAbleToEnterLimitPriceIfStopOrder()
			throws EquityOrderException, NotAllowed {
		Long limitPrice = 20L;
		Long stopPrice = 20L;
		order.setOrderType(OrderTypeEnum.Stop);
		order.setStopPrice(stopPrice);
		order.setLimitPrice(limitPrice);
		manager.createOrder(order);
	}

	@Test(expected = StopPriceBlankForStopLimitOrder.class)
	public void notBeAbleToLeaveStopPriceBlankIfStopLimitOrder()
			throws EquityOrderException, NotAllowed {
		Long limitPrice = 20L;
		Long stopPrice = null;
		order.setOrderType(OrderTypeEnum.StopLimit);
		order.setStopPrice(stopPrice);
		order.setLimitPrice(limitPrice);
		manager.createOrder(order);
	}

	@Test(expected = LimitPriceBlankForStopLimitOrder.class)
	public void notBeAbleToLeaveLimitPriceBlankIfStopLimitOrder()
			throws EquityOrderException, NotAllowed {
		Long limitPrice = null;
		Long stopPrice = 20L;
		order.setOrderType(OrderTypeEnum.StopLimit);
		order.setStopPrice(stopPrice);
		order.setLimitPrice(limitPrice);
		manager.createOrder(order);
	}

	

	@Test(expected = InvalidQuantityEntered.class)
	public void notBeAbleToPassQtyAsZero() throws NotAllowed,
			EquityOrderException {
		order.setQuantity(0L);
		manager.createOrder(order);
	}

	@Test(expected = InvalidQuantityEntered.class)
	public void notBeAbleToPassNegativeQty() throws NotAllowed,
			EquityOrderException {
		order.setQuantity(-1L);
		manager.createOrder(order);
	}

}

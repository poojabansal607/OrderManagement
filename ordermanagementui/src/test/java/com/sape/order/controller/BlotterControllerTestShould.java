package com.sape.order.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import com.sape.order.bm.OrderManager;
import com.sape.order.enums.OrderStatusEnum;
import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.model.EquityOrder;

public class BlotterControllerTestShould {
	BlotterController blotterController ;
	
	@Mock
	OrderManager orderManager;

	@Before
	public void setup() {
		blotterController = new BlotterController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showAllOrdersView() {
		blotterController.setOrderManager(orderManager);
		ModelAndView modelAndView = blotterController.showAllOrders();
		assertNotNull(modelAndView);
	}
	@Test
	public void seeAllOrders() {
		blotterController.setOrderManager(orderManager);
		EquityOrder createdEquityOrder = new EquityOrder();
		createdEquityOrder.setOrderId(10L);
		createdEquityOrder.setOrderType(OrderTypeEnum.Market);
		createdEquityOrder.setQuantity(5L);
		createdEquityOrder.setOrderStatus(OrderStatusEnum.New);
		List<EquityOrder> equityOrderList = new ArrayList<EquityOrder>();
		equityOrderList.add(createdEquityOrder);
		when(orderManager.fetchAllOrders()).thenReturn(equityOrderList);
		ModelAndView modelAndView = blotterController.showAllOrders();
		assertNotNull(modelAndView);
	}
}

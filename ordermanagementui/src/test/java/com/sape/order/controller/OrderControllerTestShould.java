package com.sape.order.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import com.sape.order.bm.OrderManager;
import com.sape.order.enums.OrderStatusEnum;
import com.sape.order.exceptions.EquityOrderException;
import com.sape.order.exceptions.NotAllowed;
import com.sape.order.model.EquityOrder;
import com.sape.order.validator.EquityOrderValidator;

public class OrderControllerTestShould {
	OrderController orderController = null;

	static EquityOrder equityOrder;

	@InjectMocks
	BindingResult bindingResult = new BeanPropertyBindingResult(equityOrder,
			"EquityOrder");;
	@Mock
	OrderManager orderManager;

	@Mock
	EquityOrderValidator equityOrderValidator;

	@BeforeClass
	public static void init() {
		equityOrder = new EquityOrder();
	}

	@Before
	public void setup() {

		orderController = new OrderController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showCreateOrderView() {
		ModelAndView modelAndView = orderController.showCreateOrderView(null);
		assertNotNull(modelAndView);
	}

	@Test
	public void beAbleToCreateOrder() throws NotAllowed, EquityOrderException {
		orderController.setOrderManager(orderManager);
		orderController.setEquityOrderValidator(equityOrderValidator);
		EquityOrder createdEquityOrder = new EquityOrder();
		createdEquityOrder.setOrderId(10L);
		createdEquityOrder.setNotes("hi notes");
		createdEquityOrder.setOrderStatus(OrderStatusEnum.New);
		doNothing().when(equityOrderValidator).validate(equityOrder,
				bindingResult);
		when(orderManager.createOrder(equityOrder)).thenReturn(
				createdEquityOrder);
		ModelAndView mav = orderController.createOrder(equityOrder,
				bindingResult);
		assertNotNull(mav);
	}

	@Test
	public void beAbleToSeeErrorsIfValidationFails() throws NotAllowed,
			EquityOrderException {
		orderController.setOrderManager(orderManager);
		orderController.setEquityOrderValidator(equityOrderValidator);
		EquityOrder createdEquityOrder = new EquityOrder();
		createdEquityOrder.setOrderId(10L);
		createdEquityOrder.setNotes("hi notes");
		createdEquityOrder.setOrderStatus(OrderStatusEnum.New);
		ModelAndView mav = orderController.createOrder(equityOrder,
				bindingResult);
		assertNotNull(mav);
	}

}

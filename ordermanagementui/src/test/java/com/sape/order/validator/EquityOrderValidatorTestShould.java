package com.sape.order.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.model.EquityOrder;

public class EquityOrderValidatorTestShould {
	EquityOrderValidator equityOrderValidator = null;
	static EquityOrder equityOrder;// = new EquityOrder();

	@InjectMocks
	BindingResult bindingResult = new BeanPropertyBindingResult(equityOrder,
			"EquityOrder");

	@BeforeClass
	public static void setup1() {
		equityOrder = new EquityOrder();
	}

	@Before
	public void setup() {
		equityOrderValidator = new EquityOrderValidator();
		equityOrder = new EquityOrder();
	}

	@Test
	public void validateBlankLimitPriceAndStopPriceWhenOrderTypeIsMarket() {
		equityOrder.setLimitPrice(null);
		equityOrder.setStopPrice(null);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Market);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), false);
	}
	@Test
	public void validateNonBlankLimitPriceWhenOrderTypeIsMarket() {
		equityOrder.setLimitPrice(34L);
		equityOrder.setStopPrice(null);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Market);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}
	
	@Test
	public void validateNonBlankStopPriceWhenOrderTypeIsMarket() {
		equityOrder.setLimitPrice(null);
		equityOrder.setStopPrice(45L);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Market);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}


	@Test
	public void validateNonBlankLimitPriceAndBlankStopPriceWhenOrderTypeIsLimit() {
		equityOrder.setLimitPrice(40L);
		equityOrder.setStopPrice(null);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Limit);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), false);
	}
	@Test
	public void validateNonBlankStopPriceWhenOrderTypeIsLimit() {
		equityOrder.setLimitPrice(34L);
		equityOrder.setStopPrice(54L);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Limit);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}
	@Test
	public void validateBlankLimitPriceWhenOrderTypeIsLimit() {
		equityOrder.setLimitPrice(null);
		equityOrder.setStopPrice(54L);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Limit);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}

	@Test
	public void validateBlankLimitPriceAndNonBlankStopPriceWhenOrderTypeIsStop() {
		equityOrder.setLimitPrice(null);
		equityOrder.setStopPrice(60L);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Stop);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), false);
	}

	@Test
	public void validateNonBlankLimitPriceAndBlankStopPriceWhenOrderTypeIsStop() {
		equityOrder.setLimitPrice(34L);
		equityOrder.setStopPrice(null);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.Stop);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}
	@Test
	public void validateNonBlankLimitPriceAndNonBlankStopPriceWhenOrderTypeIsStopLimit() {
		equityOrder.setLimitPrice(60L);
		equityOrder.setStopPrice(60L);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.StopLimit);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), false);
	}
	@Test
	public void validateBlankLimitPriceAndBlankStopPriceWhenOrderTypeIsStopLimit() {
		equityOrder.setLimitPrice(null);
		equityOrder.setStopPrice(null);
		equityOrder.setQuantity(5L);
		equityOrder.setOrderType(OrderTypeEnum.StopLimit);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}
	@Test
	public void validateQuantityNull() {
		equityOrder.setQuantity(null);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}
	@Test
	public void validateQuantityCantBeZero() {
		equityOrder.setQuantity(0L);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}

	@Test
	public void validateQuantityCantBeNegative() {
		equityOrder.setQuantity(-5L);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), true);
	}

	@Test
	public void validateQuantityWithPositiveValue() {
		equityOrder.setQuantity(5L);
		equityOrderValidator.validate(equityOrder, bindingResult);
		assertEquals(bindingResult.hasErrors(), false);
	}

}

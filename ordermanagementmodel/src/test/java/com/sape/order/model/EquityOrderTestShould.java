package com.sape.order.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sape.order.enums.AccountTypeEnum;
import com.sape.order.enums.OrderQualifierEnum;
import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.enums.SideEnum;

public class EquityOrderTestShould {
	EquityOrder equityOrder = null;

	@Before
	public void setup() {
		equityOrder = new EquityOrder();
	}

	@Test
	public void getDefaultValueofSide() {
		SideEnum side = equityOrder.getSide();
		assertEquals(side, SideEnum.Buy);
	}

	@Test
	public void setSideSELL() {
		SideEnum side = SideEnum.Sell;
		equityOrder.setSide(side);
		assertEquals(equityOrder.getSide(), SideEnum.Sell);
	}

	@Test
	public void getDefaultValueOfOrderType() {
		OrderTypeEnum orderType = equityOrder.getOrderType();
		assertEquals(orderType, OrderTypeEnum.Market);
	}

	@Test
	public void setOrderTypeLIMIT() {
		OrderTypeEnum orderType = OrderTypeEnum.Limit;
		equityOrder.setOrderType(orderType);
		assertEquals(equityOrder.getOrderType(), OrderTypeEnum.Limit);
	}

	@Test
	public void setOrderTypeSTOPLIMIT() {
		OrderTypeEnum orderType = OrderTypeEnum.StopLimit;
		equityOrder.setOrderType(orderType);
		assertEquals(equityOrder.getOrderType(), OrderTypeEnum.StopLimit);
	}

	@Test
	public void setOrderTypeSTOP() {
		OrderTypeEnum orderType = OrderTypeEnum.Stop;
		equityOrder.setOrderType(orderType);
		assertEquals(equityOrder.getOrderType(), OrderTypeEnum.Stop);
	}

	@Test
	public void getDefaultValueOfOrderQualifier() {
		OrderQualifierEnum orderType = equityOrder.getOrderQualifier();
		assertEquals(orderType, OrderQualifierEnum.DayOrder);
	}

	@Test
	public void setOrderQualifierGTC() {
		OrderQualifierEnum orderQualifier = OrderQualifierEnum.GoodTillCancelled;
		equityOrder.setOrderQualifier(orderQualifier);
		assertEquals(equityOrder.getOrderQualifier(),
				OrderQualifierEnum.GoodTillCancelled);
	}

	@Test
	public void getDefaultValueOfAccountType() {
		AccountTypeEnum accountType = equityOrder.getAccountType();
		assertEquals(accountType, AccountTypeEnum.Cash);
	}

	@Test
	public void setAccountTypeMARGIN() {
		AccountTypeEnum accountType = AccountTypeEnum.Margin;
		equityOrder.setAccountType(accountType);
		assertEquals(equityOrder.getAccountType(), AccountTypeEnum.Margin);
	}

	@Test
	public void verifyQuantity() {
		Long value = 45L;
		equityOrder.setQuantity(value);
		assertEquals(equityOrder.getQuantity(), value);
	}

	@Test
	public void verifyLimitPrice() {
		Long value = 90L;
		equityOrder.setLimitPrice(value);
		assertEquals(equityOrder.getLimitPrice(), value);
	}

	@Test
	public void verifyStopPrice() {
		Long value = 90L;
		equityOrder.setStopPrice(value);
		assertEquals(equityOrder.getStopPrice(), value);
	}

	@Test
	public void verifyNotes() {
		String notes = "notes dummy value";
		equityOrder.setNotes(notes);
		assertEquals(equityOrder.getNotes(), notes);
	}

	@Test
	public void verifySecurityTicker() {
		String securityTicker = "security ticker dummy value";
		equityOrder.setSecurityTicker("SWAP");
		assertEquals(equityOrder.getSecurityTicker(), securityTicker);
	}

}

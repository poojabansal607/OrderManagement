package com.sape.order.microtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import org.hsqldb.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.sape.order.bm.OrderManager;
import com.sape.order.bm.impl.OrderManagerImpl;
import com.sape.order.dao.OrderDAO;
import com.sape.order.enums.AccountTypeEnum;
import com.sape.order.enums.OrderQualifierEnum;
import com.sape.order.enums.OrderStatusEnum;
import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.enums.SideEnum;
import com.sape.order.exceptions.EquityOrderException;
import com.sape.order.exceptions.NotAllowed;
import com.sape.order.model.EquityOrder;

public class ToCreateEquityOrderPMShould {

	private OrderManagerImpl manager;

	private EquityOrder order;

	@Mock
	private OrderDAO orderDao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		order = new EquityOrder();
		order.setQuantity(0L);
		manager = new OrderManagerImpl();
		manager.setOrderDao(orderDao);
	}

	@Test
	public void beAbleToloadTheCreateEquityOrderScreen() {
		assertSame(SideEnum.Buy, order.getSide());
		assertSame(OrderTypeEnum.Market, order.getOrderType());
		assertSame(OrderQualifierEnum.DayOrder, order.getOrderQualifier());
		assertSame(AccountTypeEnum.Cash, order.getAccountType());
		assertTrue(order.getQuantity() == 0L);
		assertNull(order.getStopPrice());
		assertNull(order.getLimitPrice());
		assertNull(order.getNotes());
	}

	@Test
	public void beAbleToSelectASide() {
		SideEnum selectedSide = SideEnum.Sell;
		order.setSide(selectedSide);
		assertSame(selectedSide, order.getSide());
		selectedSide = SideEnum.Buy;
		order.setSide(selectedSide);
		assertSame(selectedSide, order.getSide());
	}

	@Test
	public void beAbleToSelectAOrderType() {
		OrderTypeEnum selectedOrderType = OrderTypeEnum.Market;
		order.setOrderType(selectedOrderType);
		assertSame(selectedOrderType, order.getOrderType());

		selectedOrderType = OrderTypeEnum.Limit;
		order.setOrderType(selectedOrderType);
		assertSame(selectedOrderType, order.getOrderType());

		selectedOrderType = OrderTypeEnum.Stop;
		order.setOrderType(selectedOrderType);
		assertSame(selectedOrderType, order.getOrderType());

		selectedOrderType = OrderTypeEnum.StopLimit;
		order.setOrderType(selectedOrderType);
		assertSame(selectedOrderType, order.getOrderType());
	}

	@Test
	public void beAbleToSelectOrderQualifier() {
		OrderQualifierEnum selectedOrderQualifier = OrderQualifierEnum.DayOrder;
		order.setOrderQualifier(selectedOrderQualifier);
		assertSame(selectedOrderQualifier, order.getOrderQualifier());
		selectedOrderQualifier = OrderQualifierEnum.GoodTillCancelled;
		order.setOrderQualifier(selectedOrderQualifier);
		assertSame(selectedOrderQualifier, order.getOrderQualifier());
	}

	@Test
	public void beAbleToSelectAnAccountType() {
		AccountTypeEnum selectedAccountType = AccountTypeEnum.Cash;
		order.setAccountType(selectedAccountType);
		assertSame(selectedAccountType, order.getAccountType());
		selectedAccountType = AccountTypeEnum.Margin;
		order.setAccountType(selectedAccountType);
		assertSame(selectedAccountType, order.getAccountType());
	}

	@Test
	public void beAbleToEnterQty() {
		Long qty = 12L;
		order.setQuantity(qty);
		assertSame(qty, order.getQuantity());
	}

	@Test
	public void beAbleToEnterPrice() {
		Long stopPrice = 10L;
		order.setStopPrice(stopPrice);
		assertSame(stopPrice, order.getStopPrice());
		Long limitPrice = 20L;
		order.setLimitPrice(limitPrice);
		assertSame(limitPrice, order.getLimitPrice());
	}

	@Test
	public void beAbleToEnterComments() {
		String comments = "Comments";
		order.setNotes(comments);
		assertSame(comments, order.getNotes());
	}

	@Test
	public void beAbleToSaveOrder() throws NotAllowed, EquityOrderException {
		order.setQuantity(1L);
		final Long orderId = 1L;
		when(orderDao.createOrder(order)).thenAnswer(new Answer<EquityOrder>() {
			public EquityOrder answer(InvocationOnMock invocation)
					throws Throwable {
				EquityOrder orderAfterCreation = (EquityOrder) invocation
						.getArguments()[0];
				orderAfterCreation.setOrderId(orderId);
				orderAfterCreation.setOrderStatus(OrderStatusEnum.New);
				return orderAfterCreation;
			}
		});
		EquityOrder savedOrder = manager.createOrder(order);
		assertNotNull(savedOrder.getOrderId());
		assertSame(OrderStatusEnum.New, savedOrder.getOrderStatus());
	}

	@Test
	public void beAbleToLookAllOrders() throws NotAllowed, EquityOrderException {
		final Long orderId = 1L;
		final List<EquityOrder> list = new ArrayList<EquityOrder>();
		when(orderDao.fetchAllOrders()).thenAnswer(
				new Answer<List<EquityOrder>>() {

					public List<EquityOrder> answer(InvocationOnMock invocation)
							throws Throwable {
						EquityOrder orderAfterCreation = new EquityOrder();
						orderAfterCreation.setOrderId(orderId);
						orderAfterCreation.setOrderStatus(OrderStatusEnum.New);
						list.add(orderAfterCreation);
						return list;
					}

				});
		List<EquityOrder> fetchedOrders = manager.fetchAllOrders();
		assertNotNull(fetchedOrders);
		assertEquals(fetchedOrders.size(), 1);
	}
}

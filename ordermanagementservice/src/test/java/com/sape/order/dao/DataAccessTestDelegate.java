package com.sape.order.dao;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.sape.order.dao.OrderDAO;

public class DataAccessTestDelegate extends
		AbstractTransactionalDataSourceSpringContextTests {

	private OrderDAO orderDao;
	
	private TestOrderDAO testOrderDao;

	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	public void setup() throws Exception {
		super.setUp();
	}

	public void teardown() throws Exception {
		super.tearDown();
	}

	/**
	 * Reference the Spring configuration file for the test case.
	 */
	protected String[] getConfigLocations() {
		return new String[] { "test-application-context.xml" };
	}

	/**
	 * @return the testOrderDao
	 */
	public TestOrderDAO getTestOrderDao() {
		return testOrderDao;
	}

	/**
	 * @param testOrderDao the testOrderDao to set
	 */
	public void setTestOrderDao(TestOrderDAO testOrderDao) {
		this.testOrderDao = testOrderDao;
	}



}
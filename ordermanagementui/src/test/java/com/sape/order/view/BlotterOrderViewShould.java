package com.sape.order.view;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.sape.order.controller.BlotterController;

public class BlotterOrderViewShould {
	private WebDriver driver;

	@Mock
	BlotterController controller;

	@Before
	public void setUp() {
		// Create a new instance of the html unit driver
		driver = new HtmlUnitDriver();
		// Navigate to desired web page
		driver.get("http://localhost:8080/tdd/blotterAction.htm");
	}

	@Test
	public void allowUserToViewOrderId() {
		WebElement orderId = driver.findElement(By.id("orderId"));
		assertEquals("OrderId", orderId.getText());
	}

	@Test
	public void allowUserToViewStatus() {
		WebElement status = driver.findElement(By.id("status"));
		assertEquals("Status", status.getText());
	}

	@Test
	public void allowUserToViewQuantity() {
		WebElement quantity = driver.findElement(By.id("quantity"));
		assertEquals("Quantity", quantity.getText());
	}

	@Test
	public void allowUserToViewOrderType() {
		WebElement orderType = driver.findElement(By.id("orderType"));
		assertEquals("OrderType", orderType.getText());
	}

	@Test
	public void allowUserToViewQualifier() {
		WebElement qualifier = driver.findElement(By.id("qualifier"));
		assertEquals("OrderQualifier", qualifier.getText());
	}

	@Test
	public void allowUserToViewAccountType() {
		WebElement accountType = driver.findElement(By.id("accountType"));
		assertEquals("AccountType", accountType.getText());
	}

	@Test
	public void allowUserToViewStopPrice() {
		WebElement stopPrice = driver.findElement(By.id("stopPrice"));
		assertEquals("StopPrice", stopPrice.getText());
	}

	@Test
	public void allowUserToViewLimitPrice() {
		WebElement limitPrice = driver.findElement(By.id("limitPrice"));
		assertEquals("LimitPrice", limitPrice.getText());
	}

}

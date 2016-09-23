package com.sape.order.view;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sape.order.controller.OrderController;

public class CreateOrderViewShould {
	private WebDriver driver;

	@Mock
	OrderController controller;

	@Before
	public void setUp() {
		// Create a new instance of the html unit driver
		driver = new HtmlUnitDriver();
		// Navigate to desired web page
		driver.get("http://localhost:8080/tdd/createOrderAction.htm");
	}

	@Test
	public void allowUserToViewDefaultSideAsBuy() {
		WebElement buySide = driver.findElement(By.id("buySide"));
		WebElement sellSide = driver.findElement(By.id("sellSide"));
		assertEquals(Boolean.TRUE, buySide.isSelected());
		assertEquals(Boolean.FALSE, sellSide.isSelected());
	}

	@Test
	public void allowUserToChooseSideAsSell() {
		WebElement sellSide = driver.findElement(By.id("sellSide"));
		sellSide.click();
		assertEquals(Boolean.TRUE, sellSide.isSelected());
	}

	@Test
	public void allowUserToViewDefaultOrderTypeAsMarket() {
		WebElement marketOrderType = driver.findElement(By.id("market"));
		WebElement limitOrderType = driver.findElement(By.id("limit"));
		WebElement stopOrderType = driver.findElement(By.id("stop"));
		WebElement stopLimitOrderType = driver.findElement(By.id("stopLimit"));
		assertEquals(Boolean.TRUE, marketOrderType.isSelected());
		assertEquals(Boolean.FALSE, limitOrderType.isSelected());
		assertEquals(Boolean.FALSE, stopOrderType.isSelected());
		assertEquals(Boolean.FALSE, stopLimitOrderType.isSelected());
	}

	@Test
	public void allowUserToChooseOrderTypeAsLimit() {
		WebElement limitOrderType = driver.findElement(By.id("limit"));
		limitOrderType.click();
		assertEquals(Boolean.TRUE, limitOrderType.isSelected());
	}

	@Test
	public void allowUserToChooseOrderTypeAsStop() {
		WebElement stopOrderType = driver.findElement(By.id("stop"));
		stopOrderType.click();
		assertEquals(Boolean.TRUE, stopOrderType.isSelected());
	}

	@Test
	public void allowUserToChooseOrderTypeAsStopLimit() {
		WebElement stopLimitOrderType = driver.findElement(By.id("stopLimit"));
		stopLimitOrderType.click();
		assertEquals(Boolean.TRUE, stopLimitOrderType.isSelected());
	}

	@Test
	public void allowUserToViewDefaultOrderQualifierAsDay() {
		WebElement dayQualifier = driver
				.findElement(By.id("dayOrderQualifier"));
		WebElement gtcQualifier = driver
				.findElement(By.id("gtcOrderQualifier"));
		assertEquals(Boolean.TRUE, dayQualifier.isSelected());
		assertEquals(Boolean.FALSE, gtcQualifier.isSelected());
	}

	@Test
	public void allowUserToChooseOrderQualifierAsGTC() {
		WebElement gtsQualifier = driver
				.findElement(By.id("gtcOrderQualifier"));
		gtsQualifier.click();
		assertEquals(Boolean.TRUE, gtsQualifier.isSelected());
	}

	@Test
	public void allowUserToViewDefaultAccountTypeAsCash() {
		WebElement accountTypeCash = driver.findElement(By
				.id("accountTypeCash"));
		WebElement accountTypeMargin = driver.findElement(By
				.id("accountTypeMargin"));
		assertEquals(Boolean.TRUE, accountTypeCash.isSelected());
		assertEquals(Boolean.FALSE, accountTypeMargin.isSelected());
	}

	@Test
	public void allowUserToChooseAccountTypeAsMargin() {
		WebElement accountTypeMargin = driver.findElement(By
				.id("accountTypeMargin"));
		accountTypeMargin.click();
		assertEquals(Boolean.TRUE, accountTypeMargin.isSelected());
	}

	@Test
	public void allowUserToCreateAnOrder() {
		WebElement quantity = driver.findElement(By.id("quantity"));
		quantity.sendKeys("45");
		WebElement button = driver.findElement(By.id("Save"));
		// submit form
		button.submit();
		WebElement ele = driver.findElement(By.id("viewAllOrders"));
		assertEquals("View All Orders", ele.getText());
	}

}

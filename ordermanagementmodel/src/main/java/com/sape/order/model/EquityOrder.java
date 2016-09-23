package com.sape.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sape.order.enums.AccountTypeEnum;
import com.sape.order.enums.OrderQualifierEnum;
import com.sape.order.enums.OrderStatusEnum;
import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.enums.SideEnum;

@Entity
@Table(name = "EQUITY_ORDER")
public class EquityOrder {
	private SideEnum side = SideEnum.Buy;
	private OrderTypeEnum orderType = OrderTypeEnum.Market;
	private OrderQualifierEnum orderQualifier = OrderQualifierEnum.DayOrder;
	private AccountTypeEnum accountType = AccountTypeEnum.Cash;
	private Long quantity;
	private Long stopPrice;
	private Long limitPrice;
	private String notes;
	private OrderStatusEnum orderStatus;
	private Long orderId;



	private String securityTicker;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "ORDER_STATUS")
	@Type(type = "com.sape.order.dao.impl.mapper.OrderStatusUserType")
	public OrderStatusEnum getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEnum orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "SIDE")
	@Type(type = "com.sape.order.dao.impl.mapper.SideUserType")
	public SideEnum getSide() {
		return side;
	}

	public void setSide(SideEnum side) {
		this.side = side;

	}

	@Column(name = "ORDER_TYPE")
	@Type(type = "com.sape.order.dao.impl.mapper.OrderTypeUserType")
	public OrderTypeEnum getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderTypeEnum orderType) {
		this.orderType = orderType;

	}

	@Column(name = "ORDER_QUALIFIER")
	@Type(type = "com.sape.order.dao.impl.mapper.OrderQualifierUserType")
	public OrderQualifierEnum getOrderQualifier() {
		return orderQualifier;
	}

	public void setOrderQualifier(OrderQualifierEnum orderQualifier) {
		this.orderQualifier = orderQualifier;

	}

	@Column(name = "ACCOUNT_TYPE")
	@Type(type = "com.sape.order.dao.impl.mapper.AccountTypeUserType")
	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;

	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "ORDER_QTY")
	public Long getQuantity() {
		return quantity;
	}

	public void setStopPrice(Long value) {
		this.stopPrice = value;

	}

	@Column(name = "STOP_PRICE")
	public Long getStopPrice() {
		return stopPrice;
	}

	public void setLimitPrice(Long value) {
		this.limitPrice = value;

	}

	@Column(name = "LIMIT_PRICE")
	public Long getLimitPrice() {
		return limitPrice;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}

	@Column(name = "SECURITY_TICKER")
	public String getSecurityTicker() {
		return securityTicker;
	}

	public void setSecurityTicker(String securityTicker) {
		this.securityTicker = securityTicker;
	}
	/**
	 * Default constructor.
	 */
	public EquityOrder() {
		this.side = SideEnum.Buy;
		this.orderType = OrderTypeEnum.Market;
		this.orderQualifier = OrderQualifierEnum.DayOrder;
		this.accountType = AccountTypeEnum.Cash;
	}

	@Override
	public String toString() {
		return "EquityOrder{" +
				"side=" + side +
				", orderType=" + orderType +
				", orderQualifier=" + orderQualifier +
				", accountType=" + accountType +
				", quantity=" + quantity +
				", stopPrice=" + stopPrice +
				", limitPrice=" + limitPrice +
				", notes='" + notes + '\'' +
				", orderStatus=" + orderStatus +
				", orderId=" + orderId +
				'}';
	}
}

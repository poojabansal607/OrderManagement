package com.sape.order.dao.impl.mapper;

import com.sape.order.enums.OrderTypeEnum;

public class OrderTypeUserType extends EnumUserType<OrderTypeEnum> {
	public OrderTypeUserType() {
		super(OrderTypeEnum.class);
	}
}

package com.sape.order.dao.impl.mapper;

import com.sape.order.enums.OrderStatusEnum;

public class OrderStatusUserType extends EnumUserType<OrderStatusEnum> {
	public OrderStatusUserType() {
		super(OrderStatusEnum.class);
	}
}

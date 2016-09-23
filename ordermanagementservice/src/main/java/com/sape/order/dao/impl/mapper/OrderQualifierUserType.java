package com.sape.order.dao.impl.mapper;

import com.sape.order.enums.OrderQualifierEnum;



public class OrderQualifierUserType extends EnumUserType<OrderQualifierEnum> {
	public OrderQualifierUserType() {
		super(OrderQualifierEnum.class);
	}
}

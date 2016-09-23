package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;


/**
 * LimitPriceBlankForLimitOrder is raised when limit price is left blank for {@link OrderType#Limit}. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class LimitPriceBlankForLimitOrder  extends EquityOrderException{
	private static final long serialVersionUID = 1L;

	public LimitPriceBlankForLimitOrder() {
		super("LimitPriceBlankForLimitOrder");
	}
}

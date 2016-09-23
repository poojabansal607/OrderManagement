package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;


/**
 * LimitPriceBlankForStopLimitOrder is raised when limit price is left blank for {@link OrderType#StopLimit}. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class LimitPriceBlankForStopLimitOrder extends EquityOrderException {
	private static final long serialVersionUID = 1L;

	public LimitPriceBlankForStopLimitOrder() {
		super("LimitPriceBlankForStopLimitOrder");
	}
}

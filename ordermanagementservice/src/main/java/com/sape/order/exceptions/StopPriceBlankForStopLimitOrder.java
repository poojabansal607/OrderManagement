package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;


/**
 * StopPriceBlankForStopLimitOrder is raised when stop price is left blank for {@link OrderType#StopLimit}. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class StopPriceBlankForStopLimitOrder extends EquityOrderException {
	private static final long serialVersionUID = 1L;

	public StopPriceBlankForStopLimitOrder() {
		super("StopPriceBlankForStopLimitOrder");
	}
}

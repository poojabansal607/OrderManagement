package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;

/**
 * StopPriceNotBlankForLimitOrder is raised when stop price is not blank for
 * {@link OrderType#Limit}. It is raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class StopPriceNotBlankForLimitOrder extends EquityOrderException {
	private static final long serialVersionUID = 1L;

	public StopPriceNotBlankForLimitOrder() {
		super("StopPriceNotBlankForLimitOrder");
	}
}

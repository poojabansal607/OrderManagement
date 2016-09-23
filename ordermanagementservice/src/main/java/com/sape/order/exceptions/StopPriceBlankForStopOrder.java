package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;


/**
 * StopPriceBlankForStopOrder is raised when stop price is left blank for {@link OrderType#Stop}. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class StopPriceBlankForStopOrder extends EquityOrderException {
	private static final long serialVersionUID = 1L;

	public StopPriceBlankForStopOrder() {
		super("StopPriceBlankForStopOrder");
	}
}

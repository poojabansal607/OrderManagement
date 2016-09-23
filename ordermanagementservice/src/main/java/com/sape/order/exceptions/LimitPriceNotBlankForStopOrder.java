package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;


/**
 * LimitPriceNotBlankForStopOrder is raised when limit price is not blank for {@link OrderType#Stop}. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class LimitPriceNotBlankForStopOrder extends EquityOrderException {
	private static final long serialVersionUID = 1L;

	public LimitPriceNotBlankForStopOrder() {
		super("LimitPriceNotBlankForStopOrder");
	}
}

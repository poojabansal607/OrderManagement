package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;


/**
 * PriceNotBlankForMarketOrder is raised when price is not left blank for {@link OrderType#Market}. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class PriceNotBlankForMarketOrder extends EquityOrderException{
	private static final long serialVersionUID = 1L;

	public PriceNotBlankForMarketOrder() {
		super("PriceNotBlankForMarketOrder");
	}
}

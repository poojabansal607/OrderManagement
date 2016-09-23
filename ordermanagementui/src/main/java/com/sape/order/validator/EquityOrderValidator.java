package com.sape.order.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sape.order.enums.OrderTypeEnum;
import com.sape.order.model.EquityOrder;

/**
 * EquityOrderValidator validates the business rules for the creation of order
 * 
 * @author cmudga
 * 
 */
@Component
public class EquityOrderValidator implements Validator {

	public boolean supports(Class clazz) {
		return EquityOrder.class.equals(clazz);
	}

	/**
	 * validate the data provided on create order form
	 */
	public void validate(Object obj, Errors errors) {
		EquityOrder equityOrder = (EquityOrder) obj;
		EquityOrderValidator validator = new EquityOrderValidator();
		validator.validateLimitPrice(equityOrder.getLimitPrice(),
				equityOrder.getOrderType(), errors);
		validator.validateStopPrice(equityOrder.getStopPrice(),
				equityOrder.getOrderType(), errors);
		Long qty = equityOrder.getQuantity();
		boolean isValid = null != qty ? isQuantityValid(qty) : false;
		if (!isValid) {
			errors.rejectValue("quantity", "invalid.quantity");
		}

	}

	/**
	 * Validate LimitPrice based on the order type
	 * 
	 * @param limitPrice
	 * @param orderType
	 * @param errors
	 */
	private void validateLimitPrice(Long limitPrice, OrderTypeEnum orderType,
			Errors errors) {
		switch (orderType) {
		case Market:
			if (!checkIfPriceIsBlank(limitPrice)) {
				errors.rejectValue("limitPrice",
						"marketOrder.limitPrice.validate");
			}
			break;
		case Limit:
			if (checkIfPriceIsBlank(limitPrice)) {
				errors.rejectValue("limitPrice", "NotNull.target.limitPrice");
			}
			break;
		case Stop:
			if (!checkIfPriceIsBlank(limitPrice)) {
				errors.rejectValue("limitPrice",
						"stopOrder.limitPrice.validate");
			}
			break;
		case StopLimit:
			if (checkIfPriceIsBlank(limitPrice)) {
				errors.rejectValue("limitPrice", "NotNull.target.limitPrice");
			}
			break;
		}

	}

	/**
	 * Validate StopPrice based on the order type
	 * 
	 * @param stopPrice
	 * @param orderType
	 * @param errors
	 */
	private void validateStopPrice(Long stopPrice, OrderTypeEnum orderType,
			Errors errors) {
		switch (orderType) {
		case Market:
			if (!checkIfPriceIsBlank(stopPrice)) {
				errors.rejectValue("stopPrice",
						"marketOrder.stopPrice.validate");
			}
			break;
		case Limit:
			if (!checkIfPriceIsBlank(stopPrice)) {
				errors.rejectValue("stopPrice", "limitOrder.stopPrice.validate");
			}
			break;
		case Stop:
			if (checkIfPriceIsBlank(stopPrice)) {
				errors.rejectValue("stopPrice", "NotNull.target.stopPrice");
			}
			break;
		case StopLimit:
			if (checkIfPriceIsBlank(stopPrice)) {
				errors.rejectValue("stopPrice", "NotNull.target.stopPrice");
			}
			break;
		}

	}

	/**
	 * Check If Price Is Blank
	 * 
	 * @param price
	 * @return boolean
	 */
	private boolean checkIfPriceIsBlank(Long price) {
		boolean priceBlankFlag = false;
		if (price == null || "".equals(price)) {
			priceBlankFlag = true;
		}
		return priceBlankFlag;
	}

	/**
	 * Check if quantity is valid
	 * 
	 * @param qty
	 * @return boolean
	 */
	private boolean isQuantityValid(Long qty) {
		String validQuantity = "^[1-9]*+";
		Pattern pattern = Pattern.compile(validQuantity);
		Matcher matcher = pattern.matcher(qty.toString());
		return matcher.matches() ? true : false;
	}

}

package com.sape.order.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sape.order.bm.OrderManager;
import com.sape.order.exceptions.EquityOrderException;
import com.sape.order.exceptions.NotAllowed;
import com.sape.order.model.EquityOrder;
import com.sape.order.validator.EquityOrderValidator;

/**
 * OrderController is responsible for validating and creating the order
 * 
 * @author cmudga
 * 
 */
@Controller
@RequestMapping("/createOrderAction")
public class OrderController {
	@Autowired
	private OrderManager orderManager;

	@Autowired
	private EquityOrderValidator equityOrderValidator;

	private Logger logger = org.apache.log4j.Logger.getLogger(OrderController.class);



	/**
	 * Show Create Order View Page
	 * 
	 * @param equityOrder
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showCreateOrderView(
			@ModelAttribute("equityOrder") EquityOrder equityOrder) {
		return new ModelAndView("createOrder", "equityOrder", equityOrder);
	}

	/**
	 * Create the Order after validation of data
	 * 
	 * @param equityOrder
	 * @param result
	 * @return ModelAndView
	 * @throws NotAllowed
	 * @throws EquityOrderException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createOrder(
			@Valid @ModelAttribute("equityOrder") EquityOrder equityOrder,
			BindingResult result) throws NotAllowed, EquityOrderException {

		long startTime = System.currentTimeMillis();
		getEquityOrderValidator().validate(equityOrder, result);
		if (result.hasErrors()) {
			return new ModelAndView("createOrder", "equityOrder", equityOrder);
		}
		getOrderManager().createOrder(equityOrder);
		final Integer orderCount = getOrderManager().fetchOrderCount();
		long endTime = System.currentTimeMillis();
		/* logger.debug(String.format("createOrder [%s] processed in  [%s] ms",equityOrder, (endTime-startTime)));*/

		logger.info(String.format("PendingOrder count is : %s  %s Environment",orderCount,getOrderManager().getEnvironment()));
		return new ModelAndView("redirect:/blotterAction.htm");
	}

	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	public EquityOrderValidator getEquityOrderValidator() {
		return equityOrderValidator;
	}

	public void setEquityOrderValidator(
			EquityOrderValidator equityOrderValidator) {
		this.equityOrderValidator = equityOrderValidator;
	}

}

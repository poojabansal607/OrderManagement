package com.sape.order.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.sape.order.model.EquityOrder;
import com.sape.order.bm.*;

/**
 * Responsible for showing all the orders created so far.
 *
 * @author cmudga
 */
@Controller
@RequestMapping("/blotterAction")
public class BlotterController {
    @Autowired
    private OrderManager orderManager;

    private Logger LOGGER = LoggerFactory.getLogger(BlotterController.class);

    /**
     * Show all the orders created
     *
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllOrders() {
        long startTime = System.currentTimeMillis();
        List<EquityOrder> orders = getOrderManager().fetchAllOrders();
        long endTime = System.currentTimeMillis();
        LOGGER.debug(String.format("showAllOrders processed in [%s] ms", (endTime - startTime)));
        return new ModelAndView("blotter", "orders", orders);
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }

    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

}

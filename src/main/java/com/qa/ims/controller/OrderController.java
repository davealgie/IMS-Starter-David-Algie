package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private CustomerDAO customerDAO;
	private Utils utils;
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you wish to delete");
		Long id = utils.getLong();
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			if (orderItem.getOrderId()== id) {
				int deletedOrderItem = orderItemDAO.delete(orderItem.getId());
			}
		}
		return orderDAO.delete(id);
	}
	
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order");
		Long orderId = utils.getLong();
		// leaving the customer update part for now, not actually in MVP
		//LOGGER.info("Please enter the id of the customer making the order");
		//Long customerId = utils.getLong(); 
		Order order = orderDAO.read(orderId);
		LOGGER.info("First you will add any new items, then delete any old items. You do not have to both add and remove if you choose not to");
		addItem(order);
		removeItem(order);
		return order;
	}
	
	
	
	
}

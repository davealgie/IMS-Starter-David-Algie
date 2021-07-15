package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	private CustomerDAO customerDAO;
	private OrderItemDAO orderItemDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, ItemDAO itemDAO, OrderItemDAO orderItemDAO, CustomerDAO customerDAO,
			Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.itemDAO = itemDAO;
		this.orderItemDAO = orderItemDAO;
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		if (orders.size() < 1) {
			LOGGER.info("There are no orders stored in the database.");
			return orders;
		}
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter your customer id");
		Long customerID = utils.getLong();
		Order order = orderDAO.create(new Order(customerID));
		LOGGER.info("order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order");
		Long orderId = utils.getLong();
		Order order = orderDAO.read(orderId);
		addItem(order);
		removeItem(order);
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you wish to delete");
		Long id = utils.getLong();
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			if (orderItem.getOrderId() == id) {
				orderItemDAO.delete(orderItem.getOrderItemId());
			}
		}
		return orderDAO.delete(id);
	}

	private Order addItem(Order order) {
		List<Item> items = itemDAO.readAll();
		LOGGER.info("Here are the items you can currently add:");
		for (Item item : items) {
			LOGGER.info(item.getName());
		}
		LOGGER.info("Please enter an item to add. Enter 'Complete' when done");
		String newItem = utils.getString().toUpperCase();
		if (newItem.equalsIgnoreCase("COMPLETE")) {
			return order;
		} else {
			Long itemId = (long) -1;
			for (Item it : items) {
				if (it.getName().equalsIgnoreCase(newItem)) {
					itemId = it.getId();
				}
			}

			if (itemId != -1) {
				Item item = itemDAO.read(itemId);
				Order updatedOrder = orderDAO
						.update(new Order(order.getId(), (long) (order.getCustomerId() + item.getValue())));
				orderItemDAO.create(new OrderItem(updatedOrder.getId(), itemId));
				LOGGER.info("Item added");
				return addItem(updatedOrder);
			} else {
				LOGGER.info("No such item, please try again");
				order = addItem(order);
				return order;
			}
		}
	}

	private Order removeItem(Order order) {
		List<Item> items = itemDAO.readAll();
		LOGGER.info("Please enter an item to remove. Enter 'Complete' when you're finished");
		String newItem = utils.getString();
		if (newItem.toUpperCase().equalsIgnoreCase("COMPLETE")) {
			return order;
		} else {
			Long itemId = (long) -1;
			for (Item it : items) {
				if (it.getName().equalsIgnoreCase(newItem)) {
					itemId = it.getId();
				}
			}

			if (itemId != -1) {
				Item item = itemDAO.read(itemId);
				Order updatedOrder = orderDAO
						.update(new Order(order.getId(), (long) (order.getCustomerId() + item.getValue())));
				LOGGER.info(updatedOrder);
				List<OrderItem> orderItems = orderItemDAO.readAll();
				Long orderItemId = (long) -1;
				for (OrderItem n : orderItems) {
					if (n.getOrderId() == order.getId() && n.getItemId() == itemId) {
						orderItemId = n.getOrderItemId();
					}
				}

				if (orderItemId != -1) {
					orderItemDAO.delete(orderItemId);
					LOGGER.info("Item removed from order");
					return removeItem(updatedOrder);
				} else {
					LOGGER.info("Item isn't within order, please try again");
					return removeItem(order);
				}

			} else {
				LOGGER.info("Item doesn't exist, please try again");
				return removeItem(order);

			}

		}
	}

}

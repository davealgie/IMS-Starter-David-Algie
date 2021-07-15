package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class OrderTest {
	
	
	@Test
	public void constructor1() {
		Order order = new Order(1l,5.00);
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void constructor2() {
		Order order = new Order(1l,5.00);
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void testGetId() {
		Order order = new Order(1l,1l);
		Long expected = 1l;
		assertEquals(expected,order.getId());
	}
	
	@Test
	public void testSetId() {
		Order order = new Order(1l,5.00);
		order.setId(2l);
		Long expected = 2l;
		assertEquals(expected,order.getId());
	}
	
	@Test
	public void testGetCustomerId() {
		Order order = new Order(1l,1l);
		Long expected = 1l;
		assertEquals(expected,order.getCustomerId());
	}
	
	@Test
	public void testSetCustomerId() {
		Order order = new Order(1l,5.00);
		order.setCustomerId(2l);
		Long expected = 2l;
		assertEquals(expected,order.getCustomerId());
	}
	
}
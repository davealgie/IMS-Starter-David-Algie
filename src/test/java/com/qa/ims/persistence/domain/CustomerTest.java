package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CustomerTest {
	
	@Test
	public void constructor1() {
		Customer david = new Customer("David","Algie");
		assertTrue(david instanceof Customer);
	}
	
	@Test
	public void constructor2() {
		Customer david = new Customer(1l,"David","Algie");
		assertTrue(david instanceof Customer);
	}
	
	@Test
	public void testGetId() {
		Customer david = new Customer(1l,"David","Algie");
		Long expected = 1l;
		assertEquals(expected, david.getId());
	}
	
	@Test
	public void testSetId() {
		Customer david = new Customer("David","Algie");
		david.setId(2l);
		Long expected = 2l;
		assertEquals(expected, david.getId());
	}
	
	@Test
	public void testGetFirstName() {
		Customer david = new Customer("David","Algie");
		String expected = "David";
		assertEquals(expected, david.getFirstName());
	}
	
	@Test
	public void testSetFirstName() {
		Customer leaf = new Customer("David","Algie");
		leaf.setFirstName("NewDave");
		String expected = "NewDave";
		assertEquals(expected, leaf.getFirstName());
	}
	
	@Test
	public void testGetSurname() {
		Customer leaf = new Customer("David","Algie");
		String expected = "Algie";
		assertEquals(expected, leaf.getSurname());
	}
	
	@Test
	public void testSetSurname() {
		Customer leaf = new Customer("David","Algie");
		leaf.setSurname("NewAlgie");
		String expected = "NewAlgie";
		assertEquals(expected, leaf.getSurname());
	}

}

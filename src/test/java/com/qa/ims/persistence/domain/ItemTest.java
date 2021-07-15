package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
	
	@Test
	public void constructor1() {
		Item banana = new Item("banana",1.00);
		assertTrue(banana instanceof Item);
	}
	
	@Test
	public void constructor2() {
		Item banana = new Item(1l,"banana",1.00);
		assertTrue(banana instanceof Item);
	}
	
	@Test
	public void testGetId() {
		Item banana = new Item(1l,"banana",1.00);
		Long expected = 1l;
		assertEquals(expected,banana.getId());
	}
	
	@Test
	public void testSetId() {
		Item banana = new Item("banana",1.00);
		banana.setId(2l);
		Long expected = 2l;
		assertEquals(expected,banana.getId());
	}
	
	@Test
	public void testGetName() {
		Item banana = new Item("banana",1.00);
		String expected = "banana";
		assertEquals(expected,banana.getName());
	}
	
	@Test
	public void testSetName() {
		Item banana = new Item("banana",1.00);
		banana.setName("orange");
		String expected = "orange";
		assertEquals(expected,banana.getName());
	}
	
	@Test
	public void testGetPrice() {
		Item banana = new Item("banana",1.00);
		Double expected = 1.00;
		assertEquals(expected,banana.getValue());
	}
	
	@Test
	public void testSetPrice() {
		Item banana= new Item("banana",1.00);
		banana.setValue(4.50);
		Double expected = 4.50;
		assertEquals(expected,banana.getValue());
	}
	
}

package com.qa.ims.controllers;
import static org.junit.Assert.assertEquals;



import java.util.ArrayList;
import java.util.List;

 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

 

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

 

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    @Mock
    private Utils utils;

    @Mock
    private ItemDAO dao;

    @InjectMocks
    private ItemController controller;
    
	@Test
	public void testCreate() {
		final String name = "crisps";
		final Double value = 1.50;
		final Item item = new Item(name,value);
		
		Mockito.when(utils.getString()).thenReturn(name);
		Mockito.when(utils.getDouble()).thenReturn(value);
		Mockito.when(dao.create(item)).thenReturn(item);
		
		assertEquals(item,controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(item);
		
	}
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("crisps",1.50));
		
		Mockito.when(dao.readAll()).thenReturn(items);
		
		assertEquals(items,controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Item updated = new Item(1l, "pizza",10.0);
		
		Mockito.when(utils.getLong()).thenReturn(1l);
		Mockito.when(utils.getString()).thenReturn("pizza");
		Mockito.when(utils.getDouble()).thenReturn(10.0);
		Mockito.when(dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated,controller.update());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).update(updated);
	}
	
	@Test
    public void testDelete() {
        final long ID = 1l;

        Mockito.when(utils.getLong()).thenReturn(ID);
        Mockito.when(dao.delete(ID)).thenReturn(1);

        assertEquals(1l, this.controller.delete());

        Mockito.verify(utils, Mockito.times(1)).getLong();
        Mockito.verify(dao, Mockito.times(1)).delete(ID);
    }


}

package com.java.ibis.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.ibis.model.MenuItem;

public class MainTestingProject 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MenuItemDaoCollectionImpl menuItem = new MenuItemDaoCollectionImpl();
		
		List<MenuItem> menu = new ArrayList<>();
		
		menu = menuItem.getMenuItemListAdmin();
		
		System.out.println(menu);
		
		menu = menuItem.getMenuItemListCustomer();
		
		System.out.println(menu);
		
		MenuItem item = new MenuItem();
		
		item = menuItem.getMenuItem(2);
		
		System.out.println(item);
		
		MenuItem modifyItem = new MenuItem();
		Date setDate = new Date(121, 11, 8);
		
		modifyItem.setId(1);
		modifyItem.setName("Escova de Dente");
		modifyItem.setPrice(10.99f);
		modifyItem.setActive(false);
		modifyItem.setCategory("Higiene");
		modifyItem.setDateOfLaunch(setDate);
		modifyItem.setFreeDelivery(false);
		
		menuItem.modifyMenuItem(modifyItem);
		
		menu = menuItem.getMenuItemListCustomer();
		
		System.out.println(menu);
		
		menu = menuItem.getMenuItemListAdmin();
		
		System.out.println(menu);
		
		CartDaoCollectionImpl cart = new CartDaoCollectionImpl();
		
		cart.addCartItem(1, 1);
		cart.addCartItem(1, 0);
		
		cart.removeCartItem(1, 1);
		cart.removeCartItem(1, 0);
		
		try 
		{
			List<MenuItem> userCart = cart.getAllCartItems(1);
			
			System.out.println(userCart);
		} catch (CartEmptyException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

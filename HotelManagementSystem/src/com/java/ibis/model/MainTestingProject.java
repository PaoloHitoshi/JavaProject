package com.java.ibis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTestingProject 
{

	public static void main(String[] args) 
	{
		Date date = new Date(121, 11, 12);
		
		MenuItem itemOnMenu = new MenuItem();
		
		itemOnMenu.setId(0);
		itemOnMenu.setName("Paolo");
		itemOnMenu.setPrice(19.90f);
		itemOnMenu.setActive(true);
		itemOnMenu.setDateOfLaunch(date);
		itemOnMenu.setCategory("Food");
		itemOnMenu.setFreeDelivery(false);
		
		System.out.println(itemOnMenu.toString());
		System.out.println(itemOnMenu.equals(12));
		
		Cart cart = new Cart();
		
		List<MenuItem> cartList = new ArrayList<>();
		
		cartList.add(itemOnMenu);
		
		cart.setMenuItemList(cartList);
		cart.setTotal(1);
		
		System.out.println(cart.toString());
	}

}

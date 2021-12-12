package com.java.ibis.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.ibis.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao
{
	List<MenuItem> menuItemList = null;

	public List<MenuItem> getMenuItemListAdmin() 
	{
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() 
	{
		List<MenuItem> availableMenuItemList = new ArrayList<>();
		
		Date todayDate = new Date();
		
		for(MenuItem item : menuItemList)
		{
			if((todayDate.getDate() == item.getDateOfLaunch().getDate() || item.getDateOfLaunch().before(todayDate)) && item.isActive())
			{
				availableMenuItemList.add(item);
			}
		}
		return availableMenuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) 
	{
		for(MenuItem item : menuItemList)
		{
			if(item.equals(menuItem))
			{
				item.setId(menuItem.getId());
				item.setName(menuItem.getName());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setFreeDelivery(menuItem.isFreeDelivery());
				System.out.println("Item sucessfully modified!");
				return;
			}
		}
		System.out.println("Couldn't find the item...");
		return;
	}

	public MenuItem getMenuItem(long menuItemId) 
	{
		for(MenuItem item : menuItemList)
		{
			if(item.getId() == menuItemId)
			{
				return item;
			}
		}
		System.out.println("Couldn't find the item...");
		return null;
	}
	
	public MenuItemDaoCollectionImpl()
	{
		if(menuItemList == null)
		{
			menuItemList = new ArrayList<MenuItem>();
			
			MenuItem firstItem = new MenuItem();
			MenuItem secondItem = new MenuItem();
			MenuItem thirdItem = new MenuItem();
			
			Date setDate = new Date(121, 11, 8);
			
			firstItem.setId(0);
			firstItem.setName("Pasta de Dente");
			firstItem.setPrice(13.99f);
			firstItem.setActive(true);
			firstItem.setCategory("Higiene");
			firstItem.setDateOfLaunch(setDate);
			firstItem.setFreeDelivery(false);
			
			setDate = new Date(121, 11, 10);
			
			secondItem.setId(1);
			secondItem.setName("Escova de Dente");
			secondItem.setPrice(5.99f);
			secondItem.setActive(false);
			secondItem.setCategory("Higiene");
			secondItem.setDateOfLaunch(setDate);
			secondItem.setFreeDelivery(false);
			
			setDate = new Date(121, 11, 15);
			
			thirdItem.setId(2);
			thirdItem.setName("Fio Dental");
			thirdItem.setPrice(6.99f);
			thirdItem.setActive(true);
			thirdItem.setCategory("Higiene");
			thirdItem.setDateOfLaunch(setDate);
			thirdItem.setFreeDelivery(false);
			
			menuItemList.add(firstItem);
			menuItemList.add(secondItem);
			menuItemList.add(thirdItem);
		}
	}
}

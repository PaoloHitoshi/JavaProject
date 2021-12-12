package com.java.ibis.dao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.ibis.model.MenuItem;

public class MainMenuFinal 
{

	public static void main(String[] args) 
	{
		int searchId = 1;
		int options = -1;
		long itemId = -1;
		long userId = -1;
		Scanner input = new Scanner(System.in);
		
		CartDaoCollectionImpl userCart = new CartDaoCollectionImpl();
		MenuItemDaoCollectionImpl menuItemDao = new MenuItemDaoCollectionImpl();
		
		List<MenuItem> menuItemList = null;
		MenuItem menuItem = null;
		Date newDate = null;
		
		System.out.println("----- : Welcome to the Ibis hotel : -----");
		
		System.out.println("Select one of the following options: ");
		
		System.out.println("1 - Login as a Admin.");
		System.out.println("2 - Login as a Customer.");
		System.out.println("0 - Quit Application.");
		
		while(true)
		{
			options = input.nextInt();
			
			switch(options)
			{
				case 1: 
					System.out.println("Welcome back /ManagerNameHere/! ");
					
					System.out.println("Select one of the following options: ");
					System.out.println("1 - Get the items from the menu.");
					System.out.println("2 - Get the available items from the menu.");
					System.out.println("3 - Modify a item from the menu.");
					System.out.println("4 - Get an item from the menu.");
					System.out.println("5 - Get the items from a user cart.");
					System.out.println("6 - Remove a item from a user cart.");
					System.out.println("0 - Quit the application.");
					
					options = -1;
					
					while(true)
					{	
						options = input.nextInt();
						
						switch(options)
						{
							case 1:
								menuItemList = menuItemDao.getMenuItemListAdmin();
								
								System.out.format("ID\t\tName of the Product\tPrice\t\t\tActive\t\tLaunch Date\t\t\t\tCategory\tFree Delivery\n");
								
								for(MenuItem item : menuItemList)
								{
									System.out.format("%d\t\t%s\t\t%f\t\t%s\t\t%s\t\t%s\t\t%s\n", item.getId(), item.getName(), item.getPrice(), item.isActive(), item.getDateOfLaunch(), item.getCategory(), item.isFreeDelivery());
								}
								break;
								
							case 2:
								menuItemList = menuItemDao.getMenuItemListCustomer();
								
								System.out.println("ID\t\tName of the Product\t\tPrice\t\tActive\t\tLaunch Date\t\t\tCategory\t\tFree Delivery");
								
								for(MenuItem item : menuItemList)
								{
									System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.isActive() + "\t\t" + item.getDateOfLaunch() + "\t" + item.getCategory() + "\t\t" + item.isFreeDelivery());
								}
								break;
								
							case 3:
								menuItem = new MenuItem();
								newDate = new Date(121, 11, 12);
								
								menuItem.setId(1);
								menuItem.setName("Enxaguante Bucal");
								menuItem.setPrice(12.99f);
								menuItem.setActive(true);
								menuItem.setCategory("Higiene");
								menuItem.setDateOfLaunch(newDate);
								menuItem.setFreeDelivery(false);
								
								menuItemDao.modifyMenuItem(menuItem);
								break;
								
							case 4:
								System.out.println("Type the ID of the item: ");
								
								searchId = input.nextInt();
								
								menuItem = menuItemDao.getMenuItem(searchId);
								
								if(menuItem == null)
								{
									break;
								}
								
								System.out.println(menuItem.toString());
								break;
								
							case 5:
								System.out.println("Type the user ID: ");
								
								searchId = input.nextInt();
								
								try 
								{
									menuItemList = userCart.getAllCartItems(searchId);
									
									if(menuItemList == null)
									{
										break;
									}
									
									System.out.println(menuItemList);
								} catch (CartEmptyException e) 
								{
									e.getMessage();
								}
								break;
								
							case 6:
								System.out.println("Type the user ID: ");
								
								userId = input.nextInt();
								
								System.out.println("Type the item ID: ");
								
								itemId = input.nextInt();
								
								userCart.removeCartItem(userId, itemId);
								break;
								
							case 0: 
								System.out.println("Exiting application... Thank you for choosing Ibis!");
								return;
								
							default:
								System.out.println("Please select a valid option.");
								break;
						}
					}
				
				case 2:
					System.out.println("Type the user ID: ");
					
					userId = input.nextInt();
					
					System.out.println("Welcome back /UserNameHere/! ");
					
					System.out.println("Select one of the following options: ");
					System.out.println("1 - Get the items from the menu.");
					System.out.println("2 - Get all cart items.");
					System.out.println("3 - Add a item to the cart.");
					System.out.println("4 - Remove a item from the cart.");
					System.out.println("0 - Quit the application.");
					
					options = -1;
					
					while(true)
					{	
						options = input.nextInt();
						
						switch(options)
						{
							case 1:
								menuItemList = menuItemDao.getMenuItemListCustomer();
								
								System.out.println("ID\t\tName of the Product\t\tPrice\t\tActive\t\tLaunch Date\t\t\tCategory\t\tFree Delivery");
								
								for(MenuItem item : menuItemList)
								{
									System.out.println(item.getId() + "\t\t" + item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.isActive() + "\t\t" + item.getDateOfLaunch() + "\t" + item.getCategory() + "\t\t" + item.isFreeDelivery());
								}
								break;
								
							case 2:
								try 
								{
									menuItemList = userCart.getAllCartItems(userId);
									
									if(menuItemList == null)
									{
										break;
									}
									
									System.out.println(menuItemList);
								} catch (CartEmptyException e) 
								{
									e.getMessage();
								}
								break;
								
							case 3:
								System.out.println("Type the item ID: ");
								
								itemId = input.nextInt();
								
								userCart.addCartItem(userId, itemId);
								break;
								
							case 4:
								System.out.println("Type the item ID: ");
								
								itemId = input.nextInt();
								
								userCart.removeCartItem(userId, itemId);
								break;
								
							case 0: 
								System.out.println("Exiting application... Thank you for choosing Ibis!");
								return;
								
							default:
								System.out.println("Please select a valid option.");
								break;
						}
					}
				
				case 0:
					System.out.println("Exiting application... Thank you for choosing Ibis!");
					return;
				
				default:
					System.out.println("Please select a valid option.");
					break;
			}
		}
	}
}

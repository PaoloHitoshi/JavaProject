package com.java.ibis.dao;

import com.java.ibis.model.MenuItem;
import java.util.List;

public interface MenuItemDao 
{
	public List<MenuItem> getMenuItemListAdmin();
	
	public List<MenuItem> getMenuItemListCustomer();
	
	public void modifyMenuItem(MenuItem menuItem);
	
	public MenuItem getMenuItem(long menuItemId);
}

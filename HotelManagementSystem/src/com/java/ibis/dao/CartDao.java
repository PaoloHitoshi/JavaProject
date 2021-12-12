package com.java.ibis.dao;

import java.util.List;

import com.java.ibis.model.MenuItem;

public interface CartDao 
{
	public void addCartItem(long userId, long menuItemId);
	
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException; 
	
	public void removeCartItem(long userId, long menuItem);
}

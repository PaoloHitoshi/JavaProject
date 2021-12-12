package com.java.ibis.dao;

public class CartEmptyException extends Exception
{
	public CartEmptyException()
	{
		super("Carrinho Vazio!");
	}
}

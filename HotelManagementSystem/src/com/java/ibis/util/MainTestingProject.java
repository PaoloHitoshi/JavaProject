package com.java.ibis.util;

import java.util.Date;

public class MainTestingProject 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String Date = "12/12/2021";
		
		Date convertedDate = DateUtil.convertToDate(Date);
		
		System.out.println(convertedDate);
	}

}

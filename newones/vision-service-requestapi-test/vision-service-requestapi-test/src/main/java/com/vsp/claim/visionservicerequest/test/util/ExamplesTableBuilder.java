package com.vsp.claim.visionservicerequest.test.util;

/* Function: To allow for programatic building of a JBehave Examples table, and corresponding utilities that it entails.
 * Written By: Seth Van Grinsven
 * Date: 6/24/2014
 * Last Updated: 6/25/2014
 */

import java.util.ArrayList;

import org.jbehave.core.model.ExamplesTable;


public class ExamplesTableBuilder {

	private ArrayList<String> headers;
	private ArrayList<ArrayList<String>> values;
	private int maxLength;

	//Empty Constructor, inits
	public ExamplesTableBuilder()
	{
		headers = new ArrayList<String>();
		values = new ArrayList<ArrayList<String>>();
		maxLength = 1;
	}
	
	//Sets Headers and Values from string Array
	
	/*
	 * [0][0] First header
	 * [1][0] Second header
	 * [2][0] Third Header
	 * 
	 * [0][1] First Value First Header
	 * [1][1] First Value Second Header
	 * [2][1] First Value Third Header
	 */
	
	
	public ExamplesTableBuilder(String[][] str)
	{		
		headers = new ArrayList<String>();
		values = new ArrayList<ArrayList<String>>();
		maxLength = 1;
		
		for(int a = 0; a < str.length ; a++)
		{	
			addHeader(str[a][0]);
			
			for(int b = 1; b < str[a].length; b++)
			{
				addValue(str[a][0], str[a][b]);
			}
		}
		

	}
	
	
	//Adds New Header and New Row, Returns false if header already exists, true if header added successfully.
	public boolean addHeader(String key) {
		
		   for(int a = 0; a < headers.size(); a++)
		   {
			   if(key.equals(headers.get(a))){
				   return false;
			   }
		   }
		
		headers.add(key);
		values.add(new ArrayList<String>());
		return true;
	}
	
	public void addValues(String key, String... value)
	{
		addHeader(key);
		
		for(String s : value)
		{
			addValue(key,s);
		}
	}
	
	
	//Adds Value to Key, If no Key exists, Creates new Key and Recalls itself.
   public void addValue(String key, String v) {
		
		for(int a = 0; a < headers.size(); a++)
		{
			//If header Exists, add value in corresponding arrayList;
			if(key.equals(headers.get(a)))
			{
				ArrayList<String> temp = values.get(a);
				temp.add(v);
				if(temp.size() > maxLength) maxLength = temp.size();
				return;
			}
		}
		
		//Adds Header, Recursive Call
		addHeader(key);
		addValue(key,v);
	}
   
   public void addHeaders(String... headers)
   {
	   for(String a : headers)
	   {
		   addHeader(a);
	   }
   }
   
   //Removes all corresponding values
   public void removeHeader(String str)
   {
	   for(int a = 0; a < headers.size(); a++)
	   {
		   if(str.equals(headers.get(a))){
			   headers.remove(a);
			   values.remove(a);
		   }
	   }
	   
	   recalcLongestList();
   }
   
   public void removeValue(String key, String value)
   {
	   for(int a = 0; a < headers.size(); a++)
	   {
		   if(key.equals(headers.get(a))){
			
			   ArrayList<String> arr = values.get(a);
			   for(int b = 0 ; b < arr.size(); b++)
			   {
				   if(arr.get(b).equals(value)) arr.remove(b);
			   }
		   }
	   }
	   
	   recalcLongestList();
   }
    //Compiles the Data from the arrays to make the build string
	public ExamplesTable build(){
		
		
		
		//Returns table
		return new ExamplesTable(getBuildString());
	}
	
	private void recalcLongestList()
	{
		maxLength = 1;
		
		for(int a = 0; a < headers.size();a++)
		{
			if(values.get(a).size() > maxLength) maxLength = values.get(a).size();
		}
	}
	
	public void clear()
	{
		
		headers = new ArrayList<String>();
		values = new ArrayList<ArrayList<String>>();
		maxLength = 1;
		
	}

	
	public String getBuildString()
	{

		//Init
		String buildString = "|";
		
		//First Row, Headers
		for(String a : headers)
		{
			buildString += a + '|';
		}
		buildString += "\r\n|";
			
		
		//Loops through the arrays, if no value exists, uses "", else uses value.  
		for(int a = 0; a < maxLength; a++)
		{
			for(int b = 0; b < headers.size(); b++)
			{
				String input = "";
				ArrayList<String> tempArray = values.get(b);
				if(tempArray.size() > a)
				{
					input = tempArray.get(a);
				}
				

					buildString += input + '|';

			}
			
			if(a != maxLength - 1) buildString += "\r\n|";
			 
		}
		
		return buildString;
	}
	
	
	


}

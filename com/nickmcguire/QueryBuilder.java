package com.nickmcguire;

public class QueryBuilder extends Query
{
	public QueryBuilder command(Command command)
	{
		super.setCommand(command);
		return this;
	}
	
	public QueryBuilder args(String args)
	{
		super.setArgs(args);
		return this;
	}
	
	public QueryBuilder from(String from)
	{
		super.setFrom(from);
		return this;
	}
	
	public QueryBuilder where(String where)
	{
		super.setWhere(where);
		return this;
	}
	
	public QueryBuilder order(String order, boolean isDesc)
	{
		super.setOrder(order, isDesc);
		return this;
	}
	
	public QueryBuilder values(String values)
	{
		super.setValues(values);
		return this;
	}
	
	public QueryBuilder doesExist(boolean doesExist)
	{
		super.setDoesExist(doesExist);
		return this;
	}
}

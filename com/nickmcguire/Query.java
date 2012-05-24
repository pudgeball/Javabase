package com.nickmcguire;

public class Query
{
	private Command command;
	private String args, from, where, order, values;
	private boolean isDesc;
	
	public String getQuery()
	{
		return getCommand()+getArgs()+getFrom()+getWhere()+getOrder()+";";
	}
	
	public String getInsertQuery()
	{
		return getCommand()+getArgs()+getValues()+";";
	}
	
	public String getCommand()
	{
		return command.toString();
	}
	
	public String getArgs()
	{
		return " "+args;
	}
	
	public String getFrom()
	{
		return " FROM " + from;
	}
	
	public String getWhere()
	{
		if (where != null)
			return " WHERE " + where;
		else
			return "";
	}
	
	public String getOrder()
	{
		if (order != null)
			return " ORDER BY " + order + " " + getIsDesc();
		else
			return "";
	}
	
	public String getValues()
	{
		if (values != null)
			return " VALUES(" + values + ")";
		else
			return "";
	}
	
	public String getIsDesc()
	{
		if (isDesc)
			return "DESC";
		else
			return "ASC";
	}
	
	public void setCommand(Command command)
	{
		this.command = command;
	}
	
	public void setArgs(String args)
	{
		this.args = args;
	}
	
	public void setFrom(String from)
	{
		this.from = from;
	}
	
	public void setWhere(String where)
	{
		this.where = where;
	}
	
	public void setOrder(String order, boolean descending)
	{
		this.order = order;
		isDesc = descending;
	}
	
	public void setValues(String values)
	{
		this.values = values;
	}
}

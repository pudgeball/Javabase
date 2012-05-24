package com.nickmcguire;

public class Query
{
	private Command command;
	private String args, from, where, order, values;
	
	public Query(Command command, String args, String from, String where, String order, String values)
	{
		this.command = command;
		this.args = args;
		this.from = from;
		this.where = where;
		this.order = order;
		this.values = values;
	}
	
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
			return " ORDER BY " + order;
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
	
	public void setCommand(Command command)
	{
		this.command = command;
	}
	
	public void setFrom(String from)
	{
		this.from = from;
	}
	
	public void setWhere(String where)
	{
		this.where = where;
	}
	
	public void setOrder(String order)
	{
		this.order = order;
	}
}

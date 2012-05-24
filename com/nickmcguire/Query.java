package com.nickmcguire;

public class Query
{
	private Command command;
	private String args, from, where, order, values;
	private boolean isDesc, doesExist;
	
	public String getQuery()
	{
		switch (command)
		{
			case SELECT:
				return getSelectQuery();
			case INSERT:
				return getInsertQuery();
			case CREATE:
			case CREATETABLE:
				return getCreateQuery();
			case DROP:
				return getDropQuery();
			default:
				return "err";
		}
	}
	
	private String getCreateQuery()
	{
		//CREATE TABLE [IF NOT EXISTS] tablename(args, ...);
		//CREATE DATABASE databasename;
		//CREATE USER username [IDENTIFIED BY PASSWORD password];
		if (command == Command.CREATETABLE)
			return getCommand()+getDoesExist()+getArgs()+";";
		else
			return "";
	}
	
	private String getSelectQuery()
	{
		//SELECT values FROM tablename WHERE arg ORDER BY arg;
		return getCommand()+getArgs()+getFrom()+getWhere()+getOrder()+";";
	}
	
	private String getInsertQuery()
	{
		//INSERT INTO table(arg) VALUES(arg);
		return getCommand()+getArgs()+getValues()+";";
	}
	
	private String getDropQuery()
	{
		//DROP TABLE [IF EXISTS] tablename [, tablename];
		return "DROP " + getDoesExist();
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
		return (where != null) ? " WHERE " + where :  "";
	}
	
	public String getOrder()
	{
		return (order != null) ? " ORDER BY " + order + " " + getIsDesc() : "";
	}
	
	public String getValues()
	{
		return (values != null) ? " VALUES(" + values + ")" : "";
	}
	
	public String getIsDesc()
	{
		return (isDesc) ? "DESC" : "ASC";
	}
	
	public String getDoesExist()
	{
		return (doesExist) ? " IF NOT EXISTS" : "";
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
	
	public void setDoesExist(boolean doesExist)
	{
		this.doesExist = doesExist;
	}
}

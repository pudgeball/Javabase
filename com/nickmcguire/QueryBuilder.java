package com.nickmcguire;

public class QueryBuilder
{
	private Command command;
	private String args, from, where, order, values;
	
	public QueryBuilder command(Command command)
	{
		this.command = command;
		return this;
	}
	
	public QueryBuilder args(String args)
	{
		this.args = args;
		return this;
	}
	
	public QueryBuilder from(String from)
	{
		this.from = from;
		return this;
	}
	
	public QueryBuilder where(String where)
	{
		this.where = where;
		return this;
	}
	
	public QueryBuilder order(String order)
	{
		this.order = order;
		return this;
	}
	
	public QueryBuilder values(String values)
	{
		this.values = values;
		return this;
	}
	
	public Query buildQuery()
	{
		return new Query(command, args, from, where, order, values);
	}
}

package com.nickmcguire;

public class QueryBuilder
{
	private Command command;
	private String args, from, where, order, values;
	private boolean isDesc;
	
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
	
	public QueryBuilder order(String order, boolean isDesc)
	{
		this.order = order;
		this.isDesc = isDesc;
		return this;
	}
	
	public QueryBuilder values(String values)
	{
		this.values = values;
		return this;
	}
	
	public Query buildQuery()
	{
		Query query = new Query();
		
		query.setCommand(command);
		query.setArgs(args);
		query.setFrom(from);
		query.setOrder(order, isDesc);
		query.setWhere(where);
		query.setValues(values);
		
		return query;
	}
}

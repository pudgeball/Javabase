package com.nickmcguire;

import java.sql.ResultSet;

public abstract class Database
{	
	public abstract boolean initialize();
	public abstract boolean open();
	
	public abstract boolean isConnected();
	
	public abstract boolean createTable(String query);
	public abstract boolean createRow(String query);
	
	public abstract ResultSet queryTable(String query);
	
	public abstract boolean dropTable(String tablename);
	public abstract boolean dropTable(String tablename, boolean doesExist);
	
	protected Command whichCommand(String query)
	{
		if (query.substring(0, 6).equalsIgnoreCase("SELECT"))
			return Command.SELECT;
		else if (query.substring(0, 6).equalsIgnoreCase("CREATE"))
			return Command.CREATE;
		else if (query.substring(0, 6).equalsIgnoreCase("INSERT"))
			return Command.INSERT;
		else if (query.substring(0, 5).equalsIgnoreCase("ALTER"))
			return Command.ALTER;
		else
			return Command.ERR;
	}
	
}

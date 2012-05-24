package com.nickmcguire;

import java.sql.*;

public class MySQL extends Database
{
	private String driver = "com.mysql.jdbc.Driver";
	
	private String hostname, portnumber, database, user, pass;
	
	private Connection connection;
	
	/**
	 * Creates a MySQL object for interfacing with a MySQL database
	 * @param hostname The host name of the database
	 * @param portnumber The port number of the database
	 * @param database The name of the database (can be blank)
	 * @param user The username for logging in
	 * @param pass The password for logging in
	 */
	public MySQL(String hostname, String portnumber, String database, String user, String pass)
	{
		this.hostname = hostname;
		this.portnumber = portnumber;
		this.database = database;
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * Initializes the driver to connect to the database
	 * @return If the driver initialization was successful
	 */
	@Override
	public boolean initialize()
	{
		try
		{
			Class.forName(driver);
			return true;
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Mysql Driver not found");
		}
		
		return false;
	}
	
	/**
	 * Opens the connection to the database
	 * @return If the connection was successful
	 */
	@Override
	public boolean open()
	{
		if (initialize())
		{
			try
			{
				String url = "jdbc:mysql://"+hostname+":"+portnumber+"/"+database;
				
				connection = DriverManager.getConnection(url, user, pass);
				return true;
			}
			catch (SQLException ex)
			{
				System.out.println("SQL Error: " + ex.getMessage());
			}
		}
		
		return false;
	}
	
	/**
	 * Checks the connection to the database
	 * @return If the connection exists
	 */
	@Override
	public boolean isConnected()
	{
		try
		{
			if (connection != null)
				if (!connection.isClosed())
					return true;
			
		}
		catch(SQLException ex)
		{
			System.out.println("SQL Error: " + ex.getMessage());
		}
		
		return false;
	}
	
	public boolean createTable(Query query)
	{
		return createTable(query.getQuery());
	}
	
	/**
	 * Create a table in the database
	 * @param query The create query
	 * @return If the query was successful
	 */
	@Override
	public boolean createTable(String query)
	{
		if (isConnected())
		{
			try
			{
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				return true;
			}
			catch (SQLException ex)
			{
				System.out.println("A SQL Error Occured: " + ex.getMessage());
			}
		}
		return false;
	}
	
	public boolean createRow(Query query)
	{
		return createRow(query.getQuery());
	}
	
	/**
	 * Create a row in a table
	 * @param query The query to create the row
	 * @return If the query was successful
	 */
	@Override
	public boolean createRow(String query)
	{
		if (isConnected())
		{
			try
			{
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				return true;
			}
			catch(SQLException ex)
			{
				System.out.println("A SQL Error Occured: " + ex.getMessage());
			}
		}
		return false;
	}
	
	/**
	 * Drop a table
	 * @param tableName The name of the table
	 * @return If the query was successful
	 */
	@Override
	public boolean dropTable(String tablename)
	{
		return dropTable(tablename, false);
	}
	
	@Override
	public boolean dropTable(String tablename, boolean doesExist)
	{
		if (isConnected())
		{
			try
			{
				Statement statement = connection.createStatement();
				String beginStatement = (doesExist) ? "DROP TABLE " : "DROP TABLE IF NOT EXISTS "; 
				statement.execute(beginStatement + tablename);
				return true;
			}
			catch (SQLException ex)
			{
				System.out.println("A SQL Error Occured: " + ex.getMessage());
			}
		}
		
		return false;
	}
	
	public ResultSet queryTable(Query query)
	{
		return queryTable(query.getQuery());
	}
	
	/**
	 * Query a table
	 * @param query The query to execute
	 * @return If the query was successful
	 */
	@Override
	public ResultSet queryTable(String query)
	{
		if (isConnected())
		{
			try
			{
				Statement statement = connection.createStatement();
				return statement.executeQuery(query);
			}
			catch (SQLException ex)
			{
				System.out.println("A SQL Error Occured: " + ex.getMessage());
			}
		}
		return null;
	}
}

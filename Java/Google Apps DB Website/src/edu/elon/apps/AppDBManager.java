/**
 * @AppDBManager.java		@Version 1.0 April/2012
 * 
 * Copyright (c) 2012 Thonda Taylor II Productions.
 * 3567 Campus Box, Elon, North Carolina, 38053 USA.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Thonda Taylor II Productions.  All of the work is original 
 * work completed solely by Thonda Taylor II, with no assistance
 * from anyone.
 */ 
package edu.elon.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



/**
 * @author thondaTaylor
 * Creates the Interface layer
 */
public class AppDBManager {

	private static String driver = "org.apache.derby.jdbc.ClientDriver";
	protected String dbName = "//localhost:1527/ElonDB";
	protected String url = "jdbc:derby:" + dbName;
	protected static String tableName = "PHOENIX.ELONAPPS";
	protected static String username = "derbyuser";
	protected static String password = "derbyuser";
    private Properties userInfo;  
    private static DataSource dataSource;
    private static Connection connection;

    /**
     * Constructor that sets the userInfo for the properties of the DB
     */
    public AppDBManager(){
    	userInfo = new Properties();
      	userInfo.put("user", username);
      	userInfo.put("password", password);
    }
    
    /**
     * Creates the connection to the ElonDS datastore
     * @return connection
     * @throws Exception
     */
    protected static Connection getConnection() throws Exception{
    	 Context context = new InitialContext();
		 DataSource dataSource = (DataSource) 
		 context.lookup("java:comp/env/jdbc/ElonDS");
		 Connection connection = dataSource.getConnection("derbyuser", 
				 "derbyuser");
		 return(connection);
    }
    
    /**
	  * method that prints the headers of the table dynamically
	  * @param connection
	  * @param resultSet
	  * @param out
	  * @throws SQLException
     * @throws IOException 
	  */
	 protected void printTableTop(Connection connection, ResultSet resultSet,
			 PrintWriter out) throws SQLException, IOException {
   	 out.println("<table border='1'>");
   	 String[] headings = {"App Code", "Developer", "Title", "Catagory", 
   			 "Price"};
   	 out.print("<tr>");
   	 for(String headingName : headings){
   		 out.print("<th>"+headingName);
   	 }
   	 out.println();
    }
	 
	 /**
	  * method that prints the body of the table dynamically
	  * @param resultSet
	  * @param out
	  * @throws SQLException
	  */
	 protected void printTableBody(ResultSet resultSet, PrintWriter out)
	 throws SQLException {
		 Connection connect;
		 try {
			connect = AppDBManager.getConnection();
			 while ( resultSet.next()){
	    		 out.println("<tr>");
	    		 out.print(" <td>"+resultSet.getInt(1)+"</td>");
	    		 out.print(" <td>"+resultSet.getString(2)+"</td>");
	    		 out.print(" <td>"+resultSet.getString(3)+"</td>");
	    		 out.print(" <td>"+resultSet.getString(4)+"</td>");
	    		 out.print(" <td>"+resultSet.getString(5)+"</td>");
	    	 }
	    	 out.println("</table>");
	    	 connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
     } 
	 
	 /**
		 * showTable method gets the connection runs a query to get every 
		 * element from the ElonDS datastore catches an exception if needed
		 * @param out
		 */
		public void showTable(PrintWriter out){
	   	 try{
	   		 Connection connection = AppDBManager.getConnection();
	   		 Statement statement = connection.createStatement();
	   		 String quuery = "SELECT * FROM "+tableName;
	   		 ResultSet resultSet = statement.executeQuery(quuery);
	   		 printTableTop(connection, resultSet, out);
	   		 printTableBody(resultSet, out);
	   		 connection.close();
	   	 }catch(Exception e){
	   		 System.err.println("Error: " + e);
	   	 }
	    }
    /**
     * Inserts data into the table
     * @param aApp
     * @throws Exception
     */
	public void insertApp(App aApp) throws Exception{
		Connection c = getConnection();
		
		String template = String.format("INSERT INTO %s (appCode, "
				+ "developersName, appTitle, appCatagory, dateUpdated, " 
				+ "currentVersion, price, "  
				+ "rating, appDescription) VALUES('" +aApp.getAppCode()+ "'," 
				+ "'"+aApp.getDevelopersName()+"'," +"'"+aApp.getAppTitle()+"',"
				+ "'"+aApp.getAppCatagory()+"'," 
				+ "'"+aApp.getDateUpdated()+ "'," 
				+ "'"+aApp.getCurrentVersion()+"',"
				+ "'"+aApp.getPrice()+"'," + "'"+aApp.getRating()+"',"
				+ "'"+aApp.getAppDescription()+"')",
				tableName);
		Statement statement = c.createStatement();
		statement.executeUpdate(template);
		statement.close();
	    c.close();
	}
	/**
	 * Deletes specified items from the table
	 * @param appCode
	 * @throws Exception
	 */
	public static void deleteApp(String appCode) throws Exception{
		Connection c = getConnection();
		Statement statement = c.createStatement();
		String codeValue = appCode;
		String delete = ("DELETE FROM "+tableName+" WHERE appCode = " 
			+	"'"+codeValue+"'");
		statement.executeUpdate(delete);
		statement.close();
		c.close();
	}
	/**
	 * Removes all apps fromt the DB table
	 * @throws Exception
	 */
	public static void clearAllApps() throws Exception{
		Connection c = getConnection();
		Statement statement = c.createStatement();
		String clearAll = ("DELETE FROM "+tableName);
		statement.executeUpdate(clearAll);
		statement.close();
		c.close();
	}
	/**
	 * Retrieves all the apps from the DB table
	 * @throws Exception
	 */
	public ArrayList<App> getAllApps() throws Exception{
		ArrayList<App> appList = new ArrayList<App>(); 
		Connection c = getConnection();
		Statement statement = c.createStatement();
		String getAllApps = ("SELECT * FROM "+tableName);
		ResultSet resultset = statement.executeQuery(getAllApps);
		while(resultset.next()){
			String appCode = resultset.getString("appCode");
			String developersName = resultset.getString("developersName");
			String appTitle = resultset.getString("appTitle");
			String appCatagory = resultset.getString("appCatagory");
			String dateUpdated = resultset.getString("dateUpdated");
			String currentVersion = resultset.getString("currentVersion");
			String price = resultset.getString("price");
			String rating = resultset.getString("rating");
			String appDescription = resultset.getString("appDescription");
			App oneToAdd = new App(appCode, developersName, 
					appTitle, appCatagory, dateUpdated, currentVersion, 
					price, rating, appDescription);
			appList.add(oneToAdd);
		}
		statement.close();
		c.close();
		return appList;  
	}
	   
	/**
	 * Finds a certain app within the Database
	 * @param appCode
	 * @throws Exception
	 */
    public static ArrayList<App> findApp(String appCode) throws Exception{
    	ArrayList<App> appList = new ArrayList<App>(); 
    	Connection c = getConnection();
		Statement statement = c.createStatement();
		String codeValue = appCode;
		String findApp = ("SELECT * FROM "+tableName+" WHERE appCode = " 
			+	"'"+codeValue+"'");
		ResultSet resultset = statement.executeQuery(findApp);
		while(resultset.next()){
			String appCode1 = resultset.getString("appCode");
			String developersName = resultset.getString("developersName");
			String appTitle = resultset.getString("appTitle");
			String appCatagory = resultset.getString("appCatagory");
			String dateUpdated = resultset.getString("dateUpdated");
			String currentVersion = resultset.getString("currentVersion");
			String price = resultset.getString("price");
			String rating = resultset.getString("rating");
			String appDescription = resultset.getString("appDescription");
			App oneToAdd = new App(appCode1, developersName, 
					appTitle, appCatagory, dateUpdated, currentVersion, 
					price, rating, appDescription);
			appList.add(oneToAdd);
		}
		statement.close();
		c.close();
		return appList; 
	}
    
    /**
     * Updates an app
     * @param aApp
     * @throws Exception
     */
    public void updateApp(App aApp) throws Exception{
    	 Connection c = getConnection();
		 String update = "UPDATE "+tableName+ " SET appCode ='"  
		 + aApp.getAppCode() + "', developersName='" + aApp.getDevelopersName()
		 + "', appTitle='" + aApp.getAppTitle() + "', appCatagory='"
		 + aApp.getAppCatagory() + "', dateUpdated ='"
		 + aApp.getDateUpdated() + "', currentVersion='"
		 + aApp.getCurrentVersion() + "', price='" + aApp.getPrice()
		 + "', rating='" + aApp.getRating() + "', appDescription='" 
		 + aApp.getAppDescription() + "' " +
		 		"WHERE appCode='" +aApp.getAppCode()+"'";
		 Statement statement = c.createStatement();
		 statement.executeUpdate(update);
		 statement.close();
		 c.close();
	}
    
    /**
     * Tests to see if the table has been created or not
     * @return true if table is created
     */
    public boolean isAppTableCreated(){
		return true;
	}
    
    public int getRocordsInDB() throws Exception{
    	int recordNumber = 0;
    	String getRecords = "SELECT count(*) FROM "+tableName;
    	Connection c = getConnection();
    	Statement statement = c.createStatement();
    	ResultSet resultset = statement.executeQuery(getRecords);
    	while(resultset.next()){
    		recordNumber = resultset.getInt(1);
    	}
    	resultset.close();
    	c.close();
    	return recordNumber;
    }
}

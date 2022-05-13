package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.dbconnect;

public class Device {
  
	
	//database connection object
	dbconnect dbCon = new dbconnect();
	
	//insert a device
	public String insertDevice(String name, String power, String hours, String devices) {
		
		String output ="";
		
		//check database connection
		
		try {
			  Connection con =  dbCon.connect();
			 if (con == null) 
			 { 
			     return "Error while connecting to the database"; 
			 } 
			 
			 //prepared 
			 
			 String query = "insert into devicestable(`deviceID`,`device`,`powerUsage`,`hours`,`noOfdevices`,`DailypowerConsumption`,`MonthlyPowerConsumption`)values(?,?,?,?,?,(powerUsage*hours*noOfdevices),((DailypowerConsumption*30)/1000))";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setInt(1, 0); 
			 preparedStmt.setString(2, name); 
			 preparedStmt.setDouble(3, Double.parseDouble(power)); 
			 preparedStmt.setInt(4, Integer.parseInt(hours)); 
			 preparedStmt.setInt(5,Integer.parseInt(devices));
			 
			 //execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 output = "Inserted successfully"; 
			 
		}catch(Exception e) {
			output = "Error while inserting"; 
			 System.err.println(e.getMessage()); 
		}
		
	   return output;
		
	}

	//read devices
	
	public String readDevices() {
		
		String output ="";
		
		//connect to the database
		try
		{ 
			 Connection con =  dbCon.connect();
		  if (con == null) 
		   { 
		      return "Error while connecting to the database for reading."; 
		   }
		  
		//prepare html table to display data
		  output = "<table border='1'>" 
				  + "<tr><th>Device Name</th><th>Power Usage(Watt)</th>"
				  + "<th>Used Hours</th><th>No of Devices</th><th>Daily Power Consumption(Watt)</th><th>MonthlyPowerConsumption(kWh)</th><th>Update</th><th>Remove</th></tr>";

		  
		  String query = "select * from devicestable";
		  Statement stmt = con.createStatement();
		  ResultSet rs = stmt.executeQuery(query);
		  
		  //iterate through the rows in the result set
		  while(rs.next()) {
			  String deviceID = Integer.toString(rs.getInt("deviceID"));
			  String device = rs.getString("device");
			  String powerUsage = Double.toString(rs.getDouble("powerUsage"));
			  String hours = Integer.toString(rs.getInt("hours"));
			  String noOfdevices = Integer.toString(rs.getInt("noOfdevices"));
			  String DailypowerConsumption = Double.toString(rs.getDouble("DailypowerConsumption"));
			  String MonthlyPowerConsumption = Double.toString(rs.getDouble("MonthlyPowerConsumption"));
			  
			  
			  //add a row into html table
			  output += "<tr><td><input id='hidDeviceIDUpdate' name='hidDeviceIDUpdate'  type='hidden' value='" + deviceID + "'>"
							  + device + "</td>";
			  output += "<td>" +powerUsage+ "</td>";
			  output += "<td>" +hours+ "</td>";
			  output += "<td>" +noOfdevices+ "</td>";
			  output += "<td>" +DailypowerConsumption+ "</td>";
			  output += "<td>" +MonthlyPowerConsumption+ "</td>";
			  
			  //buttons
			  output += "<td><input name='btnUpdate'"
			  		+ "type='button' value='Update' class=' btnUpdate btn btn-secondary'></td>"
			  		+ "<td><form method='post' action='index.jsp'>"
			  		+ "<input name='btnRemove'"
			  		+ "type='submit' value='Remove'  class='btn btn-danger'>"
			  		+ "<input name='hiddeviceIDdelete' type='hidden'"
			  		+ "value='"+deviceID+"'>" + "</form></td></tr>";
			  
			  }
		  con.close();
		  //complete the html table
		  output += "</table>";
		  
		}catch (Exception e) 
		{ 
		    output = "Error while reading the items."; 
		    System.err.println(e.getMessage()); 
		}

		
	    return output;
	}
	
	//delete
	public String deleteDevice(String deviceID) {
		
		String output ="";
		
		//connect to the database
		try {
			Connection con = dbCon.connect(); 
			if (con == null) { 
			 return "Error while connecting to the database for deleting."; 
			 }
			
			//create a prepared statement
			String query = "delete from devicestable where deviceID=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1, Integer.parseInt(deviceID));
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output ="Deleted Successfully";
			
			}catch(Exception e) {
			    output = "Error while deleting the item."; 
			    System.err.println(e.getMessage());
		     }
		
		
		return output;
	}


	//update
	public String UpdateDevice(String dID,String dName, String dpowerUsage,String hrs, String nodevices) {
		String output = "";
		
		try {
			Connection con = dbCon.connect();
			if(con == null) {
				return "Error while connecting to the database for updating";
			  }
			
			//create prepared statement
			String query = "UPDATE devicestable set device=?,powerUsage=?,hours=?,noOfdevices=? ,DailypowerConsumption = (powerUsage*hours*noOfdevices), MonthlyPowerConsumption = ((DailypowerConsumption*30)/1000) where deviceID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			
			preparedStmt.setString(1,dName);
			preparedStmt.setDouble(2,Double.parseDouble(dpowerUsage));
			preparedStmt.setInt(3,Integer.parseInt(hrs));
			preparedStmt.setInt(4, Integer.parseInt(nodevices));
			preparedStmt.setInt(5, Integer.parseInt(dID));
			
			
			//execute the statement
			
			preparedStmt.execute();
			con.close();
			output ="Updated successfully";
			
		}catch(Exception e) {
			output = "Error while updating the item."; 
			System.err.println(e.getMessage());
			
		}
		
	   return output;
    	
    }

    
       
	

}


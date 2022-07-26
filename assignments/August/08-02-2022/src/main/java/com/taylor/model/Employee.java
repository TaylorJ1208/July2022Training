package com.taylor.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int id;
	private String empFirstName;
	private String empLastName;
	private String empUsername;
	private String empPassword;
	private String empAddress;
	private String empContact;
	private boolean isAdmin;
	private SQLConnection conn;
	
	public boolean validateUserNamePwd() throws SQLException, ClassNotFoundException {		
		PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM employee WHERE username=? AND password=?;");
		statement.setString(1, empUsername);
		statement.setString(2, empPassword);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return true;
		}
		else
		{
			return false;
		}
		
	
	}
	
	public void insertEmployee() throws SQLException {
		PreparedStatement statement = conn.getConnection().prepareStatement("INSERT INTO employee VALUES(id, ?, ?, ?, ?, ?, ?, ?);");
		statement.setString(1, empFirstName);
		statement.setString(2, empLastName);
		statement.setString(3, empUsername);
		statement.setString(4, empPassword);
		statement.setString(5, empAddress);
		statement.setString(6, empContact);
		statement.setBoolean(7, isAdmin);
		statement.execute();
		System.out.println("User inserted successfully.");
	}
	
	public void updateEmployee() throws SQLException {
		PreparedStatement statement = conn.getConnection().prepareStatement("UPDATE employee SET firstName=?,"
				+ "lastName=?, username=?, password=?, address=?, contact=?"
				+ ", isAdmin=? WHERE id=?;");
		statement.setString(1, empFirstName);
		statement.setString(2, empLastName);
		statement.setString(3, empUsername);
		statement.setString(4, empPassword);
		statement.setString(5, empAddress);
		statement.setString(6, empContact);
		statement.setBoolean(7, isAdmin);
		statement.setInt(8, id);
		statement.execute();
		System.out.println("User updated successfully.");
	}
	
	public void deleteEmployee() throws SQLException {
		PreparedStatement statement = conn.getConnection().prepareStatement("DELETE FROM employee WHERE id=?;");
		statement.setInt(1, id);
		statement.execute();
		System.out.println("User deleted successfully.");
	}
	
	public ResultSet listEmployee() throws SQLException {
		Statement statement = conn.getConnection().createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM employee");
		return result;
		}
	}

class SQLConnection {
	private static Connection conn = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd",
					"root", "WakeID12!!");
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
}
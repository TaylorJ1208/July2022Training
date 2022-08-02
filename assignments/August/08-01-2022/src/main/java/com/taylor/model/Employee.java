package com.taylor.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends SQLConnection {
	private int id;
	private String empName;
	private String empUsername;
	private String empPassword;
	
	public Employee() throws SQLException, ClassNotFoundException {
		super();
	}
	
	public Employee(int id, String empName, String empUsername, String empPassword) throws SQLException, ClassNotFoundException {
		super();
		this.id = id;
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	public boolean validateUserNamePwd() throws SQLException, ClassNotFoundException {		
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM emp WHERE empUsername=? AND empPassword=?;");
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
		PreparedStatement statement = conn.prepareStatement("INSERT INTO emp VALUES(id, ?, ?, ?);");
		statement.setString(1, empName);
		statement.setString(2, empUsername);
		statement.setString(3, empPassword);
		statement.execute();
		System.out.println("User inserted successfully.");
	}
	
	public void updateEmployee() throws SQLException {
		PreparedStatement statement = conn.prepareStatement("UPDATE emp SET empName=? WHERE id=?;");
		statement.setString(1, empName);
		statement.setInt(2, id);
		statement.execute();
		System.out.println("User updated successfully.");
	}
	
	public void deleteEmployee() throws SQLException {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM emp WHERE id=?;");
		statement.setInt(1, id);
		statement.execute();
		System.out.println("User deleted successfully.");
	}
	
	public ResultSet listEmployee() throws SQLException {
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM emp");
		return result;
		}
	}


class SQLConnection {
	private static SQLConnection sqlConnection;
	public Connection conn;
	
	protected SQLConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd",
				"root", "WakeID12!!");
	}
	
	public static SQLConnection getInstance() throws SQLException, ClassNotFoundException {
		if (sqlConnection == null) {
			try {
				sqlConnection = new SQLConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlConnection;
	}
	
}
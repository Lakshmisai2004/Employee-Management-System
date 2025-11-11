package com.employeeManagementSystem;

import com.employeeManagementSystem.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeDAO {
	
	
		private static final String URL="jdbc:mysql://localhost:3306/may5";
		 private static final String USER="root";
		private static final String PASSWORD="Lakshmi2004@";
		 
		 //create
		 public void addEmployee() {
			 Scanner sc=new Scanner(System.in);
			 System.out.println("Enter name:");
			 String name=sc.nextLine();
			 System.out.println("Enter department:");
			 String dept=sc.nextLine();
			 System.out.println("Enter salary:");
			 double sal=sc.nextDouble();
			 
			 
		String query="INSERT INTO employees(name,department,salary)VALUES(?,?,?)";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query)){
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setDouble(3, sal);
			ps.executeUpdate();
			System.out.println("Employee added successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		 } 	 			
		  	 
		//Read
		public void viewEmployees() {
			String query="SELECT * FROM employees";
			try(Connection con=DBConnection.getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query)){
				System.out.println("\n---Employee List---");
				System.out.printf("%-5s %-15s %-15s %10s%n","ID","Name","Department","Salary");
				System.out.println("------------------------------------------------------------------------");
				while(rs.next()) {
					System.out.printf("%-5s %-15s %-15s %10s%n",
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("department"),
							rs.getDouble("salary"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
					
		}
		
		
		//update
		public void updateEmployee() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter employee ID to update:");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter new name:");
			String name=sc.nextLine();
			System.out.println("Enter new department");
			String dept=sc.nextLine();
			System.out.println("Enter new salary:");
			double sal=sc.nextDouble();
			
			String sql="UPDATE employees SET name=?,department=?,salary=? WHERE id=?";
			
			try(Connection con=DBConnection.getConnection();
					PreparedStatement ps=con.prepareStatement(sql)){
				ps.setString(1, name);
				ps.setString(2, dept);
				ps.setDouble(3,sal);
				ps.setInt(4, id);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Employee updated successfully");
		}
		else {
			System.out.println("No Employee found with that ID");
		}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		//Delete
		public void deleteEmployee() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter employee ID to delete:");
			int id=sc.nextInt();
			String sql="DELETE FROM employees where id=?";
			try(Connection con=DBConnection.getConnection();
					PreparedStatement ps=con.prepareStatement(sql)){
				     ps.setInt(1, id);
				     int rows=ps.executeUpdate();
				     if(rows>0) {
				    	 System.out.println("Employee deleted successfully");
				     }
				     else {
				    	 System.out.println("No employee found with that ID");
				     }
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
package com.employeeManagementSystem;

import java.util.Scanner;

import com.employeeManagementSystem.*;

public class Main {

	public static void main(String[] args) {
		
		
		EmployeeDAO dao=new EmployeeDAO();
		Scanner sc=new Scanner(System.in);
		   int choice;
		   do {
			   System.out.println("\n===Employee Management System===");
			   System.out.println("1.Add Employee");
			   System.out.println("2.View All Employees");
			   System.out.println("3.Update Employee");
			   System.out.println("4.Delete Employee");
               System.out.println("5.Exit");
               System.out.println("Enter your choice:");
               choice=sc.nextInt();
               
               switch(choice) {
              case 1:
            	  dao.addEmployee();
            	  break;
              case 2:
            	  dao.viewEmployees();
            	  break;
              case 3:
            	  dao.updateEmployee();
            	  break;
              case 4:
            	  dao.deleteEmployee();
            	  break;
              case 5:
            	  System.out.println("Exit");
            	  break;
             default:
            	 System.out.println("Invalid choice, try again");
            	  
            	   
               }
		   
		   }while(choice!=5);
		   sc.close();
		

	}

}

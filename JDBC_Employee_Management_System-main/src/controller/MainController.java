package controller;

import java.util.Scanner;

import dao.EmployeeDao;
import model.EmployeeModel;
import service.EmployeeDetails;

public class MainController {

	public static void main(String[] args) throws ClassNotFoundException {
		EmployeeDetails ed = new EmployeeDetails();
		EmployeeDao empDao = new EmployeeDao();
		System.out.println("Are you an Admin or Employee. Type your option below");
		boolean temp = true;
		while(temp) {
			System.out.println("1) Admin \n2) Employee\n3) Exit");
			Scanner sc = new Scanner(System.in);
			int option = Integer.parseInt(sc.nextLine());
			switch(option) {
				case 1: {
					System.out.println("Enter your username");
					String adminName = sc.nextLine();
					System.out.println("Enter your password");
					String adminPwd = sc.nextLine();
					if(adminName.equals("Admin123") && adminPwd.equals("Admin@123$")) {
						boolean temp1 = true;
						while(temp1) {
							System.out.println("Choose any one of an operation that you wish to do");
							System.out.println("1) Add New Employee\n2) View Employee Details\n3) Update Existing Employee Details\n4) Delete Existing Employee\n5) Exit");
							boolean flag1 = true;
							int adminOption = 0;
							while(flag1) {
								try {
									adminOption = Integer.parseInt(sc.nextLine());
									flag1 = false;
								}catch(Exception e) {
									System.out.println("Input given type is wrong. Give the right option in number type");
									flag1 =true;
								}
							}
							
							switch(adminOption) {
								case 1:{
									System.out.println("How many employee details that you need to add");
									int empCount = Integer.parseInt(sc.nextLine());
									int empId;
									String empName;
									String empDesignation;
									int empExperience;
									double empSalary;
									for(int i=0; i<empCount; i++) {
										empId = Integer.parseInt(sc.nextLine());
										empName = sc.nextLine();
										empDesignation = sc.nextLine();
										empExperience = Integer.parseInt(sc.nextLine());
										empSalary = Double.parseDouble(sc.nextLine());
										EmployeeModel em = new EmployeeModel(empId,empName,empDesignation,empExperience,empSalary);
										ed.addEmployeeToList(em);
									}
									break;
								}
								case 2:{
									empDao.viewEmployeeTableRecord();
									break;
								}
								case 3:{
									System.out.println("Enter Employee Id");
									int empId = Integer.parseInt(sc.nextLine());
									System.out.println("Select any one of the detail to get updated.\n1) EmployeeName\n2) Employee Designation\n3) EmployeeExperience\n4) EmployeeSalary");
									int updateOption = Integer.parseInt(sc.nextLine());
									switch(updateOption) {
									case 1:{
										System.out.println("Enter the new employee name who has an id as "+empId);
										String newEmpName = sc.nextLine();
										empDao.updateEmployeeRecord(updateOption,empId,newEmpName);
										break;
									}
									case 2:{
										System.out.println("Enter the employee's new designation who has an id as "+empId);
										String newEmpDesignation = sc.nextLine();
										empDao.updateEmployeeRecord(updateOption,empId,newEmpDesignation);
										break;
									}
									case 3:{
										System.out.println("Enter the employee's new experience who has an id as "+empId);
										int newEmpExp = Integer.parseInt(sc.nextLine());
										empDao.updateEmployeeRecord(empId,newEmpExp);
										break;
									}
									case 4:{
										System.out.println("Enter the employee's new Salary who has an id as "+empId);
										double newEmpSalary = Double.parseDouble(sc.nextLine());
										empDao.updateEmployeeRecord(empId,newEmpSalary);
										break;
									}
									}
									break;
								}
								case 5:{
									temp1 = false;
									break;
								}
							}
						}
						
					}
					else {
						System.out.println("Incorrect username/password");
					}
					break;
				}
				case 2:{
				}
				case 3:{
					temp = false;
				}
			}
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.EmployeeModel;
import utility.ConnectionManager;

public class EmployeeDao extends GetConnection{

	Connection dbConn = null;
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}

	public void storeEmpRecordInDb(ArrayList<EmployeeModel> empList) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "insert into employee(id,ename,designation,experience,salary) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			for(EmployeeModel em: empList) {
				ps.setInt(1, em.getEmployeeId());
				ps.setString(2, em.getEmployeeName());
				ps.setString(3, em.getEmployeeDesignation());
				ps.setInt(4, em.getEmployeeExperience());
				ps.setDouble(5, em.getEmployeeSalary());
				int result = ps.executeUpdate();
				if(result == 1) {
					System.out.println("Employee record added successfully");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewEmployeeTableRecord() throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "Select * from employee";
		try {
			Statement stmt = dbConn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateEmployeeRecord(int option, int empId, String newEmpDetail) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = null;
		if(option == 1) {
			sql = "update employee set ename = ? where id = ?";	
		}
		else if(option == 2) {
			sql = "update employee set designation = ? where id = ?";	
		}
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setString(1, newEmpDetail);
			ps.setInt(2, empId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateEmployeeRecord(int empId, int newEmpExp) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "update employee set experience = ? where id = ?";	
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setInt(1, newEmpExp);
			ps.setInt(2, empId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateEmployeeRecord(int empId, double newEmpSalary) throws ClassNotFoundException {
		dbConn = getDbConnection();
		String sql = "update employee set salary = ? where id = ?";	
		
		try {
			PreparedStatement ps = dbConn.prepareStatement(sql);
			ps.setDouble(1, newEmpSalary);
			ps.setInt(2, empId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

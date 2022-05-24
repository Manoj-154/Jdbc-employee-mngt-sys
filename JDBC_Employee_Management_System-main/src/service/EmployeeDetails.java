package service;

import java.util.ArrayList;

import dao.EmployeeDao;
import model.EmployeeModel;

public class EmployeeDetails implements AbcDetails{
	EmployeeDao empDao = new EmployeeDao();
	ArrayList<EmployeeModel> empList = new ArrayList<EmployeeModel>();
	public void addEmployeeToList(EmployeeModel em) throws ClassNotFoundException {
		empList.add(em);
		empDao.storeEmpRecordInDb(empList);
	}

}

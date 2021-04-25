package basic;



import java.util.List;

import basic.dao.EmpDaoImpl;
import basic.dao.EmployeeDao;
import basic.model.Employee;

public class TestJdbc {
	public static void main(String[] args) {
		//Employee emp = new Employee(3, "Soundarya", 147852, "Andhra Pradesh");
		//Employee emp1 = new Employee(4, "Apoorva", 369852, "Karnataka");
		EmployeeDao employeeDao = new EmpDaoImpl();
		//employeeDao.insert(emp);
		//employeeDao.delete("Madhu");
		// to read from database
		List<Employee> employees = employeeDao.getAllEmployee();
		printEmp(employees);
		
		employeeDao.findEmployeeByState("Karnataka");
	
		
	}

	private static void printEmp(List<Employee> employees) {
		for(Employee e : employees) {
			System.out.println(e);
		}
		
	}

}
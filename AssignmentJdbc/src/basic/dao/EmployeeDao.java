package basic.dao;

import java.util.List;

import basic.model.Employee;

public interface EmployeeDao {
	public void insert(Employee employee);

	public void delete(String name);
	List<Employee> getAllEmployee();

	Employee findEmployeeByState(String emp_state);

}

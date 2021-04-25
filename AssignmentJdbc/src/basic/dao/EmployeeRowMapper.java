package basic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import basic.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int emp_id = rs.getInt("emp_id");
		String name = rs.getString("name");
		int emp_phn = rs.getInt("emp_phn");
		String emp_state = rs.getString("emp_state");
		//Employee newEmployee = new Employee(emp_id, name, emp_phn, emp_state);
		Employee newEmployee = new Employee( emp_state);
		return newEmployee;
		
	}

}

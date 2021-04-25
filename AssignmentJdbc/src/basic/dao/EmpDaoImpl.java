package basic.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import basic.model.Employee;


@Repository("EmployeeDao")
public class EmpDaoImpl implements EmployeeDao {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	
	
	
	//to insert a record
	@Override
	public void insert(Employee employee) {
		String sql = "INSERT INTO employee VALUES (?,?,?,?)";
		Object[] objects = {employee.getEmp_id(),employee.getName(),employee.getEmp_phn(),employee.getEmp_state()};
		int no_rows_inserted = jdbcTemplate.update(sql,objects);
		System.out.println("no of rows inserted is " +no_rows_inserted );
	}
	
	
	//to delete a record by name
	@Override
	public void delete(String name) {
		String delSql = "DELETE FROM EMPLOYEE WHERE name = ?";
		int noRecordDeleted = jdbcTemplate.update(delSql,name);
		System.out.println("no of record deleted = " +noRecordDeleted);
	}
	
	
	//to read from record
	@Override
	public List<Employee> getAllEmployee() {
		String sql = "SELECT * FROM employee";
		List<Employee> employees = jdbcTemplate.query(sql, new EmployeeRowMapper());
		return employees;
	
	}
	
	
	@Override
	public Employee findEmployeeByState(String emp_state) {
		String sql = "SELECT * FROM employee WHERE emp_state = ?";
		Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class),emp_state);
		return employee;
	}
	

	
	
	
	
	public DataSource getDataSource() {
		String url = "jdbc:mysql://127.0.0.1:3306/spring_jdbc";
		String username = "root";
		String password ="";

		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		return dataSource;
	}


	



	

}

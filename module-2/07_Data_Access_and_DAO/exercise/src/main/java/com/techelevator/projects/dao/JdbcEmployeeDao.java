package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		Date birth_date = rowSet.getDate("birth_date");
		if (birth_date != null) {
			employee.setBirthDate(birth_date.toLocalDate());
		}
		Date hire_date = rowSet.getDate("hire_date");
		if (hire_date != null) {
			employee.setHireDate(hire_date.toLocalDate());
		}
		return employee;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> matchedEmployees = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE first_name ILIKE ?  AND last_name ILIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			matchedEmployees.add(employee);
		}
		return matchedEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> matchedEmployees = new ArrayList<>();
//		String sql = "SELECT employee_id FROM project_employee WHERE project_id = ?;";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
//		while (results.next()) {
//			Employee employee = mapRowToEmployee(results);
//			sql = "SELECT * FROM employee WHERE employee_id = ?;";
//			SqlRowSet result = jdbcTemplate.queryForRowSet(sql, employee.getId());
//			if (result.next()) {
//				employee = mapRowToEmployee(result);
//				matchedEmployees.add(employee);
//			}
//		}
		String sql = "SELECT * FROM EMPLOYEE WHERE employee_id IN (SELECT employee_id FROM project_employee WHERE project_id = ?);";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			matchedEmployees.add(employee);
		}
		return matchedEmployees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?,?);";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> matchedEmployees = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE employee_id NOT IN (SELECT employee_id FROM project_employee);";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			matchedEmployees.add(employee);
		}
		return matchedEmployees;
	}
}

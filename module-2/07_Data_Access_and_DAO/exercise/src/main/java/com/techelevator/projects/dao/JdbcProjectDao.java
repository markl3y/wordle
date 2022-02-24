package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT * FROM project WHERE project_id = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, projectId);
		if (result.next()) {
			project = mapRowToProject(result);
		}
		return project;
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		Date from_date = rowSet.getDate("from_date");
		if (from_date != null) {
			project.setFromDate(from_date.toLocalDate());
		}
		Date to_date = rowSet.getDate("to_date");
		if (to_date != null) {
			project.setToDate(to_date.toLocalDate());
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT * FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()){
			Project project = mapRowToProject(results);
			projects.add(project);
		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?) RETURNING project_id;";
		Long newId = jdbcTemplate.queryForObject(sql, Long.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate()); // Question, why do we do Long.class or Integer.class etc.?
		Project project = getProject(newId);
		return project;
	}

	@Override
	public void deleteProject(Long projectId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ?; DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId, projectId);
	}
}

package com.javatpoint.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.javatpoint.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertUsers(List<User> users) {
		for (User user : users) {
			System.out.println(
					"Inserting data for user : " + user.getName() + " " + user.getDept() + " " + user.getSalary());
			jdbcTemplate.update("insert into user(name,dept,salary) values(?, ?, ?)", PreparedStatement -> {
				PreparedStatement.setString(1, user.getName());
				PreparedStatement.setString(2, user.getDept());
				PreparedStatement.setLong(3, user.getSalary());
			});
		}
	}

	public List<User> getAllUsers() {
		List<User> userList = jdbcTemplate.query("select name,dept,salary from user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getString("name"), rs.getString("dept"), rs.getLong("salary"));
			}
		});
		return userList;
	}// end of the method

	public List<User> getAllUsersLambda() {

		List<User> userList = jdbcTemplate.query("select name,dept,salary from user", (ResultSet rs,
				int rowNum) -> new User(rs.getString("name"), rs.getString("dept"), rs.getLong("salary")));
		return userList;
	}// end of the method

}

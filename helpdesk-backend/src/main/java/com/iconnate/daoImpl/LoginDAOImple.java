package com.iconnate.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iconnate.dao.LoginDAO;
import com.iconnate.dto.UserDto;

import sql.Sql;

/**
 * @author samarpit
 *
 */
@Repository
public class LoginDAOImple implements LoginDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserDto userDto;

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	// This method will execute select query with where clause.
	// give corresponding user details in list of UserDto which is present in the
	// users table
	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<UserDto> getUserDetailsByUsernameWithPassword(String username, String password) {

		return jdbcTemplate.query(String.format(Sql.Login.LOGIN_QUERY, username, password), new RowMapper<UserDto>() {
			@Override
			public UserDto mapRow(ResultSet rs, int rowNumber) throws SQLException {
				userDto.setName(rs.getString("user_name"));
				userDto.setAvatar(rs.getString("user_name"));
				userDto.setCompanyId(rs.getLong("company_id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRoleId(rs.getLong("role_id"));
				userDto.setUserId(rs.getLong("user_id"));

				return userDto;
			}
		});
	}
}
package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * User情報を登録するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setZipcode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};
	
	/**
	 * User情報をDBに登録する.
	 * 
	 * @param user
	 */
	public void insert(User user) {
		String sql = "insert into users(name, email, password, zipcode, address, telephone) values(:name, :email, :password, :zipcode, :address, :telephone)";
		//:nameや:emailの部分に情報を挿入
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.queryForObject(sql, param, USER_ROW_MAPPER);
	}
}

package com.example.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Topping;

/**
 * トッピングを操作するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class ToppingRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * Toppingオブジェクトを生成するローマッパー.
	 */
	public static final RowMapper<Topping> TOPPING_ROW_MAPPER = (rs, i) -> {
		Topping topping = new Topping();
		topping.setId(rs.getInt("id"));
		topping.setName(rs.getString("name"));
		topping.setPriceM(rs.getInt("price_m"));
		topping.setPriceL(rs.getInt("price_l"));

		return topping;
	};
	
	/**
	 * トッピングを全件表示する.
	 * 
	 * @return トッピング全件
	 */
	public List<Topping> findAll(){
		String sql = "SELECT id,name,price_m,price_l FROM toppings ORDER BY id ;";
		SqlParameterSource param = new MapSqlParameterSource();
		return template.query(sql, param, TOPPING_ROW_MAPPER);
	}
}

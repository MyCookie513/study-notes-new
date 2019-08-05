package com.jason.JDBCTemplate.DBCP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jason.JDBCTemplate.Domain.User;

public class UserDao extends JdbcDaoSupport{

	
	
	public void Update(User user) {
		String sql="update t_user set t_username=?,t_password=? where idt_user=?;";
		Object[] args= {user.getT_username(),user.getT_password(),user.getIdt_user()};
		this.getJdbcTemplate().update(sql, args);
		
	}
	public List<User>  findall() {
		return this.getJdbcTemplate().query("select * from t_user", new BeanPropertyRowMapper<User>(User.class));
		
	}
	
	public User getbyid(int id) {
		return this.getJdbcTemplate().queryForObject("select * from t_user where idt_user=?", new BeanPropertyRowMapper<User>(User.class),id);

	}
	
}

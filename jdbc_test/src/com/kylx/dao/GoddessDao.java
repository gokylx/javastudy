package com.kylx.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kylx.db.DBUtil;
import com.kylx.model.Goddess;

public class GoddessDao {
	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "" +
				"insert into imooc_goddess" +
				"(user_name, sex, age, birthday, email, mobile," +
				"create_user, create_date, update_user, update_date, isdel)" +
				"values(" + 
				"?,?,?,?,?,?,?,current_date(),?, current_date(),?)";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		
		prepareStatement.setString(1, g.getUser_name());
		prepareStatement.setInt(2, g.getSex());
		prepareStatement.setInt(3, g.getAge());
		prepareStatement.setDate(4,  new Date(g.getBirthday().getTime()));
		prepareStatement.setString(5,  g.getEmail());
		prepareStatement.setString(6, g.getMobile());
		prepareStatement.setString(7, g.getCreate_user());
		prepareStatement.setString(8, g.getUpdate_user());
		prepareStatement.setLong(9, g.getIsdel());
		
		
		prepareStatement.execute();
	}
	public void  updateGoddess() {
	}
	public void delGoddess() {
		
	}
	public List<Goddess> query() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");
		
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while(rs.next()) {
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			
			gs.add(g);
			
		}
		return gs;
	}
	public Goddess get() {
		return null;
	}
	
}

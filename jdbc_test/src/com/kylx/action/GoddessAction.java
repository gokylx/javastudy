package com.kylx.action;

import java.util.Date;


import com.kylx.dao.GoddessDao;
import com.kylx.model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception {
		GoddessDao g = new GoddessDao();
		
		Goddess g1 = new Goddess();
		
		g1.setUser_name("lucy");
		g1.setAge(22);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("lucy@imooc.com");
		g1.setMobile("17710769110");
		g1.setCreate_user("admin");
		g1.setUpdate_user("admin");
		g1.setIsdel(1);
		
		g.addGoddess(g1);
	}
}

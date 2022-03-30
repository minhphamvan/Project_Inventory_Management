package inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import inventory.dao.UserDao;
import inventory.dao.impl.UserDaoImpl;
import inventory.entity.User;

@Controller
public class AdminController {
	
	@Autowired
	private UserDao<User> userDao;
	
	@RequestMapping("/admin")
	public String test() {
		List<User> users = userDao.findByProperty("username" , "minhpham");
		System.out.println(users);
		
		return "admin/dashboard";
	}
}

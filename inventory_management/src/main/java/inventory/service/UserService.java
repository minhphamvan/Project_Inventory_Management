package inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventory.dao.UserDao;
import inventory.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao<User> userDao;
	
	public List<User> findByProperty(String property, Object value){
		return userDao.findByProperty(property, value);
	}
}

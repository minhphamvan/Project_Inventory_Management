package inventory.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import inventory.dao.UserDao;
import inventory.entity.User;

@Repository
@Transactional(rollbackOn = Exception.class)
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {

}

package userRegistration.com.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import userRegistration.com.demo.dao.UserDAO;
import userRegistration.com.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		
		return userDAO.findAll();
		
	}

	@Override
	@Transactional
	public User findById(int theId) {
		
		return userDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		userDAO.save(theUser);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		userDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public void updatePartialUser(int theId, Map<Object, Object> fileds) {
	
		userDAO.updatePartialUser(theId, fileds);
		
	}

}

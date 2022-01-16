package userRegistration.com.demo.service;

import java.util.List;
import java.util.Map;

import userRegistration.com.demo.entity.User;

public interface UserService {

    public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUserId);
	
	public void deleteById(int theId);
	
	public void updatePartialUser(int theId,Map<Object, Object> fileds);
}

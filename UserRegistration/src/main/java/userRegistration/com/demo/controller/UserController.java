package userRegistration.com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userRegistration.com.demo.entity.User;
import userRegistration.com.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService theUserService) {
		this.userService = theUserService;
	}

	@GetMapping("/users")
	public List<User> findAll() {

		return userService.findAll();
	}

	// add mapping for POST /User to add new user
	@PostMapping("/users")
	public User addEmployee(@RequestBody User theUser) {
		//theUser.setUserId(0);
		userService.save(theUser);
		return theUser;
	}
	
	@GetMapping("/users/{user_id}")
	public User findById(@PathVariable int user_id) {
		User user= userService.findById(user_id);
		
		if(user==null) {
			throw new RuntimeException("User Id is not found..."+user_id);
		}
	
		return user;

	}
	
	
		@PutMapping("/users")
		public User updateUser(@RequestBody User theUser) {
			userService.save(theUser);
			
			return theUser;
		}
		
		@DeleteMapping("/users/{user_id}")
		public String deleteEmployee(@PathVariable int user_id) {
			
			User tempUser=userService.findById(user_id);
			
			if(tempUser==null) {
				throw new RuntimeException("This User does not exist in database.."+user_id);
			}
			
			userService.deleteById(user_id);
			
			return "Deleted User Id:"+user_id;
			
		}
		
		@PatchMapping("/users/{user_id}")
		public ResponseEntity<User> updateSomeUser(@PathVariable int user_id,@RequestBody Map<Object,Object> fileds) {
			//userService.save(theUser);
			userService.updatePartialUser(user_id, fileds);
			return null;
		}

}

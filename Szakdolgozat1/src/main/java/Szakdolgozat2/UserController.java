package Szakdolgozat2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "User") //localhost:8080/User
public class UserController {
	
	@Autowired
	
	private final UserService userService; 
	
	public UserController(UserService userService) { 
		this.userService = userService;
	}

	@GetMapping  //Userek lekérése
      public List<User> getUsers(){
		return userService.getUsers();
	} 
	@PostMapping  //Új user regisztrálása
	public void registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}
	@PostMapping("/login")  //User bejelentkezése
	public String authenticateUser(@RequestBody User user) {
		return userService.authenticateUser(user);
	}
	@PatchMapping //User adatainak módosítása
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	@DeleteMapping  //User törlése
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}
}

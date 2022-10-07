package com.in28minutes.restServices.restfulwebservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.restServices.restfulwebservices.Dao.UserDao;
import com.in28minutes.restServices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResources {
private UserDao userDao;

public UserResources(UserDao userDao) {
	this.userDao=userDao;
}
	//GET/Users
@GetMapping("/users")
	public List<User> retreiveAllUsers(){
		return userDao.findaAll();
		
	}
//http://localhost:8080/users
//webMvcLinkBuilder
	/*
	 * //public EntityModel<User> retreiveUsers(@PathVariable int id){ User user=
	 * userDao.findOne(id); if(user==null) throw new
	 * UserNotFoundException("Id "+id);
	 * EntityModel<User>=entityModel=EntityModel.of(user);
	 * WebMvcBuilder link=linkTo(this.getclass();
	 * entityModel.add(link)
	 * return user;
	 */

@GetMapping("/users/{id}")
public User retreiveUsers(@PathVariable int id){
	User user= userDao.findOne(id);
	if(user==null) 
		throw new UserNotFoundException("Id "+id);
	
	return user;
	
}

@DeleteMapping("/users/{id}")
public void deleteUsersByID(@PathVariable int id){
	User user= userDao.deleteOne(id);
	
}
//Post/users
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User user){
	User savedUser=userDao.saveUser(user);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();   
	return ResponseEntity.created(location).build();
}
}
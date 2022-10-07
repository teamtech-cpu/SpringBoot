package com.in28minutes.restServices.restfulwebservices.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.in28minutes.restServices.restfulwebservices.user.User;

@Component
public class UserDao {
	//JPA/Hibernate>Database
	//static List we will create in here
	
	private static List<User> users = new ArrayList<>();
	 private static int usersCount=3;
	static {
		users.add(new User(1,"sunil",LocalDate.now().minusYears(30)));
		users.add(new User(2,"s",LocalDate.now().minusYears(10)));
		users.add(new User(3,"saikumar",LocalDate.now().minusYears(20)));

	}

	//to get all users
	
	public List<User> findaAll(){
		return users;
		
	}
	public User saveUser(User user){
		user.setId(++usersCount);
		users.add(user);
	return user;
	}
	public User findOne(int id){
		Predicate<User> predicate=user->user.getId().equals(id);
		//return users.stream().filter(predicate).findFirst().get();
		return users.stream().filter(predicate).findFirst().orElse(null);

	}
	public User deleteOne(int id){
		Predicate<User> predicate=user->user.getId().equals(id);
		//return users.stream().filter(predicate).findFirst().get();
		users.removeIf(predicate);
		return users.stream().filter(predicate).findFirst().orElse(null);

	}
}

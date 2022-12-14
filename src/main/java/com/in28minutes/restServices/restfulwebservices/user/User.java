package com.in28minutes.restServices.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
private Integer id;

@JsonProperty("user_name")
private String name;

private LocalDate birthDate;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public LocalDate getBirthDate() {
	return birthDate;
}

public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
}

public User(Integer id, String name, LocalDate birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
}


}

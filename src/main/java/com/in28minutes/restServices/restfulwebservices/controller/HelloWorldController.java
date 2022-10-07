package com.in28minutes.restServices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restServices.restfulwebservices.model.HelloWorldBean;

//REST API
//wwe can expose rest api from here
@RestController
public class HelloWorldController {
/*//HELLO WORLD
	@RequestMapping(method=RequestMethod.GET,path = "/hello-world")
	public String helloWorld() {
		return "helloworld";
	*/
private MessageSource messageSource;

public HelloWorldController(MessageSource messageSource) {
	this.messageSource=messageSource;
}
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "helloworld";
	}
	@GetMapping("/hello-world-internationalized")
	public String  helloworldInternationalized(){
		Locale locale=LocaleContextHolder.getLocale();
		 return messageSource.getMessage("good.morning.message", null,locale);
		//return "hello -world";
	}
	@GetMapping(path = "/world")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("helloworld");
	}
	@GetMapping(path = "/world/path-variable/{name}")
	public HelloWorldBean helloWorldpath( @PathVariable String name) {
		return new HelloWorldBean(
				String.format("Hello WOrld, %s",name));
	}
	
}

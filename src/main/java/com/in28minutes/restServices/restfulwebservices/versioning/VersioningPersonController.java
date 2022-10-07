package com.in28minutes.restServices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
		public PersonV1 getFirstVersionOfPerson() {
			return new PersonV1("Bob charlies");
		}

	@GetMapping(path="/person",params= "version=1")
		public PersonV1 getFirstVersionOfPersonRequest() {
			return new PersonV1("Bob charlies");
		}
	@GetMapping(path="/person",headers = "version=1")
	public PersonV1 getFirstVersionOfPersonHeadersParame() {
		return new PersonV1("Bob charlies");
	}

	
}

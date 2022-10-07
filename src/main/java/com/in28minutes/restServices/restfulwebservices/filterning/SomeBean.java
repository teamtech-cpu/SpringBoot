package com.in28minutes.restServices.restfulwebservices.filterning;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("field1")
@JsonFilter("someBeanFilter")
public class SomeBean {

	private String field1;
	
	@JsonIgnore
	private String field2;
	private String field;
	public SomeBean(String field1, String field2, String field) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field = field;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField() {
		return field;
	}
	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field=" + field + "]";
	}

}

package com.sgcharts.beanvalidationexample.chapter12.propertypath;

import javax.validation.constraints.Size;

class Person {

	@Size(min = 5)
	String name;

	Person(String name) {
		this.name = name;
	}
}

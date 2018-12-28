package com.sgcharts.beanvalidationexample.chapter12.propertypath;

import javax.validation.Valid;

class Apartment {

	@Valid
	Person resident;

	Apartment(Person resident) {
		this.resident = resident;
	}
}

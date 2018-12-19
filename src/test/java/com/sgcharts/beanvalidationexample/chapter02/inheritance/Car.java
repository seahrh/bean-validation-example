//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.inheritance;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Car {

	private String manufacturer;

	Car(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@NotNull(message = "{com.sgcharts.beanvalidationexample.chapter02.inheritance.Car.manufacturer.notNull.message}")
	public String getManufacturer() {
		return manufacturer;
	}

	//...
}
//end::include[]

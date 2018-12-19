//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.inheritance;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class RentalCar extends Car {

	private String rentalStation;

	RentalCar(String manufacturer, String rentalStation) {
		super(manufacturer);
		this.rentalStation = rentalStation;
	}

	@NotNull(message = "{com.sgcharts.beanvalidationexample.chapter02.inheritance.Car.rentalStation.notNull.message}")
	public String getRentalStation() {
		return rentalStation;
	}

	//...
}
//end::include[]

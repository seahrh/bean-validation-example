//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.inheritance;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class RentalCar extends Car {

	private String rentalStation;

	@NotNull
	public String getRentalStation() {
		return rentalStation;
	}

	//...
}
//end::include[]

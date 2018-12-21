//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.parameter;

//end::include[]

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//tag::include[]
class RentalStation {

	RentalStation(@NotNull String name) {
		//...
	}

	public void rentCar(
			@NotNull Customer customer,
			@NotNull @Future Date startDate,
			@Min(1) int durationInDays) {
		//...
	}
}
//end::include[]

//tag::include[]
package com.sgcharts.beanvalidationexample.chapter06;

//end::include[]

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//tag::include[]
class Car {

	@NotNull
	private String manufacturer;

	@NotNull
	@Size(min = 2, max = 14)
	@CheckCase(CaseMode.UPPER)
	private String licensePlate;

	@Min(2)
	private int seatCount;

	Car(String manufacturer, String licencePlate, int seatCount) {
		this.manufacturer = manufacturer;
		this.licensePlate = licencePlate;
		this.seatCount = seatCount;
	}

	//getters and setters ...
}
//end::include[]

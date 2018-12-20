//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.objectgraph;

//end::include[]

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

//tag::include[]
class Car {

	@NotNull(message = "driver must not be null")
	@Valid
	private Person driver;

	Car(Person driver) {
		this.driver = driver;
	}
}
//end::include[]


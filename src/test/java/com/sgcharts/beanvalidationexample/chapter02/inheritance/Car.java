//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.inheritance;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Car {

	private String manufacturer;

	@NotNull
	public String getManufacturer() {
		return manufacturer;
	}

	//...
}
//end::include[]

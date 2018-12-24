//tag::include[]
package com.sgcharts.beanvalidationexample.chapter04;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Car {

	@NotNull(message = "The manufacturer name must not be null")
	private String manufacturer;

	//constructor, getters and setters ...
}
//end::include[]

//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.inheritance.returnvalue;

//end::include[]

import java.util.List;
import javax.validation.constraints.Size;

//tag::include[]
class Car implements Vehicle {

	@Override
	@Size(min = 1)
	public List<Person> getPassengers() {
		//...
		return null;
	}
}
//end::include[]

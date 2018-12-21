//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.inheritance.parameter;

//end::include[]

import javax.validation.constraints.Max;

//tag::include[]
class Car implements Vehicle {

	@Override
	public void drive(@Max(55) int speedInMph) {
		//...
	}
}
//end::include[]

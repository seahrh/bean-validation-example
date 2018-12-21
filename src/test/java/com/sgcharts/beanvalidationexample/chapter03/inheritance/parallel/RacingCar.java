//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.inheritance.parallel;

//end::include[]

//tag::include[]
class RacingCar implements Car, Vehicle {

	@Override
	public void drive(int speedInMph) {
		//...
	}
}
//end::include[]

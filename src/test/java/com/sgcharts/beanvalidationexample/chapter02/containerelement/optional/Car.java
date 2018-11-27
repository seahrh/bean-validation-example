//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.containerelement.optional;

//end::include[]

import java.util.Optional;

//tag::include[]
class Car {

	private Optional<@MinTowingCapacity(1000) Integer> towingCapacity = Optional.empty();

	public void setTowingCapacity(Integer alias) {
		towingCapacity = Optional.of( alias );
	}

	//...

}
//end::include[]

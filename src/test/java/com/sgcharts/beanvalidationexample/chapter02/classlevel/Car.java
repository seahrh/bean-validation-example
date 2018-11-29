//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.classlevel;

//end::include[]

import java.util.List;

//tag::include[]
@ValidPassengerCount
class Car {

	private int seatCount;

	private List<Person> passengers;

	//...
}
//end::include[]

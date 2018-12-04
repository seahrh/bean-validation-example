//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.classlevel;

//end::include[]

import java.util.List;

//tag::include[]
@ValidPassengerCount
class Car {

	private int seatCount;

	private List<Person> passengers;

	Car(int seatCount, List<Person> passengers) {
		this.seatCount = seatCount;
		this.passengers = passengers;
	}

	int seatCount() {
		return seatCount;
	}

	List<Person> passengers() {
		return passengers;
	}
}
//end::include[]

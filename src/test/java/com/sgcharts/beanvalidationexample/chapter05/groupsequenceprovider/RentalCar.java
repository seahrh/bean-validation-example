//tag::include[]
package com.sgcharts.beanvalidationexample.chapter05.groupsequenceprovider;

//end::include[]

import com.sgcharts.beanvalidationexample.chapter05.Car;
import com.sgcharts.beanvalidationexample.chapter05.RentalChecks;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.AssertFalse;

//tag::include[]
@GroupSequenceProvider(RentalCarGroupSequenceProvider.class)
public class RentalCar extends Car {

	@AssertFalse(message = "The car is currently rented out", groups = RentalChecks.class)
	private boolean rented;

	public RentalCar(String manufacturer, String licencePlate, int seatCount) {
		super( manufacturer, licencePlate, seatCount );
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}
}
//end::include[]

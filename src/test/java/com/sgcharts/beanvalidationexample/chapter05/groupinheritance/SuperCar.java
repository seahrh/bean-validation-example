//tag::include[]
package com.sgcharts.beanvalidationexample.chapter05.groupinheritance;

//end::include[]
import com.sgcharts.beanvalidationexample.chapter05.Car;

import javax.validation.constraints.AssertTrue;

//tag::include[]
public class SuperCar extends Car {

	@AssertTrue(
			message = "Race car must have a safety belt",
			groups = RaceCarChecks.class
	)
	private boolean safetyBelt;

	// getters and setters ...

	//end::include[]

	public SuperCar(String manufacturer, String licencePlate, int seatCount) {
		super( manufacturer, licencePlate, seatCount );
	}

	public boolean isSafetyBelt() {
		return safetyBelt;
	}

	public void setSafetyBelt(boolean safetyBelt) {
		this.safetyBelt = safetyBelt;
	}

//tag::include[]
}
//end::include[]

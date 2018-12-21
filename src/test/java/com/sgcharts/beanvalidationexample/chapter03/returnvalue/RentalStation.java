//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.returnvalue;

//end::include[]

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//tag::include[]
class RentalStation {

	@ValidRentalStation
	RentalStation() {
		//...
	}

	@NotNull
	@Size(min = 1)
	public List<@NotNull Customer> getCustomers() {
		//...
		return null;
	}
}
//end::include[]

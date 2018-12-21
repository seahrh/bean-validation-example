//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.inheritance.returnvalue;

//end::include[]

import java.util.List;
import javax.validation.constraints.NotNull;

//tag::include[]
public interface Vehicle {

	@NotNull
	List<Person> getPassengers();
}
//end::include[]

//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.objectgraph.containerelement;

//end::include[]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

//tag::include[]
class Car {

	private List<@NotNull @Valid Person> passengers = new ArrayList<>();

	private Map<@Valid Part, List<@Valid Manufacturer>> partManufacturers = new HashMap<>();

	void addPassenger(Person passenger) {
		this.passengers.add(passenger);
	}

	void addPart(Part part, List<Manufacturer> manufacturers) {
		this.partManufacturers.put(part, manufacturers);
	}
}
//end::include[]

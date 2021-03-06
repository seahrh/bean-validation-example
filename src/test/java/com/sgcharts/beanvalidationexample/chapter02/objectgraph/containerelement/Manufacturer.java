//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.objectgraph.containerelement;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Manufacturer {

	@NotNull
	private String name;

	Manufacturer(String name) {
		this.name = name;
	}
}
//end::include[]

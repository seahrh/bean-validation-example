//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.objectgraph.containerelement;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Part {

	@NotNull
	private String name;

	Part(String name) {
		this.name = name;
	}
}
//end::include[]

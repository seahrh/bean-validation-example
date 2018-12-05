//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.containerelement.nested;

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

//tag::include[]
package com.sgcharts.beanvalidationexample.chapter05;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Person {

	@NotNull
	private String name;

	Person(String name) {
		this.name = name;
	}

	// getters and setters ...
}
//end::include[]

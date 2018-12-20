//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.objectgraph;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Person {

	@NotNull
	private String name;

	Person(String name) {
		this.name = name;
	}
}
//end::include[]

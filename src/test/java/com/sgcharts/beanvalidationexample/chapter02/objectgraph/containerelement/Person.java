//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.objectgraph.containerelement;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Person {

	@NotNull
	private String name;

	//...
}
//end::include[]

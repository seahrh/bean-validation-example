//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.containerelement.nested;

//end::include[]

import javax.validation.constraints.NotNull;

//tag::include[]
class Manufacturer {

	@NotNull
	private String name;

	//...
}
//end::include[]

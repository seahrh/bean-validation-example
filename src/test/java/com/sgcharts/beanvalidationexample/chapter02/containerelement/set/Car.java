//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.containerelement.set;

import java.util.HashSet;
import java.util.Set;

//tag::include[]
class Car {

	private Set<@ValidPart String> parts = new HashSet<>();

	public void addPart(String part) {
		parts.add( part );
	}

	//...

}
//end::include[]

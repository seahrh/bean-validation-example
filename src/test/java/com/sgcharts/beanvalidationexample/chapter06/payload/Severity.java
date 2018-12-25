package com.sgcharts.beanvalidationexample.chapter06.payload;

import javax.validation.Payload;

//tag::include[]
class Severity {
	public interface Info extends Payload {
	}

	public interface Error extends Payload {
	}
}
//end::include[]

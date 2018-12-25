package com.sgcharts.beanvalidationexample.chapter06.payload;

import javax.validation.constraints.NotNull;

//tag::include[]
class ContactDetails {
	@NotNull(message = "Name is mandatory", payload = Severity.Error.class)
	private String name;

	@NotNull(message = "Phone number not specified, but not mandatory",
			payload = Severity.Info.class)
	private String phoneNumber;

	// ...
}
//end::include[]

package com.sgcharts.beanvalidationexample.chapter06.constraintvalidatorpayload;

//tag::include[]
class Address {
	@ZipCode
	private String zipCode;

	Address(String zipCode) {
		this.zipCode = zipCode;
	}
}
//end::include[]

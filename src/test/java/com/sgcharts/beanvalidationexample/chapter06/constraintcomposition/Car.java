package com.sgcharts.beanvalidationexample.chapter06.constraintcomposition;

class Car {

	@ValidLicensePlate
	private String licensePlate;

	Car(String licensePlate) {
		this.licensePlate = licensePlate;
	}
}

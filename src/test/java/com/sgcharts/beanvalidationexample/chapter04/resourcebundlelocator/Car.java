package com.sgcharts.beanvalidationexample.chapter04.resourcebundlelocator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

class Car {

	@NotNull
	private String licensePlate;

	@Max(300)
	private int topSpeed = 400;

}

//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.containerelement.custom;

//end::include[]

//tag::include[]
class Car {

	private GearBox<@MinTorque(100) Gear> gearBox;

	public void setGearBox(GearBox<Gear> gearBox) {
		this.gearBox = gearBox;
	}

	//...

}
//end::include[]

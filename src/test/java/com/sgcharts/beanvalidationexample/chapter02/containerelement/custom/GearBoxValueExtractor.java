//tag::include[]
package com.sgcharts.beanvalidationexample.chapter02.containerelement.custom;

//end::include[]

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

// A ValueExtractor must be registered for the custom type allowing to retrieve the value(s) to validate
// (see Chapter 7, Value extraction for more information about how to implement your own ValueExtractor
// and how to register it).

//tag::include[]
class GearBoxValueExtractor implements ValueExtractor<GearBox<@ExtractedValue ?>> {

	@Override
	public void extractValues(GearBox<@ExtractedValue ?> originalValue, ValueExtractor.ValueReceiver receiver) {
		receiver.value( null, originalValue.getGear() );
	}
}
//end::include[]

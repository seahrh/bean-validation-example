//tag::include[]
package com.sgcharts.beanvalidationexample.chapter03.crossparameter;

//end::include[]

import java.util.List;

//tag::include[]
class Car {

	@LuggageCountMatchesPassengerCount(piecesOfLuggagePerPassenger = 2)
	public void load(List<Person> passengers, List<PieceOfLuggage> luggage) {
		//...
	}
}
//end::include[]

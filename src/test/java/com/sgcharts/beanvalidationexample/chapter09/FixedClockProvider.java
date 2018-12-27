//tag::include[]
package com.sgcharts.beanvalidationexample.chapter09;

import java.time.Clock;
import java.time.ZonedDateTime;

import javax.validation.ClockProvider;

//tag::include[]
class FixedClockProvider implements ClockProvider {

	private Clock clock;

	FixedClockProvider(ZonedDateTime dateTime) {
		clock = Clock.fixed( dateTime.toInstant(), dateTime.getZone() );
	}

	@Override
	public Clock getClock() {
		return clock;
	}

}
//end::include[]

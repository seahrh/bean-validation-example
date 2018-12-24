package com.sgcharts.beanvalidationexample.chapter05;

import com.sgcharts.beanvalidationexample.chapter05.CarChecks;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ Default.class, CarChecks.class, DriverChecks.class })
public interface OrderedChecks {
}

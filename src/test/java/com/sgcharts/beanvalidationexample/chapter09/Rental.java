package com.sgcharts.beanvalidationexample.chapter09;

import javax.validation.constraints.Future;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

class Rental {
    @PastOrPresent
    private ZonedDateTime startTime;
    @Future
    private ZonedDateTime endTime;
    Rental(ZonedDateTime startTime, ZonedDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

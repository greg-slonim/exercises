package com.gslonim.coding.systems;

import org.junit.Test;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class RunwayLandingLimiterTest {
    /*
    There is only one runway in an airport.
    There should be some time gap between one airplane landing and other airplane coming(example 3min).

    Eg: There is a plane landing at 10:00 AM and other plane is in the request to land at 10:03 AM.
    If there is a request that comes for 10:01 it should not be accepted.

    There will be multiple requests coming(with time) and we should be able to determine if we can handle the request or not
    to land the plane on the runway.
    */
    private static final Duration LANDING_THRESHOLD = Duration.of(3, ChronoUnit.MINUTES);
    private static final OffsetDateTime START_TIME = OffsetDateTime.now();
    private RunwayLandingLimiter limiter = new RunwayLandingLimiterImpl(1, LANDING_THRESHOLD);

    @Test
    public void should_allow_landing_with_sufficient_time_between_landing_requests() {
        OffsetDateTime inFiveMinutesFromNow = START_TIME.plusMinutes(5);

        assertThat(limiter.requestToLand(START_TIME)).isTrue();
        assertThat(limiter.requestToLand(inFiveMinutesFromNow)).isTrue();
    }

    @Test
    public void should_not_allow_landing_with_insufficient_time_between_landing_requests() {
        assertThat(limiter.requestToLand(START_TIME)).isTrue();
        assertThat(limiter.requestToLand(startTimePlus(1))).isFalse();
        assertThat(limiter.requestToLand(startTimePlus(5))).isTrue();
        assertThat(limiter.requestToLand(startTimePlus(3))).isFalse();
        assertThat(limiter.requestToLand(startTimeMinusMinutes(10))).isTrue();
    }

    private static OffsetDateTime startTimePlus(int minutes) {
        return START_TIME.plusMinutes(minutes);
    }
    private static OffsetDateTime startTimeMinusMinutes(int minutes) {
        return START_TIME.minusMinutes(minutes);
    }
}
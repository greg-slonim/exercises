package com.gslonim.systemdesign.ratelimiters;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunwayLandingLimiterImpl implements RunwayLandingLimiter {
    private final int numberOfRunways;
    private final Duration safeLandingThreshold;
    private final Queue<OffsetDateTime> landingQueue = new PriorityQueue<>(100);

    public RunwayLandingLimiterImpl(int numberOfRunways, Duration safeLandingThreshold) {
        this.numberOfRunways = numberOfRunways;
        this.safeLandingThreshold = safeLandingThreshold;
    }

    @Override
    public boolean requestToLand(OffsetDateTime landingTime) {
        if (landingQueue.isEmpty()) {
            landingQueue.offer(landingTime);
            return true;
        }
        for (OffsetDateTime nextLandingTimeRequest : landingQueue) {
            if (durationExceedsLimit(landingTime, nextLandingTimeRequest)) {
                return false;
            }
        }
        landingQueue.offer(landingTime);
        return true;
    }

    private boolean durationExceedsLimit(OffsetDateTime landingTime, OffsetDateTime nextLandingTimeRequest) {
        return Math.abs(Duration.between(nextLandingTimeRequest, landingTime).getSeconds()) < safeLandingThreshold.getSeconds();
    }
}
